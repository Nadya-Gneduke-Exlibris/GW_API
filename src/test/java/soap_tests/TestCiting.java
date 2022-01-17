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

import static framework.utils.Constants.API_CI;
import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.HARVARDPCKEY;
import static framework.utils.Constants.LOADBALANCER;
import static framework.utils.Constants.SEARCHXENDING;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCiting {

    @Test
    public void citingGet() throws Exception {
        String url = "http://api1.test.cdi.dc04.hosted.exlibrisgroup.com:8011/primo_library/libweb/webservices/rest/v1/connections/citing?groupids=11,12,77,88&institution=staging.972QA.VOLCANO&isKnownUser=staging.972QA.VOLCANO&isKnownUser=true&clientVersion=4.9.2";

        HTTPRequest obj = new HTTPRequest();

        try {
            obj.sendGet(url);


        } finally {
            obj.close();
        }

    }

    @Test
    public void citesExists() {

        String frontend = API_TEST + SEARCHXENDING;
        String query = "nuclear power";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "rank", "10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean citesExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            display.print();
            String cites = display.getCites();
            if (cites != null)
            {
                citesExists = true;
            }
        }
        assertThat("At least one record should contain cites", citesExists);
    }

}
