package framework.response.record;

import org.json.JSONObject;

public class Sort {

    private String creationDate;
    private String title;
    private String author;

    public void print() {
        System.out.println("**********Sort**********");
        System.out.println("creationdate: " + this.creationDate);
        System.out.println("title: " + this.title);
        System.out.println("author: " + this.author);
    }

    public void load(JSONObject json) {
        if (json.has("creationdate")) {
            this.creationDate = json.get("creationdate").toString();
        }

        if (json.has("title")) {
            this.title = json.get("title").toString();
        }

        if (json.has("author")) {
            this.author = json.get("author").toString();
        }
    }

    public String getCreationdate() {
        return creationDate;
    }

    public String getTitles() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
