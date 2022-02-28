package framework.response.record;

import org.json.JSONObject;

public class Facets {

    private String frbrType;
    private String frbrGroupId;
    private String rsrcType;
    private String prefilter;
    private String language;
    private String creationDate;
    private String creatorContrib;
    private String collection;
    private String jTitle;
    private String genre;
    private String topic;
    private String topLevel;

    public void print() {
        System.out.println("********** Facets **********");
        System.out.println("frbrType: " + this.frbrType);
        System.out.println("frbrGroupId: " + this.frbrGroupId);
        System.out.println("rsrcType: " + this.rsrcType);
        System.out.println("prefilter: " + this.prefilter);
        System.out.println("language: " + this.language);
        System.out.println("creationDate: " + this.creationDate);
        System.out.println("creatorContrib: " + this.creatorContrib);
        System.out.println("collection: " + this.collection);
        System.out.println("jTitle: " + this.jTitle);
        System.out.println("genre: " + this.genre);
        System.out.println("topic: " + this.topic);
        System.out.println("toplevel: " + this.topLevel);
    }

    public void load(JSONObject json) {
        if (json.has("frbrtype")) {
            this.frbrType = json.get("frbrtype").toString();
        }

        if (json.has("frbrgroupid")) {
            this.frbrGroupId = json.get("frbrgroupid").toString();
        }

        if (json.has("rsrctype")) {
            this.rsrcType = json.get("rsrctype").toString();
        }

        if (json.has("prefilter")) {
            this.prefilter = json.get("prefilter").toString();
        }

        if (json.has("language")) {
            this.language = json.get("language").toString();
        }

        if (json.has("creationdate")) {
            this.creationDate = json.get("creationdate").toString();
        }

        if (json.has("creatorcontrib")) {
            this.creatorContrib = json.get("creatorcontrib").toString();
        }

        if (json.has("collection")) {
            this.collection = json.get("collection").toString();
        }

        if (json.has("jtitle")) {
            this.jTitle = json.get("jtitle").toString();
        }

        if (json.has("genre")) {
            this.genre = json.get("genre").toString();
        }

        if (json.has("topics")) {
            this.topic = json.get("topics").toString();
        }

        if (json.has("toplevels")) {
            this.topLevel = json.get("toplevels").toString();
        }

    }

    public String getRsrctype() {
        return rsrcType;
    }

    public String getPrefilter() {
        return prefilter;
    }

    public String getLanguage() {
        return language;
    }

    public String getCreationdate() {
        return creationDate;
    }

    public String getCreatorcontrib() {
        return creatorContrib;
    }

    public String getCollection() {
        return collection;
    }

    public String getJtitle() {
        return jTitle;
    }

    public String getGenre() {
        return genre;
    }

    public String getTopics() {
        return topic;
    }

    public String getToplevels() {
        return topLevel;
    }

    public String getFrbrgroupid() {
        return frbrGroupId;
    }

    public String getFrbrtype() {
        return frbrType;
    }
}
