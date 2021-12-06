package framework.response.record;

import org.json.JSONObject;

public class Links {

    private String linktorsrc;
    private String openurl;
    private String openurlfulltext;
    private String thumbnail;
    private String backlink;
    private String linktopdf;
    private String linktohtml;

    public void print()
    {
        System.out.println("********** Links **********");
        System.out.println("linktorsrc: " + this.linktorsrc);
        System.out.println("openurl: " + this.openurl);
        System.out.println("openurlfulltext: " + this.openurlfulltext);
        System.out.println("thumbnail: " + this.thumbnail);
        System.out.println("backlink: " + this.backlink);
        System.out.println("linktopdf: " + this.linktopdf);
        System.out.println("linktohtml: " + this.linktohtml);

    }

    public void load(JSONObject json)
    {
        if (json.has("linktorsrc"))
        {
            this.linktorsrc = json.get("linktorsrc").toString();
        }

        if (json.has("openurl"))
        {
            this.openurl = json.get("openurl").toString();
        }

        if (json.has("openurlfulltext"))
        {
            this.openurlfulltext = json.get("openurlfulltext").toString();
        }

        if (json.has("thumbnail"))
        {
            this.thumbnail = json.get("thumbnail").toString();
        }

        if (json.has("backlink"))
        {
            this.backlink = json.get("backlink").toString();
        }

        if (json.has("linktopdf"))
        {
            this.linktohtml = json.get("linktopdf").toString();
        }

        if (json.has("linktohtml"))
        {
            this.linktohtml = json.get("linktohtml").toString();
        }

    }

    public String getLinktorsrc() {
        return linktorsrc;
    }

    public String getOpenurl() {
        return openurl;
    }

    public String getOpenurlfulltext() {
        return openurlfulltext;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getBacklink() {
        return backlink;
    }

    public String getLinktopdf() {
        return linktopdf;
    }

    public String getLinktohtml() {
        return linktohtml;
    }
}
