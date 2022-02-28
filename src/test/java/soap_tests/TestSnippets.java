package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Display;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Locale;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Utils.normalizeString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSnippets {

    @Test
    public void searchTermInSnippet() {

        String frontend = API_TEST + SEARCHXENDING;
        String query = "new york";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean snippetExists = false;
        for (Doc doc : docSet.getDocs()) {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            String snippet = display.getSnippet();

            if (snippet != null) {
                snippetExists = true;
                snippet = normalizeString(snippet);
                assertThat("Snippet should contain the search term", snippet.toLowerCase().contains(query.toLowerCase(Locale.ROOT)));
            }

        }
        assertThat("At least one record should contain snippet", snippetExists);
    }

}
