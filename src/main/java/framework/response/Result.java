package framework.response;

import org.json.JSONObject;


public class Result {
    private Docset docSet;
    private FacetList facetList;
    private Highlights highlights;

    //TODO add "sear:QUERYTRANSFORMS":""

    public Result ()
    {
        this.docSet = null;
        this.facetList = null;
        this.highlights = null;

    }

    public void loadDocSet(JSONObject json)
    {
        if (json.has("sear:DOCSET"))
        {
            JSONObject docset = json.getJSONObject("sear:DOCSET");
            this.docSet = new Docset();
            this.docSet.load(docset);
        }
    }

    public void loadFacetList(JSONObject json)
    {

        if (json.has("sear:FACETLIST"))
        {
            JSONObject facetList = json.getJSONObject("sear:FACETLIST");
            this.facetList = new FacetList();
            this.facetList.load(facetList);
        }
    }

    public void loadHighlights(JSONObject json)
    {
        if (json.has("sear:HIGHLIGHTS") && json.get("sear:HIGHLIGHTS").toString() != "")
        {
            JSONObject highlights = json.getJSONObject("sear:HIGHLIGHTS");
            this.highlights = new Highlights();
            this.highlights.load(highlights);
        }

    }

    public void load(JSONObject json)
    {
        if (json.has("sear:DOCSET"))
        {
            JSONObject docset = json.getJSONObject("sear:DOCSET");
            this.docSet = new Docset();
            this.docSet.load(docset);
        }

        if (json.has("sear:FACETLIST"))
        {
            //TODO implement
        }

    }

    public Docset getDocSet() {
        return docSet;
    }

    public FacetList getFacetList() {
        return facetList;
    }

    public Highlights getHighlights() {
        return highlights;
    }


}
