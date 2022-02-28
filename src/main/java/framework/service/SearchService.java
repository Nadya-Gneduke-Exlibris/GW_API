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
        System.out.println(buildSearchXExtendedRequest(param));
        String strRes = postRequest(frontend,buildSearchXExtendedRequest(param), null);
        return parseStringResponseToResultSearchX(strRes);
     }

    public Result searchXCompressedXMLRequest(String frontend, SearchParamSearchXExtended param)  {
        String s = postRequest(frontend,buildSearchXExtendedCompressedRequest(param), null);
        return parseStringCompressedResponseToResult(s);
    }

    public FacetList facetCountXMLRequest(String frontend, String xmlRequest)  {
        xmlRequest = xmlRequest == null ? FACETCOUNTCOMPRESSED : xmlRequest;
        String strRes = postRequest(frontend, xmlRequest, null);
        return parseStringResponseToFacetListFacetCountCompressed(strRes);
     }

    public Result SearchXExtended(String frontend, SearchParamSearchXExtended param)
    {
        SoapWebService service = new SoapWebService();
        SOAPBody body = service.callSoapWebServiceSearchXExtended(frontend, param, false);
        return Utils.parseResponseToResult(body);

    }

    public Result SearchXExtendedCompressed(String frontend, SearchParamSearchXExtended param)
    {
        SoapWebService service = new SoapWebService();
        SOAPBody body = service.callSoapWebServiceSearchXExtended(frontend, param, true);
        return Utils.parseResponseToResultCompressed(body);

    }

    public SOAPBody searchWithXML(String url, String xmlRequest)
    {
        return SoapWebService.callSoapWebServiceXML(url, xmlRequest);
    }

}

