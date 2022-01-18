package framework.service.soap;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.Result;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchX;
import framework.service.param.SearchParamSearchXExtended;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;



import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import static framework.utils.Constants.API_PREVIEW;
import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.LOADBALANCER;
import static framework.utils.Constants.SEARCHXENDING;

public class SoapWebService {
    private SOAPBody body;
    private String soapAction;



    public SoapWebService()
    {

        this.soapAction = "ddd";
    }

    public SOAPBody callSoapWebServiceSearchXExtended(String frontend, SearchParamSearchXExtended param, boolean compressed) {
        try {

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            System.out.println("Frontend " + frontend);

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestSearchXExtended(param, compressed), frontend);

            body = soapResponse.getSOAPBody();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
        return body;
    }



    public static String callSoapServiceWithRequest(String url, String xmlRequest, String contentType)
    {
        try {
            //String url = "http://api1.ci.cdi.dc04.hosted.exlibrisgroup.com:8011/PrimoWebServices/services/primo/JaguarPrimoSearcher";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // change these values as per soapui request on top left of request, click on RAW, you will find all the headers
            con.setRequestMethod("POST");
            String content = "%s; charset=utf-8".format(contentType);
            con.setRequestProperty("Content-Type", content);
            //con.setRequestProperty("Content-Type","text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xmlRequest);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // You can play with response which is available as string now:
            String finalvalue= response.toString();
            System.out.println(finalvalue);

            return finalvalue;
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String callSoapServiceWithRequestGet(String url, String contentType)
    {
        try {
            //String url = "http://api1.ci.cdi.dc04.hosted.exlibrisgroup.com:8011/PrimoWebServices/services/primo/JaguarPrimoSearcher";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // change these values as per soapui request on top left of request, click on RAW, you will find all the headers
            con.setRequestMethod("GET");
            String content = "%s; charset=utf-8".format(contentType);
            con.setRequestProperty("Content-Type", content);
            //con.setRequestProperty("Content-Type","text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //wr.writeBytes();
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // You can play with response which is available as string now:
            String finalvalue= response.toString();
            System.out.println(finalvalue);

            return finalvalue;
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }


    public static SOAPBody callSoapWebServiceXML(String url, String xmlRequest) {
        SOAPBody body = null;
        try {

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            System.out.println(url);
            MessageFactory messageFactory = MessageFactory.newInstance();


            MimeHeaders mimeHeaders = new MimeHeaders();
            mimeHeaders.setHeader("SOAPAction", "ddd");
            //mimeHeaders.addHeader("Content-Type", "text/xml");
            mimeHeaders.addHeader("cache-control", "no-cache");

            mimeHeaders.addHeader("Content-Type", "application/soap+xml");

            SOAPMessage soapMessage = messageFactory.createMessage(mimeHeaders, new ByteArrayInputStream(xmlRequest.getBytes()));

            /*System.out.println("Request SOAP Message:");
            soapMessage.writeTo(System.out);
            System.out.println("\n");*/

            SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

            body = soapResponse.getSOAPBody();
            soapConnection.close();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
        return body;
    }

    public SOAPBody callSoapWebServiceSearchX(SearchParamSearchX param) {
        try {

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            //SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), this.param.getFrontend());

            String frontend = "http://fe.p.prod.primo.saas.exlibrisgroup.com:1701/PrimoWebServices/services/primo/JaguarPrimoSearcher";
            //String frontend = "http://api1.test.cdi.dc04.hosted.exlibrisgroup.com:8011/PrimoWebServices/services/primo/JaguarPrimoSearcher";


            System.out.println(frontend);

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestSearchX(param), frontend);

            body = soapResponse.getSOAPBody();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
        return body;
    }



    private SOAPMessage createSOAPRequestSearchXExtended(SearchParamSearchXExtended param, boolean compressed) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelopeSearchXExtended2(soapMessage, param, compressed);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        //headers.addHeader("Content-Type", "text/xml");
        headers.addHeader("Cache-Control", "no-cache");
        headers.addHeader("Content-Type", "text/xml;charset=utf-8");
        //"Content-type", "text/xml; charset=utf-8"




        soapMessage.saveChanges();



        MimeHeaders h1 = soapMessage.getMimeHeaders();
        JSONArray response = new JSONArray();
        if (headers != null) {
            Iterator headersIterator = h1.getAllHeaders();

            while(headersIterator.hasNext()) {
                MimeHeader mimheader = (MimeHeader)headersIterator.next();
                JSONObject header = new JSONObject();
                header.accumulate("name", mimheader.getName());
                header.accumulate("value", mimheader.getValue());
                response.put(header);
            }
        }
        System.out.println(response);


        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

    private SOAPMessage createSOAPRequestSearchX(SearchParamSearchX param) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelopeSearchX(soapMessage, param);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }




    private void createSoapEnvelopeSearchXExtended(SOAPMessage soapMessage, SearchParamSearchXExtended param, boolean compressed) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myApi = "api";
        String myNamespaceURI = "http://api.ws.primo.exlibris.com";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myApi, myNamespaceURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchX;
        if (compressed == true)
        {
            searchX = soapBody.addChildElement("searchXCompressed", myApi);
        }
        else
        {
            searchX = soapBody.addChildElement("searchX", myApi);
        }

        SOAPElement query = searchX.addChildElement("query", myApi);
        query.addTextNode(param.getQuery());
        SOAPElement sort = searchX.addChildElement("sort", myApi);
        sort.addTextNode(param.getSort());
        SOAPElement reverse = searchX.addChildElement("reverse", myApi);
        reverse.addTextNode(param.getReverse());
        SOAPElement strDidumean = searchX.addChildElement("strDidumean", myApi);
        strDidumean.addTextNode(param.getStrDidumean());
        SOAPElement language = searchX.addChildElement("language", myApi);
        language.addTextNode(param.getLanguage());
        SOAPElement strFrom = searchX.addChildElement("strFrom", myApi);
        strFrom.addTextNode(param.getStrFrom());
        SOAPElement strTake = searchX.addChildElement("strTake", myApi);
        strTake.addTextNode(param.getStrTake());
        SOAPElement asFull = searchX.addChildElement("asFull", myApi);
        asFull.addTextNode(param.getAsFull());
        SOAPElement institution = searchX.addChildElement("institution", myApi);
        institution.addTextNode(param.getInstitution());
        SOAPElement affiliatedUser = searchX.addChildElement("affiliatedUser", myApi);
        affiliatedUser.addTextNode(param.getAffiliatedUser());
        SOAPElement sessionId = searchX.addChildElement("sessionId", myApi);
        sessionId.addTextNode(param.getSessionId());
        SOAPElement version = searchX.addChildElement("version", myApi);
        version.addTextNode(param.getVersion());
        SOAPElement categories = searchX.addChildElement("categories", myApi);
        categories.addTextNode(param.getCategories());
        SOAPElement degree = searchX.addChildElement("degree", myApi);
        degree.addTextNode(param.getDegree());
        SOAPElement explain = searchX.addChildElement("explain", myApi);
        explain.addTextNode(param.getExplain());
        SOAPElement explainDocId = searchX.addChildElement("explainDocId", myApi);
        explainDocId.addTextNode(param.getExplainDocId());
    }

    Name type = new Name() {
        @Override
        public String getLocalName() {
            return "xsi:type";
        }

        @Override
        public String getQualifiedName() {
            return null;
        }

        @Override
        public String getPrefix() {
            return null;
        }

        @Override
        public String getURI() {
            return null;
        }
    };

    Name encoding = new Name() {
        @Override
        public String getLocalName() {
            return "xmlns:soapenc";
        }

        @Override
        public String getQualifiedName() {
            return null;
        }

        @Override
        public String getPrefix() {
            return null;
        }

        @Override
        public String getURI() {
            return null;
        }
    };
    private void createSoapEnvelopeSearchXExtended2(SOAPMessage soapMessage, SearchParamSearchXExtended param, boolean compressed) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myApi = "api";
        String myNamespaceURI = "http://api.ws.primo.exlibris.com";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myApi, myNamespaceURI);


        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchX;
        if (compressed == true)
        {
            searchX = soapBody.addChildElement("searchXCompressed", myApi);

        }
        else
        {
            searchX = soapBody.addChildElement("searchX",myApi);
        }

        //searchX.addAttribute( encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        SOAPElement query = searchX.addChildElement("query", "");
        query.addTextNode(param.getQuery());
        query.addAttribute(type, "soapenc:string");
        query.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");

        SOAPElement sort = searchX.addChildElement("sort", "");
        sort.addAttribute(type, "soapenc:string");
        sort.addTextNode(param.getSort());
        sort.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");

        SOAPElement reverse = searchX.addChildElement("reverse","");
        reverse.addAttribute(type, "xsd:boolean");
        reverse.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        reverse.addTextNode(param.getReverse());

        SOAPElement strDidumean = searchX.addChildElement("strDidumean","");
        strDidumean.addAttribute(type, "soapenc:string");
        strDidumean.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        strDidumean.addTextNode(param.getStrDidumean());

        SOAPElement language = searchX.addChildElement("language","");
        language.addAttribute(type, "soapenc:string");
        language.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        language.addTextNode(param.getLanguage());

        SOAPElement strFrom = searchX.addChildElement("strFrom","");
        strFrom.addAttribute(type, "soapenc:string");
        strFrom.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        strFrom.addTextNode(param.getStrFrom());

        SOAPElement strTake = searchX.addChildElement("strTake","");
        strTake.addAttribute(type, "soapenc:string");
        strTake.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        strTake.addTextNode(param.getStrTake());

        SOAPElement asFull = searchX.addChildElement("asFull","");
        asFull.addAttribute(type, "xsd:boolean");
        asFull.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        asFull.addTextNode(param.getAsFull());

        SOAPElement institution = searchX.addChildElement("institution","");
        institution.addAttribute(type, "soapenc:string");
        institution.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        institution.addTextNode(param.getInstitution());

        SOAPElement affiliatedUser = searchX.addChildElement("affiliatedUser","");
        affiliatedUser.addAttribute(type, "xsd:boolean");
        affiliatedUser.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        affiliatedUser.addTextNode(param.getAffiliatedUser());

        SOAPElement sessionId = searchX.addChildElement("sessionId","");
        sessionId.addAttribute(type, "soapenc:string");
        sessionId.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        sessionId.addTextNode(param.getSessionId());

        SOAPElement version = searchX.addChildElement("version","");
        version.addAttribute(type, "soapenc:string");
        version.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        version.addTextNode(param.getVersion());

        SOAPElement categories = searchX.addChildElement("categories","");
        categories.addAttribute(type, "soapenc:string");
        categories.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        categories.addTextNode(param.getCategories());

        SOAPElement degree = searchX.addChildElement("degree","");
        degree.addAttribute(type, "soapenc:string");
        degree.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        degree.addTextNode(param.getDegree());

        SOAPElement explain = searchX.addChildElement("explain","");
        explain.addAttribute(type, "xsd:boolean");
        explain.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        explain.addTextNode(param.getExplain());

        SOAPElement explainDocId = searchX.addChildElement("explainDocId","");
        explainDocId.addAttribute(type, "soapenc:string");
        explainDocId.addAttribute(encoding, "http://schemas.xmlsoap.org/soap/encoding/");
        explainDocId.addTextNode(param.getExplainDocId());
    }


    private void createSoapEnvelopeSearchX(SOAPMessage soapMessage, SearchParamSearchX param) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myApi = "api";
        String myNamespaceURI = "http://api.ws.primo.exlibris.com";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myApi, myNamespaceURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement searchX = soapBody.addChildElement("searchX", myApi);
        SOAPElement query = searchX.addChildElement("query", myApi);
        query.addTextNode(param.getQuery());
        SOAPElement sort = searchX.addChildElement("sort", myApi);
        sort.addTextNode(param.getSort());
        SOAPElement strDidumean = searchX.addChildElement("strDidumean", myApi);
        strDidumean.addTextNode(param.getStrDidumean());
        SOAPElement language = searchX.addChildElement("language", myApi);
        language.addTextNode(param.getLanguage());
        SOAPElement strFrom = searchX.addChildElement("strFrom", myApi);
        strFrom.addTextNode(param.getStrFrom());
        SOAPElement strTake = searchX.addChildElement("strTake", myApi);
        strTake.addTextNode(param.getStrTake());
        SOAPElement asFull = searchX.addChildElement("asFull", myApi);
        asFull.addTextNode(param.getAsFull());
        SOAPElement institution = searchX.addChildElement("institution", myApi);
        institution.addTextNode(param.getInstitution());
        SOAPElement affiliatedUser = searchX.addChildElement("affiliatedUser", myApi);
        affiliatedUser.addTextNode(param.getAffiliatedUser());

    }

    private void createSoapEnvelopeCountFacets(SOAPMessage soapMessage) throws SOAPException {
        System.out.println("createSoapEnvelopeCountFacets");
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myApi = "api";
        String myNamespaceURI = "http://api.ws.primo.exlibris.com";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myApi, myNamespaceURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();

        //(String query, String sort, String language, Map<String, String[]> facets,  String institution, boolean affiliatedUser, String searchToken, String version);

        SOAPElement searchX = soapBody.addChildElement("countFacets", myApi);
        SOAPElement query = searchX.addChildElement("query", myApi);
        query.addTextNode("cats");
        SOAPElement sort = searchX.addChildElement("sort", myApi);
        sort.addTextNode("rank");
        SOAPElement reverse = searchX.addChildElement("facets", myApi);
        reverse.addTextNode("");
        SOAPElement strDidumean = searchX.addChildElement("institution", myApi);
        strDidumean.addTextNode("PCO.ALL");
        SOAPElement language = searchX.addChildElement("affiliatedUser", myApi);
        language.addTextNode("true");
        SOAPElement strFrom = searchX.addChildElement("version", myApi);
        strFrom.addTextNode("4.0.0");
        SOAPElement strTake = searchX.addChildElement("searchToken", myApi);
        strTake.addTextNode("null");
        SOAPElement asFull = searchX.addChildElement("<categories ", myApi);
        strTake.addTextNode("");


    }

    static String xmlEscapeText(String t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            switch(c){
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '\"': sb.append("&quot;"); break;
                case '&': sb.append("&amp;"); break;
                case '\'': sb.append("&apos;"); break;
                default:
                    if(c>0x7e) {
                        sb.append("&#"+((int)c)+";");
                    }else
                        sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public static void test()
    {
        String frontend = API_TEST + SEARCHXENDING;
        String query = "ישראל";
        //query = xmlEscapeText(query);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        Docset docset = result.getDocSet();
        for (Doc doc : docset.getDocs())
        {
            doc.getPrimoNMBib().getRecord().getDisplay().print();
        }
    }


}
