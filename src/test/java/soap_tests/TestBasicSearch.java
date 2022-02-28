package soap_tests;
import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Control;
import framework.response.record.Display;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import static framework.utils.Constants.API_PREVIEW;
import static framework.utils.Constants.API_PRODUCTION;
import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.HARVARDPCKEY;
import static framework.utils.Constants.LOADBALANCER;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Constants.SUPPORTPCKEY;
import static framework.utils.Utils.checkQueryInDisplay;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBasicSearch {
    public String frontend = API_TEST + SEARCHXENDING;


    @Test()
    public void resultsReturned()
    {
        String query = "test";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Total hits should be greater than zero",
                docSet.getTotalHits() > 0);
    }


    @Test()
    public void resultsReturnedWithDifferentPCkeys()
    {
        SearchParamSearchXExtended harvardParam = new SearchParamSearchXExtended("test",HARVARDPCKEY,"","5");
        SearchService harvardService = new SearchService();
        Result harvardResult = harvardService.SearchXExtended(frontend, harvardParam);
        if (harvardResult == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset harvardDocSet = harvardResult.getDocSet();
        long harvardTotal = harvardDocSet.getTotalHits();

        System.out.println("Total hits for Harvard pckey: " + harvardTotal);

        SearchParamSearchXExtended supportParam = new SearchParamSearchXExtended("test",SUPPORTPCKEY,"","5");
        SearchService supportService = new SearchService();
        Result supportResult = supportService.SearchXExtended(frontend, supportParam);
        if (supportResult == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset supportDocSet = supportResult.getDocSet();
        long supportTotal = supportDocSet.getTotalHits();

        System.out.println("Total hits for support pckey: " + supportTotal);

        assertThat("Total hits from different pckeys should not be the same",
                harvardTotal != supportTotal);
    }


    @Test()
    public void resultsReturnedCompressed()
    {
        String query = "GiraffE";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result res = service.SearchXExtendedCompressed(frontend, param);

        if (res == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = res.getDocSet();

        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Total hits should be greater than zero",
                docSet.getTotalHits() > 0);
    }


    @Test()
    public void searchTermInTitle() {

        String query = "title:(photosynthesis)";
        String term = "photosynthesis";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();

            String title = display.getTitle().toLowerCase();
            assertThat("search term should appear in title", title.contains(term));
        }
    }


    @Test()
    public void searchTermInSubject() {

        String query = "(sub:(wateR)";
        String term = "water";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();

            String subject = display.getSubject();

            assertThat("search term should appear in titlesubject", subject.toLowerCase().contains(term));
        }
    }


    @Test()
    public void searchTermInCreator() {

        String query = "(creator:(john))";
        String term = "john";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();

            String creator = display.getCreator();
            String creatorContrib = display.getCreatorContrib();

            assertThat("search term should appear in creator or creator contrib field", (creator.toLowerCase().contains(term) ||
                                                                    creatorContrib.toLowerCase().contains(term)));
        }
    }


    @Test()
    public void hebrewSearch() {

        String query = "ישראל";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();

            String title = display.getTitle();
            String subject = display.getSubject();
            String description = display.getDescription();
            assertThat("search term should appear in title, subject or description", (title.contains(query)||
                    subject.contains(query) || description.contains(query)));
        }
    }

    @Test()
    public void oneWordSearchTerm() {

        String query = "photosynthesis";

        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();
            boolean searchTermExists = checkQueryInDisplay(display, query);


            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }



    @Test()
    public void severalWordsSearchTerm() {

        String query = "green cat";

        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();
            boolean searchTermExists = checkQueryInDisplay(display, query);

              assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }

    @DataProvider(name = "recordsIds")
    private Iterator<Object[]> recordsIds() {
        List<Object[]> data = new ArrayList<>();
        String query = "green energy";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        for (Doc doc : docSet.getDocs()) {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Control control = record.getControl();
            String rid = control.getRecordids();

            data.add(new Object[]{rid});
        }
        return data.iterator();
    }


    @Test(dataProvider = "recordsIds")
    public void recordID(String id) {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(id);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend,param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Control control = record.getControl();
            String rid = control.getRecordids();

            assertThat("The record id should be the same as query", rid.equals(id));
        }
    }


    @Test()
    public void startsWith() {

        String term = "Richard";
        String searchQuery = String.format("( swstitle:(%s*))", term);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(searchQuery);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();

            String title = display.getTitle();

            assertThat("search term should appear in title, description creator or subject", title.toLowerCase().startsWith(term.toLowerCase()));
        }
    }


    @Test()
    public void wildCard()  {
        String term = "powe";

        String searchQuery = String.format("( swstitle:(%s*))", term);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(searchQuery);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();

            Display display = record.getDisplay();
            boolean searchTermExists = checkQueryInDisplay(display, term);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }

    }


    //TODO add test with very long phrase (more than 11 words without 2 words in the middle (citation search))

    //TODO add test with long phrase and pages, looks like ISSN (pp.xxxx-xxxx)


}
