package soap_tests;

import framework.service.httprequest.HTTPRequest;
import org.testng.annotations.Test;

import static framework.service.soap.SoapWebService.callSoapServiceWithRequest;
import static framework.utils.Constants.API_PREVIEW;
import static framework.utils.Constants.CONTENTTYPEJSON;
import static framework.utils.Constants.RELATEDITEMS;

public class TestRelatedItems {

    static String rel = "\t{\"recordsData\":[{\"isbn\":[\"9780815713913\"],\"title\":\"Haiti in the balance\",\"creator\":\"Buss, Terry\",\"groupId\":\"342976109\"}],\"institution\":\"01HVD.01HVD.PPRD\",\"isKnownUser\":\"true\"}";


    @Test
    public void relatedItemsJson() {
        String url = API_PREVIEW + RELATEDITEMS;
        callSoapServiceWithRequest(url, rel, CONTENTTYPEJSON);

    }

    @Test
    public void relatedItemsGet() throws Exception {

        String query = "groupId=342976109&institution=01HVD.01HVD.PPRD&isKnownUser=true&clientVersion=4.9.8&title=Haiti%20in%20the%20balance%20%20why%20foreign%20aid%20has%20failed%20and%20what%20we%20can%20do%20about%20it&creator=Buss,%20Terry%20F&isbn=9780815713913";

        String url = API_PREVIEW + RELATEDITEMS + query;
        HTTPRequest obj = new HTTPRequest();

        try {
            obj.sendGet(url);


        } finally {
            obj.close();
        }

    }
}
