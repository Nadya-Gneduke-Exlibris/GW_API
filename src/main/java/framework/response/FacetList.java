package framework.response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FacetList {
    private boolean accurateCounters;
    private List<Facet> facets;


    public void load(JSONObject json) {
        this.facets = new ArrayList<>();
        if (json.has("sear:FACET")) {
            JSONArray jsonFacets = json.getJSONArray("sear:FACET");

            //add counter
            for (Object jsonFacet : jsonFacets) {
                Facet facet = new Facet();
                facet.load((JSONObject) jsonFacet);
                this.facets.add(facet);
            }
        }

        if (json.has("ACCURATE_COUNTERS")) {
            this.accurateCounters = json.getBoolean("ACCURATE_COUNTERS");
        }
    }

    public void print() {
        System.out.println("Accurate counters: " + this.accurateCounters);

        for (Facet facet : facets) {
            facet.print();
        }
    }

    public List<Facet> getFacets() {
        return facets;
    }

    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

    public boolean isAccurateCounters() {
        return accurateCounters;
    }

    public void setAccurateCounters(boolean accurateCounters) {
        this.accurateCounters = accurateCounters;
    }
}
