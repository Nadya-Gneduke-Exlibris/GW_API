package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Display;
import framework.service.SearchService;
import framework.service.httprequest.HTTPRequest;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.CITEDBY;
import static framework.utils.Constants.SEARCHXENDING;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCitedBy {

    @Test
    public void citatedByGet() throws Exception {
        String query = "groupids=11,12,77,88&institution=staging.972QA.VOLCANO&isKnownUser=staging.972QA.VOLCANO&isKnownUser=true&clientVersion=4.9.2";
        String url = API_TEST + CITEDBY + query;
        HTTPRequest obj = new HTTPRequest();

        try {

            obj.sendGet(url);


        } finally {
            obj.close();
        }

    }

    @Test
    public void citedByExists() {

        String frontend = API_TEST + SEARCHXENDING;
        String query = "nuclear power";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "rank", "10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean citedByExists = false;
        for (Doc doc : docSet.getDocs()) {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            String citedBy = display.getCitedBy();
            if (citedBy != null) {
                citedByExists = true;
            }
        }
        assertThat("At least one record should contain cited by", citedByExists);
    }

}
