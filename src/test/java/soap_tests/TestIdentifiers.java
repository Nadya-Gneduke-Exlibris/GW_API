package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Addata;
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

public class TestIdentifiers {
    public String frontend = API_TEST + SEARCHXENDING;


    @DataProvider(name = "DOIs")
    private Iterator<Object[]> dois() {
        List<Object[]> data = new ArrayList<>();
        String query = "green";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "rank","10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        for (Doc doc : docSet.getDocs()) {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Addata addata = record.getAddata();
            String doi = addata.getDoi();
            if (doi != null)
            {
                data.add(new Object[]{doi});
            }

        }
        return data.iterator();
    }

    @Test(dataProvider = "DOIs")
    public void searchByDOI(String doi) {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(doi);
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
            Addata addata = record.getAddata();
            String doiToTest = addata.getDoi();

            assertThat("The doi should be the same as query", doi.equals(doiToTest));
        }
    }


    @DataProvider(name = "ISSNs")
    private Iterator<Object[]> issns() {
        List<Object[]> data = new ArrayList<>();
        String query = "green";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query, "rank","10");
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
        for (Doc doc : docSet.getDocs()) {
            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Addata addata = record.getAddata();
            String issn = addata.getIssn();

            if (issn != null)
            {
                data.add(new Object[]{issn});
            }

        }
        return data.iterator();
    }

    @Test(dataProvider = "ISSNs")
    public void searchByIssn(String issn)
    {
        String query =  "issn:(%s)".format(issn);
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtended(frontend,param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result.getDocSet();
         Doc doc = docSet.getDocs().get(0);

            PrimoNMBib primo = doc.getPrimoNMBib();
            Record record = primo.getRecord();
            Addata addata = record.getAddata();
            String issnToTest = addata.getIssn();
            String eissn = addata.getEissn();

            assertThat("The issn or eissn should be the same as issn from query", (issnToTest.contains(issn)|| eissn.contains(issn)));

    }

}
