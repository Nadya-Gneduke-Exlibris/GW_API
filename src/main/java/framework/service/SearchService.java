package framework.service;

import framework.response.FacetList;
import framework.response.Result;
import framework.service.param.SearchParamSearchXExtended;

import static framework.service.XMLRequestBuilder.buildSearchXExtendedCompressedRequest;
import static framework.service.XMLRequestBuilder.buildSearchXExtendedRequest;
import static framework.service.httprequest.HTTPRequest.postRequest;
import static framework.utils.Constants.FACETCOUNTREQUEST;
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
        String strRes = postRequest(frontend,FACETCOUNTREQUEST);
        FacetList res = parseStringResponseToFacetListFacetCountCompressed(strRes);
        return res;
    }

}

