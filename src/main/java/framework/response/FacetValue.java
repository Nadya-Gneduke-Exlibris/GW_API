package framework.response;

import org.json.JSONObject;

public class FacetValue {

    private String key;
    private int value;

    public void load(JSONObject json) {
        if (json.has("KEY")) {
            this.key = json.get("KEY").toString();
        }

        if (json.has("VALUE")) {
            this.value = json.getInt("VALUE");
        }
    }

    public void print() {
        System.out.println("Key: " + this.key);
        System.out.println("Value: " + this.value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
