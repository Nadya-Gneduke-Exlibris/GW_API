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
import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.HARVARDPCKEY;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Constants.SUPPORTPCKEY;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBasicSearch {
    public String frontend = API_TEST + SEARCHXENDING;


    @Test()
    public void resultsReturned()
    {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended("test");
        SearchService service = new SearchService();
        System.out.println("Start testing");
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


    @Test(enabled = false)
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




    @Test(enabled = false)
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


    @Test(enabled = false)
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


    @Test(enabled = false)
    public void searchTermInSubject() {

        String query = "(sub:(wateR)";
        String term = "water";
        //sub,contains,wateR
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
            display.print();

            String subject = display.getSubject();

            assertThat("search term should appear in titlesubject", subject.toLowerCase().contains(term));
        }
    }


    @Test(enabled = false)
    public void searchTermInCreator() {

        String query = "(creator:(john)";
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
            display.print();

            String creator = display.getCreator();
            String creatorContrib = display.getCreatorContrib();

            assertThat("search term should appear in creator or creatoe contrib field", (creator.toLowerCase().contains(term) ||
                                                                    creatorContrib.toLowerCase().contains(term)));
        }
    }



    @Test(enabled = false)
    public void hebrewSearch() {

        //TODO fix. something with encoding
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
            display.print();

            String title = display.getTitle();
            String subject = display.getSubject();
            String description = display.getDescription();
            assertThat("search term should appear in title, subject or description", (title.contains(query)||
                    subject.contains(query) || description.contains(query)));
        }
    }

    @Test(enabled = false)
    public void oneWordSearchTerm() {

        String query = "photosynthesis";
        boolean searchTermExists = false;
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

            String title = display.getTitle();
            String description = display.getDescription();
            String creator = display.getCreator();
            String subject = display.getSubject();

            for (String term : query.split(" "))
            {
                if (title != null)
                {
                    searchTermExists = searchTermExists ||  title.toLowerCase().contains(term);
                }

                if (description != null)
                {
                    searchTermExists = searchTermExists ||  description.toLowerCase().contains(term);
                }

                if (creator != null)
                {
                    searchTermExists = searchTermExists ||  creator.toLowerCase().contains(term);
                }

                if (subject != null)
                {
                    searchTermExists = searchTermExists ||  subject.toLowerCase().contains(term);
                }


            }

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }



    @Test(enabled = false)
    public void severalWordsSearchTerm() {

        //TODO fix
        String query = "green cat";
        boolean searchTermExists = false;

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
            String title = display.getTitle();
            String description = display.getDescription();
            String creator = display.getCreator();
            String subject = display.getSubject();
            for (String term : query.split(" "))
            {
                if (title != null)
                {
                    searchTermExists = searchTermExists || title.toLowerCase().contains(term);
                }

                if (description != null)
                {
                    searchTermExists = searchTermExists || description.toLowerCase().contains(term);
                }

                if (creator != null)
                {
                    searchTermExists = searchTermExists || creator.toLowerCase().contains(term);
                }

                if (subject != null)
                {
                    searchTermExists = searchTermExists || subject.toLowerCase().contains(term);
                }

            }

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }

    @DataProvider(name = "recordsIds")
    private Iterator<Object[]> recordsIds() {
        List<Object[]> data = new ArrayList<>();
        String query = "green energy";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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


    @Test(dataProvider = "recordsIds", enabled = false)
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


    @Test(enabled = false)
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
            System.out.println(title);
            assertThat("search term should appear in title, description creator or subject", title.toLowerCase().startsWith(term.toLowerCase()));
        }
    }


    @Test(enabled = false)
    public void wildCard()  {
        String term = "powe";
        boolean searchTermExists = false;
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
            String description = display.getDescription();
            String creator = display.getCreator();
            String subject = display.getSubject();

            if (title != null)
            {
                searchTermExists = searchTermExists || title.contains(term);
            }

            if (description != null)
            {
                searchTermExists = searchTermExists || description.contains(term);
            }

            if (creator != null)
            {
                searchTermExists = searchTermExists || creator.contains(term);
            }

            if (subject != null)
            {
                searchTermExists = searchTermExists || subject.contains(term);
            }

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }

    }


    //TODO add test with very long phrase (more than 11 words without 2 words in the middle (citation search))

    //TODO add test with long phrase and pages, looks like ISSN (pp.xxxx-xxxx)


}
