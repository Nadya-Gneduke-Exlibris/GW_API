package framework.response.record;

import org.json.JSONObject;

public class Control {
    private String sourceid;
    private String recordid;
    private String sourcerecordid;
    private String originalsourceid;
    private String addsrcrecordid;
    private String sourcetype;
    private String sourceformat;
    private String sourcesystem;
    private String recordtype;
    private String pqid;
    private String galeid;
    private String cupid;
    private String eruid;
    private String nurid;
    private String ingid;
    private String isCdi;
    private String gtiid;


    public void print() {
        System.out.println("********** Control **********");
        System.out.println("sourceid " + this.sourceid);
        System.out.println("recordid " + this.recordid);
        System.out.println("sourcerecordid " + this.sourcerecordid);
        System.out.println("originalsourceid " + this.originalsourceid);
        System.out.println("addsrcrecordid " + this.addsrcrecordid);
        System.out.println("sourcetype " + this.sourcetype);
        System.out.println("sourceformat " + this.sourceformat);
        System.out.println("sourcesystem " + this.sourcesystem);
        System.out.println("recordtype " + this.recordtype);
        System.out.println("pqid " + this.pqid);
        System.out.println("galeid " + this.galeid);
        System.out.println("cupid " + this.cupid);
        System.out.println("eruid " + this.eruid);
        System.out.println("nurid " + this.nurid);
        System.out.println("ingid " + this.ingid);
        System.out.println("isCdi " + this.isCdi);
        System.out.println("gtiid " + this.gtiid);
    }

    public void load(JSONObject json) {
        if (json.has("sourceid")) {
            this.sourceid = json.get("sourceid").toString();
        }

        if (json.has("recordid")) {
            this.recordid = json.get("recordid").toString();
        }

        if (json.has("sourcerecordid")) {
            this.sourcerecordid = json.get("sourcerecordid").toString();
        }

        if (json.has("originalsourceid")) {
            this.originalsourceid = json.get("originalsourceid").toString();
        }

        if (json.has("addsrcrecordid")) {
            this.addsrcrecordid = json.get("addsrcrecordid").toString();
        }

        if (json.has("sourcetype")) {
            this.sourcetype = json.get("sourcetype").toString();
        }

        if (json.has("sourceformat")) {
            this.sourceformat = json.get("sourceformat").toString();
        }

        if (json.has("sourcesystem")) {
            this.sourcesystem = json.get("sourcesystem").toString();
        }

        if (json.has("recordtype")) {
            this.recordtype = json.get("recordtype").toString();
        }

        if (json.has("pqid")) {
            this.pqid = json.get("pqid").toString();
        }

        if (json.has("galeid")) {
            this.galeid = json.get("galeid").toString();
        }

        if (json.has("cupid")) {
            this.cupid = json.get("cupid").toString();
        }

        if (json.has("eruid")) {
            this.eruid = json.get("eruid").toString();
        }

        if (json.has("nurid")) {
            this.nurid = json.get("nurid").toString();
        }

        if (json.has("ingid")) {
            this.ingid = json.get("ingid").toString();
        }

        if (json.has("isCdi")) {
            this.isCdi = json.get("isCdi").toString();
        }

        if (json.has("gtiid")) {
            this.gtiid = json.get("gtiid").toString();
        }
    }

    public String getSourceid() {
        return sourceid;
    }

    public String getRecordids() {
        return recordid;
    }

    public String getSourcerecordid() {
        return sourcerecordid;
    }

    public String getOriginalsourceid() {
        return originalsourceid;
    }

    public String getAddsrcrecordid() {
        return addsrcrecordid;
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public String getSourceformat() {
        return sourceformat;
    }

    public String getSourcesystem() {
        return sourcesystem;
    }

    public String getRecordtype() {
        return recordtype;
    }

    public String getPqid() {
        return pqid;
    }

    public String getGaleid() {
        return galeid;
    }

    public String getCupid() {
        return cupid;
    }

    public String getEruid() {
        return eruid;
    }

    public String getNurid() {
        return nurid;
    }

    public String getIngid() {
        return ingid;
    }

    public String getIsCdi() {
        return isCdi;
    }

    public String getGtiid() {
        return gtiid;
    }
}
