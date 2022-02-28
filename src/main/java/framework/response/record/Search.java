package framework.response.record;

import org.json.JSONObject;


public class Search {
    private String creationDate;
    private String creator;
    private String creatorContrib;
    private String description;
    private String endDate;
    private String fullText;
    private String general;
    private String issn;
    private String recordId;
    private String recordType;
    private String rsrcType;
    private String scope;
    private String sourceId;
    private String startDate;
    private String title;
    private String contributor;
    private String subject;
    private String orcidid;

    public void load(JSONObject json) {
        if (json.has("creationdate")) {
            this.creationDate = json.get("creationdate").toString();
        }

        if (json.has("creator")) {
            this.creator = json.get("creator").toString();
        }

        if (json.has("creatorcontrib")) {
            this.creatorContrib = json.get("creatorcontrib").toString();
        }

        if (json.has("description")) {
            this.description = json.get("description").toString();
        }

        if (json.has("enddate")) {
            this.endDate = json.get("enddate").toString();
        }

        if (json.has("fulltext")) {
            this.fullText = json.get("fulltext").toString();
        }

        if (json.has("general")) {
            this.general = json.get("general").toString();
        }

        if (json.has("issn")) {
            this.issn = json.get("issn").toString();
        }

        if (json.has("recordid")) {
            this.recordId = json.get("recordid").toString();
        }

        if (json.has("recordtype")) {
            this.recordType = json.get("recordtype").toString();
        }

        if (json.has("rsrctype")) {
            this.rsrcType = json.get("rsrctype").toString();
        }

        if (json.has("scope")) {
            this.scope = json.get("scope").toString();
        }

        if (json.has("sourceid")) {
            this.sourceId = json.get("sourceid").toString();
        }

        if (json.has("startdate")) {
            this.startDate = json.get("startdate").toString();
        }

        if (json.has("title")) {
            this.title = json.get("title").toString();
        }

        if (json.has("contributor")) {
            this.contributor = json.get("contributor").toString();
        }

        if (json.has("subject")) {
            this.subject = json.get("subject").toString();
        }

        if (json.has("orcidid")) {
            this.orcidid = json.get("orcidid").toString();
        }

    }

    public void print() {
        System.out.println("********** Search **********");
        System.out.println("creationdate: " + this.creationDate);
        System.out.println("creator: " + this.creator);
        System.out.println("creatorContrib: " + this.creatorContrib);
        System.out.println("description: " + this.description);
        System.out.println("endDate: " + this.endDate);
        System.out.println("fullText: " + this.fullText);
        System.out.println("general: " + this.general);
        System.out.println("issn: " + this.issn);
        System.out.println("recordId: " + this.recordId);
        System.out.println("recordType: " + this.recordType);
        System.out.println("rsrcType: " + this.rsrcType);
        System.out.println("scope: " + this.scope);
        System.out.println("sourceId: " + this.sourceId);
        System.out.println("startDate: " + this.startDate);
        System.out.println("title: " + this.title);
        System.out.println("contributor: " + this.contributor);
        System.out.println("subject: " + this.subject);
        System.out.println("isbn: " + this.orcidid);

    }

    public String getCreationdate() {
        return creationDate;
    }

    public String getCreatorcontrib() {
        return creatorContrib;
    }

    public String getDescription() {
        return description;
    }

    public String getEnddate() {
        return endDate;
    }

    public String getFulltext() {
        return fullText;
    }

    public String getGeneral() {
        return general;
    }

    public String getIssns() {
        return issn;
    }

    public String getRecordid() {
        return recordId;
    }

    public String getRecordtype() {
        return recordType;
    }

    public String getRsrctype() {
        return rsrcType;
    }

    public String getScope() {
        return scope;
    }

    public String getSourceid() {
        return sourceId;
    }

    public String getStartdate() {
        return startDate;
    }

    public String getTitles() {
        return title;
    }

    public String getCreators() {
        return creator;
    }

    public String getSubject() {
        return subject;
    }

    public String getOrcidids() {
        return orcidid;
    }

    public String getContributors() {
        return contributor;
    }
}
