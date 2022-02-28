package framework.response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Highlights {
    private List<Highlight> highlights;

    public void print() {
        for (Highlight highlight : this.highlights) {
            highlight.print();
        }
    }


    public void load(JSONObject json) {
        this.highlights = new ArrayList<>();

        if (json.get("sear:HIGHLIGHT").toString().startsWith("{")) {
            JSONObject jsonHiglight = json.getJSONObject("sear:HIGHLIGHT");
            Highlight highlight = new Highlight();
            highlight.load(jsonHiglight);
            this.highlights.add(highlight);
            return;
        }
        JSONArray jsonHighlights = json.getJSONArray("sear:HIGHLIGHT");

        for (Object jsonHighlight : jsonHighlights) {
            Highlight highlight = new Highlight();
            highlight.load((JSONObject) jsonHighlight);
            this.highlights.add(highlight);
        }
    }

    public List<Highlight> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }


}
