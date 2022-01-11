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
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAdvancedSearch {
    public String frontend = API_TEST + SEARCHXENDING;

    boolean checkTermsInDisplay(Display display, String searchTerms)
    {
        boolean searchTermExists = false;

        String title = display.getTitle();
        String description = display.getDescription();
        String creator = display.getCreator();
        String subject = display.getSubject();

        for (String term : searchTerms.split(" "))
        {
            if (title != null)
            {
                searchTermExists = searchTermExists ||  title.toLowerCase().contains(term.toLowerCase());
            }

            if (description != null)
            {
                searchTermExists = searchTermExists ||  description.toLowerCase().contains(term.toLowerCase());
            }

            if (creator != null)
            {
                searchTermExists = searchTermExists ||  creator.toLowerCase().contains(term.toLowerCase());
            }

            if (subject != null)
            {
                searchTermExists = searchTermExists ||  subject.toLowerCase().contains(term.toLowerCase());
            }
        }
        return searchTermExists;
    }

    @Test
    public void anyContainsAndAnyContains()
    {
        String query = "(((greEN) AND (frOg)))";
        String searchTerms = "green frog";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();

            searchTermExists = checkTermsInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }
        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            searchTermExists = checkTermsInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            display.print();

            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            searchTermExists = checkTermsInDisplay(display, searchTerms);
            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
        }
    }

    @Test
    public void anyContainsNOTAnyContains()
    {
        String query = "(((greEN) NOT (frOg)))";
        String searchTerms = "green";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        boolean termNotExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();

            searchTermExists = checkTermsInDisplay(display, searchTerms);
            termNotExists = !checkTermsInDisplay(display, "frog");

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
            assertThat("search term should not appear in title, description creator or subject", termNotExists == true);

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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            Facets facets = record.getFacets();

            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            Facets facets = record.getFacets();

            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            Facets facets = record.getFacets();
            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
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
        Result result = service.SearchXExtended(API_TEST + SEARCHXENDING, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        boolean searchTermExists = false;
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();
            System.out.println(display.getSubject().toLowerCase());
            Facets facets = record.getFacets();
            searchTermExists = checkTermsInDisplay(display, searchTerms);

            assertThat("search term should appear in title, description creator or subject", searchTermExists == true);
            assertThat("record should have specific subject", (display.getSubject().toLowerCase().contains(subject)));
        }
    }

}
