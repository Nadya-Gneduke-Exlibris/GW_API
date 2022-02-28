package framework.response;

import org.json.JSONObject;

public class PrimoNMBib {
    private Record record;

    public PrimoNMBib() {
        this.record = null;
    }

    public void load(JSONObject json) {
        JSONObject jsonRecord = json.getJSONObject("record");
        this.record = new Record();
        this.record.load(jsonRecord);
    }


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
