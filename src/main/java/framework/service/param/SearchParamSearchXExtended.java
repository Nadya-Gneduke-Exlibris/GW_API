package framework.service.param;

public class SearchParamSearchXExtended extends SearchParamSearchX {
    private String reverse;
    private String sessionId;
    private String version;
    private String categories;
    private String degree;
    private String explain;
    private String explainDocId;


    public SearchParamSearchXExtended(String query, String sort, String strDidumean, String language, String strFrom,
                                      String strTake, String asFull, String institution, String affiliatedUser,
                                      String reverse, String sessionId, String version, String categories,
                                      String degree, String explain, String explainDocId) {
        super(query, sort, strDidumean, language, strFrom, strTake, asFull, institution, affiliatedUser);
        this.reverse = reverse;
        this.sessionId = sessionId;
        this.version = version;
        this.categories = categories;
        this.degree = degree;
        this.explain = explain;
        this.explainDocId = explainDocId;
    }

    public SearchParamSearchXExtended(String query, String institution, String categories, String strTake) {
        super(query, "rank", "", "eng", "1", strTake, "false", institution, "false");
        this.reverse = "false";
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = categories;
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }

    public SearchParamSearchXExtended(String query, String sort, String reverse, String categories, String strTake) {
        super(query, sort, "", "eng", "1", strTake, "false", "01HVD.01HVD.PPRD", "false");
        this.reverse = reverse;
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = categories;
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }

    public SearchParamSearchXExtended() {
        super();
        this.reverse = "false";
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = ";isRelatedItems=false;newspapersActive=false;refEntryActive=true;excludeCdiEbooks=false;useConVoc;isNewUi;isNotBlended;cdiServicesDataFromPnx;";
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }

    public SearchParamSearchXExtended(String query) {
        super(query);
        this.reverse = "false";
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = ";isRelatedItems=false;newspapersActive=false;refEntryActive=true;excludeCdiEbooks=false;useConVoc;isNewUi;isNotBlended;cdiServicesDataFromPnx";
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }

    public SearchParamSearchXExtended(String query, String sort) {
        super(query, sort);
        this.reverse = "false";
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = ";isRelatedItems=false;newspapersActive=false;refEntryActive=true;excludeCdiEbooks=false;useConVoc;isNewUi;isNotBlended;cdiServicesDataFromPnx";
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }

    public SearchParamSearchXExtended(String query, String sort, String strTake) {
        super(query, sort, strTake);
        this.reverse = "false";
        this.sessionId = "api:searchX";
        this.version = "4.9.27";
        this.categories = ";isRelatedItems=false;newspapersActive=false;refEntryActive=true;excludeCdiEbooks=false;useConVoc;isNewUi;isNotBlended;cdiServicesDataFromPnx";
        this.degree = "";
        this.explain = "false";
        this.explainDocId = "";
    }


    public String getReverse() {
        return reverse;
    }

    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplainDocId() {
        return explainDocId;
    }

    public void setExplainDocId(String explainDocId) {
        this.explainDocId = explainDocId;
    }

}
