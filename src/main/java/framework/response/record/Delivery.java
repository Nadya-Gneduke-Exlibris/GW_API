package framework.response.record;

import org.json.JSONObject;

public class Delivery {
    private String delcategory;
    private String fulltext;

    public void print() {
        System.out.println("**********Delivery**********");
        System.out.println("delcategory: " + this.delcategory);
        System.out.println("fulltext: " + this.fulltext);
    }

    public void load(JSONObject json) {
        if (json.has("delcategory")) {
            this.delcategory = json.get("delcategory").toString();
        }

        if (json.has("fulltext")) {
            this.fulltext = json.get("fulltext").toString();
        }
    }

    public String getDelcategory() {
        return delcategory;
    }

    public String getFulltext() {
        return fulltext;
    }

}
