import framework.response.FacetList;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;

public class FacetCount {
    public String frontend = API_TEST + SEARCHXENDING;

    @Test
    public void facetListReturned()
    {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended("test");
        SearchService service = new SearchService();
        FacetList result = service.facetCountXMLRequest(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        result.print();
    }




}
