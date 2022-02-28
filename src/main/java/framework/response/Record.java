package framework.response;

import framework.response.record.Addata;
import framework.response.record.Control;
import framework.response.record.Delivery;
import framework.response.record.Display;
import framework.response.record.Facets;
import framework.response.record.Links;
import framework.response.record.Search;
import framework.response.record.Sort;
import org.json.JSONObject;

//TODO implement all the fields
public class Record {
    private Delivery delivery;
    private Search search;
    private Display display;
    private Control control;
    private Links links;
    private Sort sort;
    private Addata addata;
    private Facets facets;

    public Record() {
        this.delivery = null;
        this.search = null;
        this.display = null;
        this.control = null;
        this.links = null;
        this.sort = null;
        this.addata = null;
        this.facets = null;
    }

    public Record(Delivery delivery, Search search, Display display, Control control, Links links, Sort sort, Addata addata, Facets facets) {
        this.delivery = delivery;
        this.search = search;
        this.display = display;
        this.control = control;
        this.links = links;
        this.sort = sort;
        this.addata = addata;
        this.facets = facets;
    }

    public void load(JSONObject json) {
        this.display = new Display();
        this.display.load(json.getJSONObject("display"));

        this.control = new Control();
        this.control.load(json.getJSONObject("control"));

        this.delivery = new Delivery();
        this.delivery.load(json.getJSONObject("delivery"));

        this.search = new Search();
        this.search.load(json.getJSONObject("search"));

        this.links = new Links();
        this.links.load(json.getJSONObject("links"));

        this.sort = new Sort();
        this.sort.load(json.getJSONObject("sort"));

        this.addata = new Addata();
        this.addata.load(json.getJSONObject("addata"));

        this.facets = new Facets();
        this.facets.load(json.getJSONObject("facets"));
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Addata getAddata() {
        return addata;
    }

    public void setAddata(Addata addata) {
        this.addata = addata;
    }

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets facets) {
        this.facets = facets;
    }


}
