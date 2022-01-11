package soap_tests;

import framework.service.httprequest.HTTPRequest;
import org.testng.annotations.Test;

public class TestCitations {


    @Test
    public void citationsGet() throws Exception {
        String url = "http://api1.test.cdi.dc04.hosted.exlibrisgroup.com:8011/primo_library/libweb/webservices/rest/v1/connections/citations?groupids=11,12,77,88&institution=staging.972QA.VOLCANO&isKnownUser=staging.972QA.VOLCANO&isKnownUser=true&clientVersion=4.9.2";

        HTTPRequest obj = new HTTPRequest();

        try {
            obj.sendGet(url);


        } finally {
            obj.close();
        }

    }
}
