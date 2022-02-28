package framework.response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Facet {

    private int count;
    private String name;
    private List<FacetValue> facetValues;

    public void load(JSONObject json) {

        if (json.has("COUNT"))
        {
            this.count = json.getInt("COUNT");
        }

        if (json.has("NAME"))
        {
            this.name = json.getString("NAME");
        }

        if (json.has("sear:FACET_VALUES"))
        {
            this.facetValues = new ArrayList<>();

            if (json.get("sear:FACET_VALUES").toString().startsWith("{"))
            {
                JSONObject jsonfacetValue = json.getJSONObject("sear:FACET_VALUES");
                FacetValue facetValue = new FacetValue();
                facetValue.load(jsonfacetValue);
                this.facetValues.add(facetValue);
                return;
            }

            JSONArray jsonFacetValues = json.getJSONArray("sear:FACET_VALUES");

            //add counter
            for (Object jsonFacetValue : jsonFacetValues)
            {
                FacetValue facetValue = new FacetValue();
                facetValue.load((JSONObject) jsonFacetValue);
                this.facetValues.add(facetValue);
            }
        }
    }

    public void print()
    {
        System.out.println("Count: " + this.count);
        System.out.println("Name: " + this.name);
        for (FacetValue facetValue: facetValues)
        {
            facetValue.print();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FacetValue> getFacetValues() {
        return facetValues;
    }

    public void setFacetValues(List<FacetValue> facetValues) {
        this.facetValues = facetValues;
    }
}
