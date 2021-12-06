package framework.response;

import org.json.JSONObject;

public class Term {
    private String value;


    public void print()
    {
        System.out.println("Value: " + value);
    }

    public void load(JSONObject json) {
        if (json.has("VALUE")) {
            this.value = json.get("VALUE").toString();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
