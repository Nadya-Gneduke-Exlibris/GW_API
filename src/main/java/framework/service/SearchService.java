package framework.service;

import framework.response.FacetList;
import framework.response.Result;
import framework.service.param.SearchParamSearchXExtended;
import framework.service.soap.SoapWebService;
import framework.utils.Utils;

import javax.xml.soap.SOAPBody;

import static framework.service.XMLRequestBuilder.buildSearchXExtendedCompressedRequest;
import static framework.service.XMLRequestBuilder.buildSearchXExtendedRequest;
import static framework.service.httprequest.HTTPRequest.postRequest;
import static framework.utils.Constants.FACETCOUNTCOMPRESSED;
import static framework.utils.Utils.parseStringCompressedResponseToResult;
import static framework.utils.Utils.parseStringResponseToFacetListFacetCountCompressed;
import static framework.utils.Utils.parseStringResponseToResultSearchX;


public class SearchService {


    public Result searchXMLRequest(String frontend, SearchParamSearchXExtended param)  {
        String strRes = postRequest(frontend,buildSearchXExtendedRequest(param));
        System.out.println(strRes);
        Result res = parseStringResponseToResultSearchX(strRes);
        return res;
    }

    public Result searchXCompressedXMLRequest(String frontend, SearchParamSearchXExtended param)  {
        String s = postRequest(frontend,buildSearchXExtendedCompressedRequest(param));
        Result res = parseStringCompressedResponseToResult(s);
        return res;
    }

    public FacetList facetCountXMLRequest(String frontend, SearchParamSearchXExtended param)  {
        String strRes = postRequest(frontend, FACETCOUNTCOMPRESSED);
        FacetList res = parseStringResponseToFacetListFacetCountCompressed(strRes);
        return res;
    }

    public Result SearchXExtended(String frontend, SearchParamSearchXExtended param)
    {
        SoapWebService service = new SoapWebService();
        SOAPBody body = service.callSoapWebServiceSearchXExtended(frontend, param, false);
        System.out.println("Result: " + body);
        Result result = Utils.parseResponseToResult(body);
        return result;
    }

    public Result SearchXExtendedCompressed(String frontend, SearchParamSearchXExtended param)
    {
        SoapWebService service = new SoapWebService();
        SOAPBody body = service.callSoapWebServiceSearchXExtended(frontend, param, true);
        Result result = null;
        result = Utils.parseResponseToResultCompressed(body);

        return result;
    }

    public SOAPBody searchWithXML(String url, String xmlRequest)
    {
        SoapWebService service = new SoapWebService();
        SOAPBody body = service.callSoapWebServiceXML(url, xmlRequest);
        return body;
    }




}

