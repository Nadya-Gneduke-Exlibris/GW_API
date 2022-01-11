package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Display;
import framework.response.record.Search;
import framework.response.record.Sort;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.HARVARDPCKEY;
import static framework.utils.Constants.LOADBALANCER;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Utils.normalizeString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;

public class TestSorts {
    public String frontend = API_TEST + SEARCHXENDING;

    @Test
    public void sortByTitle()
    {

        String query = "shakespeare";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "stitle");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        List<String> titleList = new ArrayList<>();
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();

            String title = display.getTitle();
            title = normalizeString(title);
            titleList.add(title);

        }
        List<String> copy = titleList;
        Collections.sort(copy);
        assertThat("Records sould be sorted by title", titleList.equals(copy));
    }

    @Test
    public void sortByCreator()
    {

        String query = "shakespeare";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "screator");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        List<String> creatorList = new ArrayList<>();
        for (Doc doc : docSet.getDocs())
        {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Display display = record.getDisplay();

            String creator = display.getCreator();
            creator = normalizeString(creator);
            creatorList.add(creator);

        }
        List<String> copy = creatorList;
        Collections.sort(copy);
        assertThat("Records should be sorted by creators", creatorList.equals(copy));
    }


    @Test
    public void sortByDateAsc()
    {
        String query = "water";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query,"scdate","false","", "10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        List<String> creationDatesList = new ArrayList<>();
        for (Doc doc : docSet.getDocs())
        {

            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Sort sort = record.getSort();
            String creationDate = sort.getCreationdate();

            if(creationDate != null )
        {
            creationDatesList.add(creationDate);
        }
        }
        List<String> copy = creationDatesList;
        Collections.sort(copy);
        assertThat("Records should be ordered in ascending order", creationDatesList.equals(copy));
    }


    @Test
    public void sortByDateDesc()
    {
        String query = "water";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query,"scdate","true","", "10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        List<String> creationDatesList = new ArrayList<>();
        for (Doc doc : docSet.getDocs())
        {

            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Sort sort = record.getSort();
            String creationDate = sort.getCreationdate();

            if(creationDate != null )
            {
                creationDatesList.add(creationDate);
            }
        }
        List<String> copy = creationDatesList;
        Collections.sort(copy);
        Collections.reverse(copy);
        assertThat("Records should be ordered in a descending order", creationDatesList.equals(copy));
    }

}
