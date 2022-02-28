package framework.utils;
import framework.response.FacetList;
import framework.response.Result;
import framework.response.record.Display;
import org.apache.axis.encoding.Base64;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;

import javax.xml.soap.SOAPBody;
import java.io.UnsupportedEncodingException;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static framework.utils.Constants.SIZE_IN_BYTES;

public class Utils {


    public static Result parseStringCompressedResponseToResult(String str)
    {
        JSONObject response = XML.toJSONObject(str);
        JSONObject envelope = (JSONObject) response.get("soapenv:Envelope");
        JSONObject body = envelope.getJSONObject("soapenv:Body");
        JSONObject compressedResponse = body.getJSONObject("ns1:searchXCompressedResponse");
        JSONObject compressReturn = compressedResponse.getJSONObject("searchXCompressedReturn");
        String content = compressReturn.get("content").toString();
        String decompressedContent = Utils.decompressString(content);
        JSONObject decompressed = XML.toJSONObject(decompressedContent);
        JSONObject xmlFragment =  decompressed.getJSONObject("xml-fragment");
        JSONObject jagroot = xmlFragment.getJSONObject("sear:JAGROOT");
        JSONObject result = jagroot.getJSONObject("sear:RESULT");
        Result res = new Result();

        res.loadDocSet(result);
        res.loadFacetList(result);
        res.loadHighlights(result);
        return res;
    }

    public static Result parseStringResponseToResultSearchX(String str)
    {
        JSONObject response = XML.toJSONObject(str);
        JSONObject envelope = (JSONObject) response.get("soapenv:Envelope");
        JSONObject body = envelope.getJSONObject("soapenv:Body");
        JSONObject resp = body.getJSONObject("ns1:searchXResponse");
        JSONObject jsonReturn = resp.getJSONObject("searchXReturn");
        JSONObject xmlFragment =  jsonReturn.getJSONObject("xml-fragment");
        JSONObject jagroot =  xmlFragment.getJSONObject("sear:JAGROOT");
        JSONObject result = jagroot.getJSONObject("sear:RESULT");
        Result res = new Result();

        res.loadDocSet(result);
        res.loadFacetList(result);
        res.loadHighlights(result);
        return res;
    }

    public static FacetList parseStringResponseToFacetListFacetCountCompressed(String str)
    {
        JSONObject response = XML.toJSONObject(str);

        JSONObject envelope = (JSONObject) response.get("soapenv:Envelope");
        JSONObject body = envelope.getJSONObject("soapenv:Body");
        JSONObject resp =  body.getJSONObject("ns1:countFacetsCompressedWithCategoriesResponse");
        JSONObject jsonReturn = resp.getJSONObject("countFacetsCompressedWithCategoriesReturn");
        String content =  jsonReturn.getString("content");
        String decompressedContent = Utils.decompressString(content);
        JSONObject r = XML.toJSONObject(decompressedContent);
        JSONObject xmlFragment = r.getJSONObject("xml-fragment");
        FacetList facetList = new FacetList();
        facetList.load(xmlFragment);
        facetList.print();
        return facetList;
    }


    public static String decompressString(String compressed)  {

        byte[] output2 = Base64.decode(compressed);
        // Decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(output2);
        byte[] result = new byte[SIZE_IN_BYTES];
        int resultLength = 0;
        try {
            resultLength = decompresser.inflate(result);
        } catch (DataFormatException dataFormatException) {
            dataFormatException.printStackTrace();
        }
        decompresser.end();

        // Decode the bytes into a String
        String outputString = null;
        outputString = new String(result, 0, resultLength, StandardCharsets.UTF_8);
        //System.out.println("Deflated String:" + outputString);
    return outputString;
}

    public static String normalizeString(String str)
    {
        str = str.toLowerCase(Locale.ROOT);

        if (str.startsWith("a "))
        {
            return str.replaceFirst("^a ", "");
        }
        if (str.startsWith("the "))
        {
            return str.replaceFirst("^the ", "");
        }

        return str;
    }

    public static Result parseResponseToResult(SOAPBody body)
    {

        Node firstResponse = body.getChildNodes().item(0);
        if (firstResponse.getNodeName().contains("Fault"))
        {
            //TODO check return code
            return null;
        }

        Node searchXResponse = body.getChildNodes().item(0);
        Node searchXReturn = searchXResponse.getChildNodes().item(0);
        Node xmlFragment = searchXReturn.getChildNodes().item(0);
        //TODO check fault code
        JSONObject fragment = XML.toJSONObject(xmlFragment.toString());
        JSONObject xmlns = (JSONObject)fragment.get("xml-fragment");
        JSONObject jagroot = xmlns.getJSONObject("sear:JAGROOT");
        JSONObject res = jagroot.getJSONObject("sear:RESULT");

        Result result = new Result();

        result.loadDocSet(res);
        result.loadFacetList(res);
        result.loadHighlights(res);

        return result;
    }

    public static Result parseResponseToResultCompressed(SOAPBody body)  {
        System.out.println("Body returned: " + body);
        Node searchXCompressedResponse = body.getChildNodes().item(0);
        if (searchXCompressedResponse.getNodeName().contains("Fault"))
        {
            //TODO check return code
            return null;
        }

        Node searchXCompressedReturn = searchXCompressedResponse.getChildNodes().item(0);
        Node compressedResult = searchXCompressedReturn.getChildNodes().item(0);
        String decompressed = decompressString(compressedResult.toString());
        JSONObject fragment = XML.toJSONObject(decompressed);
        //TODO check fault code
        JSONObject xmlns = (JSONObject)fragment.get("xml-fragment");
        JSONObject jagroot = xmlns.getJSONObject("sear:JAGROOT");
        JSONObject res = jagroot.getJSONObject("sear:RESULT");

        Result result = new Result();

        result.loadDocSet(res);
        result.loadFacetList(res);
        result.loadHighlights(res);

        return result;
    }

    public static boolean checkQueryInDisplay(Display display, String query)
    {
        boolean searchTermExists = false;
        String title = display.getTitle();
        String description = display.getDescription();
        String creator = display.getCreator();
        String subject = display.getSubject();
        for (String term : query.split(" "))
        {
            if (title != null)
            {
                searchTermExists = searchTermExists || title.toLowerCase().contains(term);
            }

            if (description != null)
            {
                searchTermExists = searchTermExists || description.toLowerCase().contains(term);
            }

            if (creator != null)
            {
                searchTermExists = searchTermExists || creator.toLowerCase().contains(term);
            }

            if (subject != null)
            {
                searchTermExists = searchTermExists || subject.toLowerCase().contains(term);
            }
        }
        return searchTermExists;
    }
}
