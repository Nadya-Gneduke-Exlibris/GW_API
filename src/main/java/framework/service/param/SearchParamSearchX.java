package framework.service.param;


public class SearchParamSearchX {
    private String query;
    private String sort;
    private String strDidumean;
    private String language;
    private String strFrom;
    private String strTake;
    private String asFull;
    private String institution;
    private String affiliatedUser;

    public SearchParamSearchX(String query, String sort, String strDidumean,
                              String language, String strFrom, String strTake, String asFull, String institution,
                              String affiliatedUser) {
        this.query = query;
        this.sort = sort;
        this.strDidumean = strDidumean;
        this.language = language;
        this.strFrom = strFrom;
        this.strTake = strTake;
        this.asFull = asFull;
        this.institution = institution;
        this.affiliatedUser = affiliatedUser;
    }


    public SearchParamSearchX() {
        this.query = "nuclear power";
        this.sort = "rank";
        this.strDidumean = "";
        this.language = "eng";
        this.strFrom = "1";
        this.strTake = "10";
        this.asFull = "false";
        this.institution = "01HVD.01HVD.PPRD";
        this.affiliatedUser = "true";
    }

    public SearchParamSearchX(String query) {
        this.query = query;
        this.sort = "rank";
        this.strDidumean = "";
        this.language = "eng";
        this.strFrom = "1";
        this.strTake = "5";
        this.asFull = "false";
        this.institution = "01HVD.01HVD.PPRD";
        this.affiliatedUser = "true";
    }

    public SearchParamSearchX(String query, String sort) {
        this.query = query;
        this.sort = sort;
        this.strDidumean = "";
        this.language = "eng";
        this.strFrom = "1";
        this.strTake = "5";
        this.asFull = "false";
        this.institution = "01HVD.01HVD.PPRD";
        this.affiliatedUser = "true";
    }

    public SearchParamSearchX(String query, String sort, String strTake) {
        this.query = query;
        this.sort = sort;
        this.strDidumean = "";
        this.language = "eng";
        this.strFrom = "1";
        this.strTake = strTake;
        this.asFull = "false";
        this.institution = "01HVD.01HVD.PPRD";
        this.affiliatedUser = "true";
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStrDidumean() {
        return strDidumean;
    }

    public void setStrDidumean(String strDidumean) {
        this.strDidumean = strDidumean;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStrFrom() {
        return strFrom;
    }

    public void setStrFrom(String strFrom) {
        this.strFrom = strFrom;
    }

    public String getStrTake() {
        return strTake;
    }

    public void setStrTake(String strTake) {
        this.strTake = strTake;
    }

    public String getAsFull() {
        return asFull;
    }

    public void setAsFull(String asFull) {
        this.asFull = asFull;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAffiliatedUser() {
        return affiliatedUser;
    }

    public void setAffiliatedUser(String affiliatedUser) {
        this.affiliatedUser = affiliatedUser;
    }

}
