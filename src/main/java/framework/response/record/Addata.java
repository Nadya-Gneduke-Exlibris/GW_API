package framework.response.record;

import org.json.JSONObject;

public class Addata {
    private String articleAbstract;
    private String atitle;
    private String au;
    private String auinitm;
    private String aufirst;
    private String aulast;
    private String btitle;
    private String pmid;
    private String cop;
    private String seriesTitle;
    private String date;
    private String doi;
    private String eisbn;
    private String eissn;
    private String epage;
    private String format;
    private String genre;
    private String isbn;
    private String issn;
    private String issue;
    private String jtitle;
    private String notes;
    private String oclcid;
    private String pages;
    private String pub;
    private String risdate;
    private String ristype;
    private String spage;
    private String url;
    private String volume;
    private String orcidid;
    private String oa;

    public void print() {
        System.out.println("********** Addata **********");
        System.out.println("articleAbstract: " + this.articleAbstract);
        System.out.println("atitle: " + this.atitle);
        System.out.println("au: " + this.au);
        System.out.println("auinitm: " + this.auinitm);
        System.out.println("aufirst: " + this.aufirst);
        System.out.println("aulast: " + this.aulast);
        System.out.println("btitle: " + this.btitle);
        System.out.println("pmid: " + this.pmid);
        System.out.println("cop: " + this.cop);
        System.out.println("seriesTitle: " + this.seriesTitle);
        System.out.println("date: " + this.date);
        System.out.println("doi: " + this.doi);
        System.out.println("eisbn: " + this.eisbn);
        System.out.println("eissn: " + this.eissn);
        System.out.println("epage: " + this.epage);
        System.out.println("format: " + this.format);
        System.out.println("genre: " + this.genre);
        System.out.println("isbn: " + this.isbn);
        System.out.println("issn: " + this.issn);
        System.out.println("issue: " + this.issue);
        System.out.println("jtitle: " + this.jtitle);
        System.out.println("notes: " + this.notes);
        System.out.println("oclcid: " + this.oclcid);
        System.out.println("pages: " + this.pages);
        System.out.println("pub: " + this.pub);
        System.out.println("risdate: " + this.risdate);
        System.out.println("ristype: " + this.ristype);
        System.out.println("spage: " + this.spage);
        System.out.println("url: " + this.url);
        System.out.println("volume: " + this.volume);
        System.out.println("orcidid: " + this.orcidid);
        System.out.println("oa: " + this.oa);

    }

    public void load(JSONObject json) {
        if (json.has("abstract")) {
            this.articleAbstract = json.get("abstract").toString();
        }

        if (json.has("atitle")) {
            this.atitle = json.get("atitle").toString();
        }

        if (json.has("au")) {
            this.au = json.get("au").toString();
        }

        if (json.has("auinitm")) {
            this.auinitm = json.get("auinitm").toString();
        }

        if (json.has("aufirst")) {
            this.aufirst = json.get("aufirst").toString();
        }

        if (json.has("aulast")) {
            this.aulast = json.get("aulast").toString();
        }

        if (json.has("btitle")) {
            this.btitle = json.get("btitle").toString();
        }

        if (json.has("pmid")) {
            this.pmid = json.get("pmid").toString();
        }

        if (json.has("cop")) {
            this.cop = json.get("cop").toString();
        }

        if (json.has("seriestitle")) {
            this.seriesTitle = json.get("seriestitle").toString();
        }

        if (json.has("date")) {
            this.date = json.get("date").toString();
        }

        if (json.has("doi")) {
            this.doi = json.get("doi").toString();
        }

        if (json.has("eisbn")) {
            this.eisbn = json.get("eisbn").toString();
        }

        if (json.has("eissn")) {
            this.eissn = json.get("eissn").toString();
        }

        if (json.has("epage")) {
            this.epage = json.get("epage").toString();
        }

        if (json.has("format")) {
            this.format = json.get("format").toString();
        }

        if (json.has("genre")) {
            this.genre = json.get("genre").toString();
        }

        if (json.has("isbn")) {
            this.isbn = json.get("isbn").toString();
        }

        if (json.has("issn")) {
            this.issn = json.get("issn").toString();
        }

        if (json.has("issue")) {
            this.issue = json.get("issue").toString();
        }

        if (json.has("jtitle")) {
            this.jtitle = json.get("jtitle").toString();
        }

        if (json.has("notes")) {
            this.notes = json.get("notes").toString();
        }

        if (json.has("oclcid")) {
            this.oclcid = json.get("oclcid").toString();
        }

        if (json.has("pages")) {
            this.pages = json.get("pages").toString();
        }

        if (json.has("pub")) {
            this.pub = json.get("pub").toString();
        }

        if (json.has("risdate")) {
            this.risdate = json.get("risdate").toString();
        }

        if (json.has("ristype")) {
            this.ristype = json.get("ristype").toString();
        }

        if (json.has("spage")) {
            this.spage = json.get("spage").toString();
        }

        if (json.has("url")) {
            this.url = json.get("url").toString();
        }

        if (json.has("volume")) {
            this.volume = json.get("volume").toString();
        }

        if (json.has("orcidid")) {
            this.orcidid = json.get("orcidid").toString();
        }

        if (json.has("oa")) {
            this.oa = json.get("oa").toString();
        }

    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public String getAtitle() {
        return atitle;
    }

    public String getAufirst() {
        return aufirst;
    }

    public String getAuinitm() {
        return auinitm;
    }

    public String getAulast() {
        return aulast;
    }

    public String getBtitle() {
        return btitle;
    }

    public String getPmids() {
        return pmid;
    }

    public String getCop() {
        return cop;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public String getDate() {
        return date;
    }

    public String getDoi() {
        return doi;
    }

    public String getEisbn() {
        return eisbn;
    }

    public String getEissn() {
        return eissn;
    }

    public String getEpage() {
        return epage;
    }

    public String getFormat() {
        return format;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIssn() {
        return issn;
    }

    public String getIssue() {
        return issue;
    }

    public String getJtitle() {
        return jtitle;
    }

    public String getNotes() {
        return notes;
    }

    public String getOclcid() {
        return oclcid;
    }

    public String getPages() {
        return pages;
    }

    public String getPub() {
        return pub;
    }

    public String getRisdate() {
        return risdate;
    }

    public String getRistype() {
        return ristype;
    }

    public String getSpage() {
        return spage;
    }

    public String getUrl() {
        return url;
    }

    public String getVolume() {
        return volume;
    }

    public String getOrcidids() {
        return orcidid;
    }

    public String getOa() {
        return oa;
    }

    public String getAu() {
        return au;
    }
}
