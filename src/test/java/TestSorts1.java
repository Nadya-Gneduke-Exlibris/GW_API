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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.SEARCHXENDING;
import static framework.utils.Utils.normalizeString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;

public class TestSorts1 {
    public String frontend = API_TEST + SEARCHXENDING;

    @Test
    public void sortByTitle()
    {

        String query = "shakespeare";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "stitle");
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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
        System.out.println("TitleList" + titleList);
        System.out.println("Copy before" + copy);
        Collections.sort(copy);
        System.out.println("Copy after" + copy);
        assertThat("search term should appear in title, description creator or subject", titleList.equals(copy));
    }

    @Test
    public void sortByCreator()
    {

        String query = "shakespeare";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "screator");
        SearchService service = new SearchService();
        Result result = service.searchXMLRequest(frontend, param);
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
        System.out.println("TitleList" + creatorList);
        System.out.println("Copy before" + copy);
        Collections.sort(copy);
        System.out.println("Copy after" + copy);
        assertThat("search term should appear in title, description creator or subject", creatorList.equals(copy));
    }

    //TODO add sort by creators

    //TODO add sort by date asc

    //TODO add sort by date desc

    //TODO add sort by rank (by default)

}
