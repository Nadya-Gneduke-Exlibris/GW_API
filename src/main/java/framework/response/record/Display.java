package framework.response.record;

import org.json.JSONObject;

public class Display {

    private String title;
    private String subject;
    private String contributor;
    private String creationDate;
    private String creator;
    private String creatorContrib;
    private String description;
    private String identifier;
    private String isPartOf;
    private String language;
    private String publisher;
    private String rights;
    private String snippet;
    private String source;
    private String type;
    private String cites;
    private String citedBy;
    private String oa;
    private String scopuscitedreferencesoriginalsourcerecordid;
    private String scopuscitedreferencescount;
    private String woscitedreferencesoriginalsourcerecordid;
    private String woscitedreferencescount;
    private String lds50;


    public void print() {
        System.out.println("********** Display **********");
        System.out.println("Title: " + this.title);
        System.out.println("Subject: " + this.subject);
        System.out.println("Creator: " + this.creator);
        System.out.println("Creatorcontrib: " + this.creatorContrib);
        System.out.println("Creationdate: " + this.creationDate);
        System.out.println("ispartof: " + this.isPartOf);
        System.out.println("Contributor: " + this.contributor);
        System.out.println("Description: " + this.description);
        System.out.println("Identifiers: " + this.identifier);
        System.out.println("Language: " + this.language);
        System.out.println("Publishers: " + this.publisher);
        System.out.println("Rights: " + this.rights);
        System.out.println("Snippet: " + this.snippet);
        System.out.println("Sources: " + this.source);
        System.out.println("Type: " + this.type);
        System.out.println("Cites: " + this.cites);
        System.out.println("CitedBy: " + this.citedBy);
        System.out.println("oa: " + this.oa);
        System.out.println("Scopuscitedreferencesoriginalsourcerecordid: " + this.scopuscitedreferencesoriginalsourcerecordid);
        System.out.println("Scopuscitedreferencescount: " + this.scopuscitedreferencescount);
        System.out.println("Woscitedreferencesoriginalsourcerecordid: " + this.woscitedreferencesoriginalsourcerecordid);
        System.out.println("Woscitedreferencescount: " + this.woscitedreferencescount);
        System.out.println("Lds50: " + this.lds50);

    }

    public void load(JSONObject json) {
        if (json.has("title")) {
            this.title = json.get("title").toString();
        }

        if (json.has("subject")) {
            this.subject = json.get("subject").toString();
        }

        if (json.has("creator")) {
            this.creator = json.get("creator").toString();
        }

        if (json.has("creatorcontrib")) {
            this.creatorContrib = json.get("creatorcontrib").toString();
        }

        if (json.has("creationdate")) {
            this.creationDate = json.get("creationdate").toString();
        }

        if (json.has("ispartof")) {
            this.isPartOf = json.get("ispartof").toString();
        }

        if (json.has("contributor")) {
            this.contributor = json.get("contributor").toString();
        }

        if (json.has("description")) {
            this.description = json.get("description").toString();
        }

        if (json.has("identifier")) {
            this.identifier = json.get("identifier").toString();
        }

        if (json.has("language")) {
            this.language = json.get("language").toString();
        }

        if (json.has("publisher")) {
            this.publisher = json.get("publisher").toString();
        }

        if (json.has("rights")) {
            this.rights = json.get("rights").toString();
        }

        if (json.has("snippet")) {
            this.snippet = json.get("snippet").toString();
        }

        if (json.has("source")) {
            this.source = json.get("source").toString();
        }

        if (json.has("type")) {
            this.type = json.get("type").toString();
        }

        if (json.has("cites")) {
            this.cites = json.get("cites").toString();
        }

        if (json.has("citedby")) {
            this.citedBy = json.get("citedby").toString();
        }

        if (json.has("oa")) {
            this.oa = json.get("oa").toString();
        }

        if (json.has("scopuscitedreferencesoriginalsourcerecordid")) {
            this.scopuscitedreferencesoriginalsourcerecordid = json.get("scopuscitedreferencesoriginalsourcerecordid").toString();
        }

        if (json.has("scopuscitedreferencescount")) {
            this.scopuscitedreferencescount = json.get("scopuscitedreferencescount").toString();
        }

        if (json.has("woscitedreferencesoriginalsourcerecordid")) {
            this.woscitedreferencesoriginalsourcerecordid = json.get("woscitedreferencesoriginalsourcerecordid").toString();
        }

        if (json.has("woscitedreferencescount")) {
            this.woscitedreferencescount = json.get("woscitedreferencescount").toString();
        }

        if (json.has("lds50")) {
            this.lds50 = json.get("lds50").toString();
        }
    }

    public String getLds50() {
        return lds50;
    }

    public String getContributors() {
        return contributor;
    }

    public String getCreationdate() {
        return creationDate;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public String getIdentifiers() {
        return identifier;
    }

    public String getIspartof() {
        return isPartOf;
    }

    public String getLanguage() {
        return language;
    }

    public String getPublishers() {
        return publisher;
    }

    public String getRights() {
        return rights;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getSources() {
        return source;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getCites() {
        return cites;
    }

    public String getCitedBy() {
        return citedBy;
    }

    public String getOa() {
        return oa;
    }

    public String getScopuscitedreferencesoriginalsourcerecordid() {
        return scopuscitedreferencesoriginalsourcerecordid;
    }

    public String getWoscitedreferencesoriginalsourcerecordid() {
        return woscitedreferencesoriginalsourcerecordid;
    }

    public String getScopuscitedreferencescount() {
        return scopuscitedreferencescount;
    }

    public String getWoscitedreferencescount() {
        return woscitedreferencescount;
    }

    public String getCreatorContrib() {
        return creatorContrib;
    }
}
