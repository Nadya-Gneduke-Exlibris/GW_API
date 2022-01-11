package framework.utils;
import framework.response.FacetList;
import framework.response.Result;
import org.apache.axis.encoding.Base64;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;

import javax.xml.soap.SOAPBody;
import java.io.UnsupportedEncodingException;

import java.util.Locale;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Utils {


    public static Result parseStringCompressedResponseToResult(String str)
    {
        JSONObject response = XML.toJSONObject(str);
        JSONObject envelope = (JSONObject) response.get("soapenv:Envelope");
        JSONObject body = (JSONObject) envelope.getJSONObject("soapenv:Body");
        JSONObject compressedResponse = (JSONObject) body.getJSONObject("ns1:searchXCompressedResponse");
        JSONObject compressReturn = (JSONObject) compressedResponse.getJSONObject("searchXCompressedReturn");
        String content = compressReturn.get("content").toString();
        String decompressedContent = Utils.decompressString(content);
        JSONObject decompressed = XML.toJSONObject(decompressedContent);
        JSONObject xmlFragment = (JSONObject) decompressed.getJSONObject("xml-fragment");
        JSONObject jagroot = (JSONObject) xmlFragment.getJSONObject("sear:JAGROOT");
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
        JSONObject body = (JSONObject) envelope.getJSONObject("soapenv:Body");
        JSONObject resp = (JSONObject) body.getJSONObject("ns1:searchXResponse");
        JSONObject jsonReturn = (JSONObject) resp.getJSONObject("searchXReturn");
        JSONObject xmlFragment = (JSONObject) jsonReturn.getJSONObject("xml-fragment");
        JSONObject jagroot = (JSONObject) xmlFragment.getJSONObject("sear:JAGROOT");
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
        System.out.println(str);
        JSONObject envelope = (JSONObject) response.get("soapenv:Envelope");
        JSONObject body = (JSONObject) envelope.getJSONObject("soapenv:Body");
        JSONObject resp = (JSONObject) body.getJSONObject("ns1:countFacetsCompressedWithCategoriesResponse");
        System.out.println(resp);
        JSONObject jsonReturn = (JSONObject) resp.getJSONObject("countFacetsCompressedWithCategoriesReturn");
        System.out.println(jsonReturn);
        String content =  jsonReturn.getString("content");
        System.out.println(content);
        String decompressedContent = Utils.decompressString(content);
        System.out.println(decompressedContent);
        JSONObject r = XML.toJSONObject(decompressedContent);
        System.out.println(r);
        JSONObject xmlFragment = (JSONObject) r.getJSONObject("xml-fragment");
        System.out.println(xmlFragment);
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
        byte[] result = new byte[1000000];
        int resultLength = 0;
        try {
            resultLength = decompresser.inflate(result);
        } catch (DataFormatException dataFormatException) {
            dataFormatException.printStackTrace();
        }
        decompresser.end();

        // Decode the bytes into a String
        String outputString = null;
        try {
            outputString = new String(result, 0, resultLength, "UTF-8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        //System.out.println("Deflated String:" + outputString);
    return outputString;

}



    /**
     * Removes articles at the beginning of string, converts it to lowcase
     * @param str
     * @return
     */
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
        //System.out.println("Body returned: " + body);
        Node a = body.getChildNodes().item(0);
        if (a.getNodeName().contains("Fault"))
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

        System.out.println("Node searchXCompressedResponse " + searchXCompressedResponse);
        Node searchXCompressedReturn = searchXCompressedResponse.getChildNodes().item(0);
        System.out.println("Node searchXCompressedReturn " + searchXCompressedReturn);
        Node compressedResult = searchXCompressedReturn.getChildNodes().item(0);
        System.out.println("Node compressedResult " + compressedResult);
        //String decompressed = decompressStringAsUTF8(compressedResult.toString().getBytes("UTF-8"));
        String decompressed = decompressString(compressedResult.toString());
        System.out.println("Decompress " + decompressed);


        //TODO check fault code
        JSONObject fragment = XML.toJSONObject(decompressed);
        System.out.println("fragment: " + fragment);
        JSONObject xmlns = (JSONObject)fragment.get("xml-fragment");
        System.out.println("xmlns: " + xmlns);
        JSONObject jagroot = xmlns.getJSONObject("sear:JAGROOT");
        System.out.println("jagroot: " + jagroot);
        JSONObject res = jagroot.getJSONObject("sear:RESULT");
        System.out.println("res: " + res);

        Result result = new Result();

        result.loadDocSet(res);
        result.loadFacetList(res);
        result.loadHighlights(res);

        return result;
    }







}
