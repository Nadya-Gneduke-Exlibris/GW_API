package framework.response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Docset {

    private int lastHits;
    private int totalTime;
    private long totalHits;
    private int firstHit;
    private int hitTime;
    private List<Doc> docs;



    public Docset(int lastHits, int totalTime, long totalHits, int firstHit, int hitTime, List<Doc> docs)
    {
        this.lastHits = lastHits;
        this.totalTime = totalTime;
        this.totalHits = totalHits;
        this.firstHit = firstHit;
        this.hitTime = hitTime;
        this.docs = docs;
    }

    public Docset()
    {
        this.lastHits = 0;
        this.totalTime = 0;
        this.totalHits = 0;
        this.firstHit = 0;
        this.hitTime = 0;
        this.docs = null;

    }

    public void load(JSONObject json)
    {
        this.docs = new ArrayList<>();
        this.lastHits = json.getInt("LASTHIT");
        this.totalTime = json.getInt("TOTAL_TIME");
        this.totalHits = json.getInt("TOTALHITS");
        this.firstHit = json.getInt("FIRSTHIT");
        this.hitTime = json.getInt("HIT_TIME");

        if (json.has("sear:DOC"))
        {
            if (this.totalHits == 1)
            {
                Doc doc = new Doc();
                doc.load(json.getJSONObject("sear:DOC"));
                this.docs.add(doc);
                return;
            }

            JSONArray jsonDocs = json.getJSONArray("sear:DOC");

            //add counter
            for (Object jsonDoc : jsonDocs)
            {
                Doc doc = new Doc();
                doc.load((JSONObject) jsonDoc);
                this.docs.add(doc);
            }
        }
    }

    public int getLastHit() {
        return lastHits;
    }

    public void setLastHit(int lastHits) {
        this.lastHits = lastHits;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public int getFirstHit() {
        return firstHit;
    }

    public void setFirstHit(int firstHit) {
        this.firstHit = firstHit;
    }

    public int getHitTime() {
        return hitTime;
    }

    public void setHitTime(int hitTime) {
        this.hitTime = hitTime;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

}
