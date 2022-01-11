package soap_tests;

import framework.response.Doc;
import framework.response.Docset;
import framework.response.Facet;
import framework.response.FacetList;
import framework.response.FacetValue;
import framework.response.PrimoNMBib;
import framework.response.Record;
import framework.response.Result;
import framework.response.record.Control;
import framework.service.SearchService;
import framework.service.param.SearchParamSearchXExtended;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.LOADBALANCER;
import static framework.utils.Constants.SEARCHXENDING;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFacets {
    public String frontend = API_TEST + SEARCHXENDING;
    public String query = "nuclear power";

    //TODO add test searches for query, remembers the count of facet and then - search with this facet
    //add test for each category of facets
    //add test for multiple facets with OR
    //add test with multiple facets with AND

    @Test
    public void countFromFacetListEqualsToSearchWithFacet()
    {
        String query = "nuclear power";
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        FacetList facetList = result.getFacetList();

        List<Facet> facets = facetList.getFacets();
        Facet firstFacet = facets.get(0);
        FacetValue firstFacetValue = firstFacet.getFacetValues().get(0);
        firstFacetValue.print();
        String firstKey = firstFacetValue.getKey();
        int firstValue = firstFacetValue.getValue();
        String q = "((%s)) AND facet_%s:(\"%s\")".formatted(query,firstFacet.getName(),firstKey);
        SearchParamSearchXExtended param1 = new SearchParamSearchXExtended(q);
        SearchService service1 = new SearchService();
        Result result1 = service1.SearchXExtended(frontend, param1);
        if (result1 == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result1.getDocSet();
        assertThat("Facet count equals to the count from FacetList",
                docSet.getTotalHits() == firstValue);
    }

    @Test
    public void countOfTwoFacetsWithOR()
    {
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        FacetList facetList = result.getFacetList();

        List<Facet> facets = facetList.getFacets();
        Facet firstFacet = facets.get(0);

        FacetValue firstFacetValue = firstFacet.getFacetValues().get(0);
        firstFacetValue.print();
        String firstKey = firstFacetValue.getKey();
        int firstCount = firstFacetValue.getValue();

        FacetValue secondFacetValue = firstFacet.getFacetValues().get(1);
        secondFacetValue.print();
        String secondKey = secondFacetValue.getKey();
        int secondCount = secondFacetValue.getValue();

        String q = "((%s)) AND facet_%s:(\"%s\" OR \"%s\")".formatted(query,firstFacet.getName(),firstKey, secondKey);
        SearchParamSearchXExtended param1 = new SearchParamSearchXExtended(q);
        SearchService service1 = new SearchService();
        Result result1 = service1.SearchXExtended(frontend, param1);
        if (result1 == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result1.getDocSet();
        System.out.println("First count: " + firstCount);
        System.out.println("Second count: " + secondCount);
        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Facet count should be more than the each first facet count",
                (docSet.getTotalHits() > firstCount && docSet.getTotalHits() > secondCount));
    }

    @Test
    public void countOfTwoFacetsWithAND()
    {
        //TODO fix, open bug if needed
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null)
        {
            throw new SkipException("The result returned null");
        }

        FacetList facetList = result.getFacetList();

        List<Facet> facets = facetList.getFacets();
        Facet firstFacet = facets.get(1);


        FacetValue firstFacetValue = firstFacet.getFacetValues().get(0);
        firstFacetValue.print();
        String firstKey = firstFacetValue.getKey();
        int firstCount = firstFacetValue.getValue();

        FacetValue secondFacetValue = firstFacet.getFacetValues().get(1);
        secondFacetValue.print();
        String secondKey = secondFacetValue.getKey();
        int secondCount = secondFacetValue.getValue();

        String q = "((%s)) AND facet_%s:(\"%s\") AND facet_%s:(\"%s\")".formatted(query,firstFacet.getName(),firstKey, firstFacet.getName(),secondKey);
        System.out.println(q);
        SearchParamSearchXExtended param1 = new SearchParamSearchXExtended(q);
        SearchService service1 = new SearchService();
        Result result1 = service1.SearchXExtended(frontend, param1);
        if (result1 == null)
        {
            throw new SkipException("The result returned null");
        }

        Docset docSet = result1.getDocSet();
        System.out.println("First count: " + firstCount);
        System.out.println("Second count: " + secondCount);
        System.out.println("Total hits: " + docSet.getTotalHits());
        assertThat("Facet count should be more than the each first facet count",
                (docSet.getTotalHits() < firstCount && docSet.getTotalHits() < secondCount));
    }



    @DataProvider(name = "facetNamesAndValues")
    private Iterator<Object[]> facetNamesAndValues() {
        List<Object[]> data = new ArrayList<>();
        SearchParamSearchXExtended param = new SearchParamSearchXExtended(query);
        SearchService service = new SearchService();
        Result result = service.SearchXExtendedCompressed(frontend, param);
        if (result == null) {
            throw new SkipException("The result returned null");
        }
        FacetList facetList = result.getFacetList();
        List<Facet> facets = facetList.getFacets();

        for (Facet facet : facets)
        {
            if (!facet.getName().contains("date"))
            {
                data.add(new Object[]{facet});
            }

        }

        return data.iterator();
    }

    @Test(dataProvider = "facetNamesAndValues")
    public void facetsReturnResults(Facet facet)
    {

        facet.print();
        List<FacetValue> facetValues = facet.getFacetValues();
        for (FacetValue facetValue : facetValues)
        {
            String key = facetValue.getKey();
            if(key.contains("Not for CDI"))
            {
                continue;
            }
            System.out.println("Key: " + key);
            String q = "((%s)) AND facet_%s:(\"%s\")".formatted(query,facet.getName(),key);
            System.out.println("Query: " + q);
            String qu = "((nuclear power)) AND facet_domain:(DOAJ Directory of Open Access Journals - Not for CDI Discovery)";
            //System.out.println("Query: " + qu);
            SearchParamSearchXExtended param1 = new SearchParamSearchXExtended(q);
            SearchService service1 = new SearchService();
            Result result1 = service1.SearchXExtendedCompressed(frontend, param1);
            System.out.println(result1);
            if (result1 == null)
            {
                throw new SkipException("The result returned null");
            }

            Docset docSet = result1.getDocSet();

            assertThat("Total hits should be greater than zero",
                    docSet.getTotalHits() > 0);
        }
    }


}
