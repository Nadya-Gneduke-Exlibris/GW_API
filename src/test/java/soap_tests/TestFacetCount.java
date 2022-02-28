package soap_tests;

import framework.service.SearchService;
import org.testng.annotations.Test;

import javax.xml.soap.SOAPBody;

import static framework.utils.Constants.API_TEST;
import static framework.utils.Constants.FACETCOUNT;
import static framework.utils.Constants.FACETCOUNTCATEGORIES;
import static framework.utils.Constants.FACETCOUNTCOMPRESSED;
import static framework.utils.Constants.FACETCOUNTCOMPRESSEDCATEGORIES;
import static framework.utils.Constants.FACETCOUNTCOMPRESSEDCATEGORIESLANGUAGES;
import static framework.utils.Constants.FACETCOUNTCOMPRESSEDLANGUAGES;
import static framework.utils.Constants.SEARCHXENDING;

public class TestFacetCount {
    public String frontend = API_TEST + SEARCHXENDING;

    @Test
    public void facetCountCompressedCategoriesLanguages() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNTCOMPRESSEDCATEGORIESLANGUAGES);
        System.out.println(body);
    }

    @Test
    public void facetCount() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNT);
        System.out.println(body);
    }

    @Test
    public void facetCountWithCategories() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNTCATEGORIES);
        System.out.println(body);
    }

    @Test
    public void facetCountWithCategoriesCompressed() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNTCOMPRESSEDCATEGORIES);
        System.out.println(body);
    }

    @Test
    public void facetCountCompressed() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNTCOMPRESSED);
        System.out.println(body);
    }

    @Test
    public void facetCountCompressedLanguage() {
        SearchService service = new SearchService();
        SOAPBody body = service.searchWithXML(frontend, FACETCOUNTCOMPRESSEDLANGUAGES);
        System.out.println(body);
    }

}
