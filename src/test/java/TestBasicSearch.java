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

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBasicSearch {
       public String frontend = API_TEST + SEARCHXENDING;

    @Test
    public void resultsReturned()
    {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended("test");
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();

        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Total hits should be greater than zero",
                docSet.getTotalHits() > 0);
    }


    @Test
    public void resultsReturnedCompressed()
    {
        String query = "GiraffE";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result res = service.searchXCompressedXMLRequest(frontend, param);

        if (res == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = res.getDocSet();

        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Total hits should be greater than zero",
                docSet.getTotalHits() > 0);
    }

    @Test
    public void searchTermInTitle() {

        String query = "photosynthesis";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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
            assertThat("search term should appear in title", title.contains(query));
        }
    }

    @Test
    public void hebrewSearch() {

        //TODO fix. When comparing to postman I have 117673120 total hits vs 157912. Perhaps something with encoding charset
        String query = "ישראל";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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
            //String subject = display.getSubject();
            //String description = display.getDescription();
            //assertThat("search term should appear in title, subject or description", title.contains(query) );
        }
    }

    @Test
    public void oneWordSearchTerm() {

        String query = "photosynthesis";
        boolean searchTermExists = false;
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
        }
    }


    @Test
    public void severalWordsSearchTerm() {

        String query = "green cat";
        boolean searchTermExists = false;

        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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

            }

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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

    @Test(dataProvider = "recordsIds")
    public void recordID(String id) {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(id);
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend,param);
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


    @Test
    public void startsWith() {

        String term = "Richard";
        String searchQuery = String.format("( swstitle:(%s*))", term);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(searchQuery);
        SearchService service = new SearchService();
        Result result = service.searchXCompressedXMLRequest(frontend, param);
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

    @Test
    public void wildCard()  {
        String term = "powe";
        boolean searchTermExists = false;
        String searchQuery = String.format("( swstitle:(%s*))", term);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(searchQuery);
        SearchService service = new SearchService();
        Result result = service.searchXCompressedXMLRequest(frontend, param);
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

                assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
        }

    }


    //TODO add test with very long phrase (more than 11 words without 2 words in the middle (citation search))

    //TODO add test with long phrase and pages, looks like ISSN (pp.xxxx-xxxx)




}
