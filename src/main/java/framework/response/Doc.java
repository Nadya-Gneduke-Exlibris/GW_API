package framework.response;

import org.json.JSONObject;

public class Doc {

    private long number;
    private String searchEngineType;
    private String searchEngine;
    private double rank;
    private long id;
    private PrimoNMBib primoNMBib;

    public Doc(long number, String searchEngineType, String searchEngine, double rank, long id, PrimoNMBib primoNMBib)
    {
        this.primoNMBib = primoNMBib;
    }

    public Doc()
    {
        this.number = 0;
        this.searchEngineType = null;
        this.searchEngine = null;
        this.rank = 0;
        this.id = 0;
        this.primoNMBib = null;
    }

    public void load(JSONObject json)
    {
        JSONObject  jsonPrimo = json.getJSONObject("PrimoNMBib");

        this.primoNMBib = new PrimoNMBib();
        this.primoNMBib.load(jsonPrimo);

        if (json.has("NO"))
        {
            this.number = json.getLong("NO");
        }
        if (json.has("SEARCH_ENGINE_TYPE"))
        {
            this.searchEngineType = json.get("SEARCH_ENGINE_TYPE").toString();
        }
        if (json.has("SEARCH_ENGINE"))
        {
            this.searchEngine = json.get("SEARCH_ENGINE").toString();
        }
        if (json.has("RANK"))
        {
            this.rank = json.getDouble("RANK");
        }
        if (json.has("ID"))
        {
            this.id = json.getLong("ID");
        }
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getSearchEngineType() {
        return searchEngineType;
    }

    public void setSearchEngineType(String searchEngineType) {
        this.searchEngineType = searchEngineType;
    }

    public String getSearchEngine() {
        return searchEngine;
    }

    public void setSearchEngine(String searchEngine) {
        this.searchEngine = searchEngine;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PrimoNMBib getPrimoNMBib() {
        return primoNMBib;
    }

    public void setPrimoNMBib(PrimoNMBib primoNMBib) {
        this.primoNMBib = primoNMBib;
    }

    //"NO":1,"SEARCH_ENGINE_TYPE":"Local record.Search Engine","SEARCH_ENGINE":"Local record.Search Engine","RANK":0.07,"ID":529746576,"PrimoNMBib"
}
