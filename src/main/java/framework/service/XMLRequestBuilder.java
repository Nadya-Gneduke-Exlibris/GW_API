package framework.service;
import framework.service.param.SearchParamSearchX;
import framework.service.param.SearchParamSearchXExtended;

import static framework.utils.Constants.searchXEnvelop;
import static framework.utils.Constants.searchXExtendedCompressedEnvelop;
import static framework.utils.Constants.searchXExtendedEnvelop;

public class XMLRequestBuilder {


    public static String buildSearchXExtendedRequest(SearchParamSearchXExtended param)
    {
        return String.format(param.getQuery(),
                                param.getSort(),param.getReverse(),param.getStrDidumean(),param.getLanguage(),param.getStrFrom()
                                ,param.getStrTake(), param.getAsFull(),param.getInstitution(),param.getAffiliatedUser()
                                ,param.getSessionId(),param.getVersion(),param.getCategories(), param.getDegree()
                                ,param.getExplain(),param.getExplainDocId());
    }

    public static String buildSearchXExtendedCompressedRequest(SearchParamSearchXExtended param)
    {
        return String.format(param.getQuery(),
                param.getSort(),param.getReverse(),param.getStrDidumean(),param.getLanguage(),param.getStrFrom()
                ,param.getStrTake(), param.getAsFull(),param.getInstitution(),param.getAffiliatedUser()
                ,param.getSessionId(),param.getVersion(),param.getCategories(), param.getDegree()
                ,param.getExplain(),param.getExplainDocId());
    }

    public static String buildSearchXRequest(SearchParamSearchX param)
    {
        return String.format(param.getQuery(),
                param.getSort(),param.getStrDidumean(),param.getLanguage(),param.getStrFrom()
                ,param.getStrTake(), param.getAsFull(),param.getInstitution(),param.getAffiliatedUser());
    }
}
