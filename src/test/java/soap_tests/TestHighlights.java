package soap_tests;

import framework.response.Highlight;
import framework.response.Highlights;
import framework.response.Result;
import framework.response.Term;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHighlights {

    @Test
    public void highlightItTitle() {

        String frontend = API_TEST + SEARCHXENDING;
        String query = "dog";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        boolean highlightExists = false;
        Highlights highlights = result.getHighlights();
        for (Highlight highlight : highlights.getHighlights()) {
            if (highlight.getField().contains("title")) {
                for (Term term : highlight.getTerms()) {
                    if (term.getValue().toLowerCase().contains(query)) {
                        highlightExists = true;
                        break;
                    }
                }
            }
        }

        assertThat("At least one record should contain highlight in title",
                highlightExists);
    }
}
