package framework.response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Highlight {
    private List<Term> terms;
    private String field;

    public void print()
    {
        for (Term term : this.terms)
        {
            term.print();
        }
        System.out.println("Field: " + this.field);
    }

    public void load(JSONObject json)
    {
        this.terms = new ArrayList<>();
        if (json.has("FIELD"))
        {
            this.field = json.get("FIELD").toString();
        }

        if (json.has("sear:TERM"))
        {
            if (json.get("sear:TERM").toString().startsWith("{"))
            {
                JSONObject jsonTerm = json.getJSONObject("sear:TERM");
                Term term = new Term();
                term.load((JSONObject) jsonTerm);
                this.terms.add(term);
                return;
            }

            JSONArray jsonTerms = json.getJSONArray("sear:TERM");

            for (Object jsonTerm : jsonTerms)
            {
                Term term = new Term();
                term.load((JSONObject) jsonTerm);
                this.terms.add(term);
            }
        }
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
