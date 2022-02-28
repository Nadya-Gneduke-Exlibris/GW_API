package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Display;
import framework.response.record.Facets;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Utils.checkQueryInDisplay;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAdvancedSearch {
    public String frontend = API_TEST + SEARCHXENDING;


    @Test
    public void anyContainsAndAnyContains()
    {
        String query = "(((greEN) AND (frOg)))";
        String searchTerms = "green frog";
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

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }

    @Test
    public void titleStartsWithAndContainsAny()
    {
        String query = "((swstitle:(\"green*\") AND (frOg)))";
        String searchTerms = "green frog";
        String startswith = "green";
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
            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("title should starts with given term", (display.getTitle().toLowerCase().startsWith(startswith) ||
                    display.getTitle().toLowerCase().startsWith("the " + startswith) ||
                    display.getTitle().toLowerCase().startsWith("a " + startswith)));
        }
    }

    @Test
    public void titleExactMatchContainsAny()
    {
        String query = "((title:(\"black cat\"))";
        String searchTerms = "black cat";
        String exactMatch = "black cat";
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

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("exact search term should appear in title", display.getTitle().toLowerCase().contains(exactMatch));
        }
    }

    @Test
    public void anyContainsOrAnyContains()
    {
        String query = "(((greEN) OR (frOg)))";
        String searchTerms = "green frog";
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
            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists);
        }
    }

    @Test
    public void anyContainsNOTAnyContains()
    {
        String query = "(((greEN) NOT (frOg)))";
        String searchTerms = "green";
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

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);
            boolean termNotExists = !checkQueryInDisplay(display, "frog");

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("search term should not appear in title, description creator or subject", termNotExists);

        }
    }

    @Test
    public void anyContainsAnyContainsLanguage()
    {
        String query = "(((berliN) AND (Karl))) AND facet_lang:(\"ger\")";
        String searchTerms = "berlin karl";
        String language = "ger";
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
            Facets facets = record.getFacets();

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("record should have specific language", facets.getLanguage().contains(language));

        }
    }

    @Test
    public void anyContainsAnyContainsResourceType()
    {
        String query = "(((water) AND (china))) AND facet_pfilter:(\"books\") ";
        String searchTerms = "water china";
        String rType = "books";
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
            Facets facets = record.getFacets();

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("record should be from specific resource type", facets.getRsrctype().contains(rType));
        }
    }

    @Test
    public void anyContainsAnyContainsCreationDate()
    {
        String query = "(((water) AND (china))) AND facet_creationdate:[2020 TO 2020]";
        String searchTerms = "water china";
        String creationDate = "2020";
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
            Facets facets = record.getFacets();
            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("record should have specific creation date", (facets.getCreationdate().contains(creationDate)));
        }
    }

    @Test
    public void anyContainsANDCreatorContains()
    {
        String query = "(((energy) AND (Peter)))";
        String searchTerms = "energy peter";
        String creator = "Peter";
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
            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("record should have specific creator", (display.getCreator().contains(creator)));
        }
    }

    @Test
    public void anyContainsANDSubjectContains()
    {
        String query = "(((energy) AND sub:(biology)))";
        String searchTerms = "energy biology";
        String subject = "biology";
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

            boolean searchTermExists = checkQueryInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists);
            assertThat("record should have specific subject", (display.getSubject().toLowerCase().contains(subject)));
        }
    }

}
