package framework.utils;

public class Constants {
    public static final String LOADBALANCER = "http://fe.p.prod.primo.saas.exlibrisgroup.com:1701";
    public static final String SST = "http://fe1.sst.pc.dc04.hosted.exlibrisgroup.com:1701";
    public static final String FE0098DC04 = "http://fe0098.proda.pc.dc04.hosted.exlibrisgroup.com:1701";

    public static final String API_CI = "http://api1.ci.cdi.dc04.hosted.exlibrisgroup.com:8011";
    public static final String API_TEST = "http://api1.test.cdi.dc04.hosted.exlibrisgroup.com:8011";

    public static final String API_PREVIEW = "http://api1.preview.cdi.dc04.hosted.exlibrisgroup.com:8011";

    public static final String SEARCHXENDING = "/PrimoWebServices/services/primo/JaguarPrimoSearcher";


    public static final String HARVARDPCKEY = "01HVD.01HVD.PPRD";
    public static final String NEWMEXPCKEY = "01NEWMEX.01NEWMEX_INST_CDI_DEMO_LIB.PSTG";
    public static final String SUPPORTPCKEY = "972SUPPORT.SUPPORT.PPRD";


    public static final String CDI_PROD = "searchCDI=true";
    public static final String CDI_TEST = "searchCDI=test";
    public static final String CDI_PREVIEW = "searchCDI=preview";
    public static final String CDI_CI = "searchCDI=ci";

    public static String searchXExtendedEnvelop = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.ws.primo.exlibris.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <api:searchX soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</query>\n" +
            "         <sort xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</sort>\n" +
            "         <reverse xsi:type=\"xsd:boolean\">%s</reverse>\n" +
            "         <strDidumean xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strDidumean>\n" +
            "         <language xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</language>\n" +
            "         <strFrom xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strFrom>\n" +
            "         <strTake xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strTake>\n" +
            "         <asFull xsi:type=\"xsd:boolean\">%s</asFull>\n" +
            "         <institution xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">%s</affiliatedUser>\n" +
            "         <sessionId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</sessionId>\n" +
            "         <version xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</version>\n" +
            "         <categories xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</categories>\n" +
            "         <degree xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</degree>\n" +
            "         <explain xsi:type=\"xsd:boolean\">%s</explain>\n" +
            "         <explainDocId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</explainDocId>\n" +
            "      </api:searchX>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";

    public static String searchXExtendedCompressedEnvelop = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.ws.primo.exlibris.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <api:searchXCompressed soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</query>\n" +
            "         <sort xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</sort>\n" +
            "         <reverse xsi:type=\"xsd:boolean\">%s</reverse>\n" +
            "         <strDidumean xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strDidumean>\n" +
            "         <language xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</language>\n" +
            "         <strFrom xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strFrom>\n" +
            "         <strTake xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strTake>\n" +
            "         <asFull xsi:type=\"xsd:boolean\">%s</asFull>\n" +
            "         <institution xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">%s</affiliatedUser>\n" +
            "         <sessionId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</sessionId>\n" +
            "         <version xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</version>\n" +
            "         <categories xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</categories>\n" +
            "         <degree xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</degree>\n" +
            "         <explain xsi:type=\"xsd:boolean\">%s</explain>\n" +
            "         <explainDocId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</explainDocId>\n" +
            "      </api:searchXCompressed>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";


    public static String searchXEnvelop = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.ws.primo.exlibris.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <api:searchX soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</query>\n" +
            "         <sort xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</sort>\n" +
            "         <strDidumean xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strDidumean>\n" +
            "         <language xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</language>\n" +
            "         <strFrom xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strFrom>\n" +
            "         <strTake xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</strTake>\n" +
            "         <asFull xsi:type=\"xsd:boolean\">%s</asFull>\n" +
            "         <institution xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">%s</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">%s</affiliatedUser>\n" +
            "      </api:searchX>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";




    public static String FACETCOUNTREQUEST =  "<soapenv:Envelope xmlns:api=\"http://api.ws.primo.exlibris.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><soapenv:Header></soapenv:Header>\n" +
            "\n" +
            "   <soapenv:Body>\n" +
            "      <api:countFacetsCompressedWithCategories soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">((SixteEnth CEntURY)) AND facet_tlevel:(\"online_resources_PC_TN\")</query>\n" +
            "         <sort xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\"/>\n" +
            "         <facets xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://xml.apache.org/xml-soap\" xsi:type=\"ns1:Map\"><item>\n" +
            "<key xsi:type=\"soapenc:string\">rtype</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">media</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">creator</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">kim, s</value>\n" +
            "<value xsi:type=\"soapenc:string\">angelini, a</value>\n" +
            "<value xsi:type=\"soapenc:string\">wood, r</value>\n" +
            "<value xsi:type=\"soapenc:string\">australian opera</value>\n" +
            "<value xsi:type=\"soapenc:string\">fumerton, patricia</value>\n" +
            "<value xsi:type=\"soapenc:string\">gross, s</value>\n" +
            "<value xsi:type=\"soapenc:string\">lacouture, j</value>\n" +
            "<value xsi:type=\"soapenc:string\">cunningham, a</value>\n" +
            "<value xsi:type=\"soapenc:string\">hadden, n</value>\n" +
            "<value xsi:type=\"soapenc:string\">rm arts (firm)</value>\n" +
            "<value xsi:type=\"soapenc:string\">chelazzi dini, g</value>\n" +
            "<value xsi:type=\"soapenc:string\">st?delsches kunstinstitut (frankfurt am main, germany)</value>\n" +
            "<value xsi:type=\"soapenc:string\">jouanna, a</value>\n" +
            "<value xsi:type=\"soapenc:string\">bowsher, j</value>\n" +
            "<value xsi:type=\"soapenc:string\">c.g. boerner (firm)</value>\n" +
            "<value xsi:type=\"soapenc:string\">smith, bruce r.</value>\n" +
            "<value xsi:type=\"soapenc:string\">kruse, h</value>\n" +
            "<value xsi:type=\"soapenc:string\">rosseter, p</value>\n" +
            "<value xsi:type=\"soapenc:string\">hermann, r</value>\n" +
            "<value xsi:type=\"soapenc:string\">cogram, j</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">creationdate</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">1998</value>\n" +
            "<value xsi:type=\"soapenc:string\">1975</value>\n" +
            "<value xsi:type=\"soapenc:string\">1997</value>\n" +
            "<value xsi:type=\"soapenc:string\">1996</value>\n" +
            "<value xsi:type=\"soapenc:string\">1995</value>\n" +
            "<value xsi:type=\"soapenc:string\">1994</value>\n" +
            "<value xsi:type=\"soapenc:string\">1950</value>\n" +
            "<value xsi:type=\"soapenc:string\">1993</value>\n" +
            "<value xsi:type=\"soapenc:string\">1992</value>\n" +
            "<value xsi:type=\"soapenc:string\">1991</value>\n" +
            "<value xsi:type=\"soapenc:string\">1999</value>\n" +
            "<value xsi:type=\"soapenc:string\">1990</value>\n" +
            "<value xsi:type=\"soapenc:string\">1965</value>\n" +
            "<value xsi:type=\"soapenc:string\">1987</value>\n" +
            "<value xsi:type=\"soapenc:string\">1700</value>\n" +
            "<value xsi:type=\"soapenc:string\">1920</value>\n" +
            "<value xsi:type=\"soapenc:string\">1600</value>\n" +
            "<value xsi:type=\"soapenc:string\">1940</value>\n" +
            "<value xsi:type=\"soapenc:string\">1960</value>\n" +
            "<value xsi:type=\"soapenc:string\">1981</value>\n" +
            "<value xsi:type=\"soapenc:string\">1989</value>\n" +
            "<value xsi:type=\"soapenc:string\">1900</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">tlevel</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">available</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">library</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">bapst</value>\n" +
            "<value xsi:type=\"soapenc:string\">linte</value>\n" +
            "<value xsi:type=\"soapenc:string\">nwils</value>\n" +
            "<value xsi:type=\"soapenc:string\">pbrig</value>\n" +
            "<value xsi:type=\"soapenc:string\">onl</value>\n" +
            "<value xsi:type=\"soapenc:string\">nmusi</value>\n" +
            "<value xsi:type=\"soapenc:string\">nbiom</value>\n" +
            "<value xsi:type=\"soapenc:string\">lumd</value>\n" +
            "<value xsi:type=\"soapenc:string\">nmurs</value>\n" +
            "<value xsi:type=\"soapenc:string\">nsci</value>\n" +
            "<value xsi:type=\"soapenc:string\">nand</value>\n" +
            "<value xsi:type=\"soapenc:string\">ninte</value>\n" +
            "<value xsi:type=\"soapenc:string\">nlrc</value>\n" +
            "<value xsi:type=\"soapenc:string\">narch</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">domain</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">linte</value>\n" +
            "<value xsi:type=\"soapenc:string\">nwils</value>\n" +
            "<value xsi:type=\"soapenc:string\">pbrig</value>\n" +
            "<value xsi:type=\"soapenc:string\">nmusi</value>\n" +
            "<value xsi:type=\"soapenc:string\">nbiom</value>\n" +
            "<value xsi:type=\"soapenc:string\">lumd</value>\n" +
            "<value xsi:type=\"soapenc:string\">nmurs</value>\n" +
            "<value xsi:type=\"soapenc:string\">nsci</value>\n" +
            "<value xsi:type=\"soapenc:string\">nand</value>\n" +
            "<value xsi:type=\"soapenc:string\">ninte</value>\n" +
            "<value xsi:type=\"soapenc:string\">nlrc</value>\n" +
            "<value xsi:type=\"soapenc:string\">narch</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">genre</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">catalogs bibliography</value>\n" +
            "<value xsi:type=\"soapenc:string\">slides</value>\n" +
            "<value xsi:type=\"soapenc:string\">sources</value>\n" +
            "<value xsi:type=\"soapenc:string\">congresses</value>\n" +
            "<value xsi:type=\"soapenc:string\">early accounts to 1600</value>\n" +
            "<value xsi:type=\"soapenc:string\">biography</value>\n" +
            "<value xsi:type=\"soapenc:string\">music collections</value>\n" +
            "<value xsi:type=\"soapenc:string\">electronic books</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">topic</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">spain</value>\n" +
            "<value xsi:type=\"soapenc:string\">shakespeare, william, 1564-1616</value>\n" +
            "<value xsi:type=\"soapenc:string\">renaissance</value>\n" +
            "<value xsi:type=\"soapenc:string\">counter-reformation</value>\n" +
            "<value xsi:type=\"soapenc:string\">music</value>\n" +
            "<value xsi:type=\"soapenc:string\">reformation</value>\n" +
            "<value xsi:type=\"soapenc:string\">london (england)</value>\n" +
            "<value xsi:type=\"soapenc:string\">france</value>\n" +
            "<value xsi:type=\"soapenc:string\">reformed church</value>\n" +
            "<value xsi:type=\"soapenc:string\">europe</value>\n" +
            "<value xsi:type=\"soapenc:string\">italy</value>\n" +
            "<value xsi:type=\"soapenc:string\">england</value>\n" +
            "<value xsi:type=\"soapenc:string\">great britain</value>\n" +
            "<value xsi:type=\"soapenc:string\">painting, renaissance</value>\n" +
            "<value xsi:type=\"soapenc:string\">english language</value>\n" +
            "<value xsi:type=\"soapenc:string\">women and literature</value>\n" +
            "<value xsi:type=\"soapenc:string\">literature and society</value>\n" +
            "<value xsi:type=\"soapenc:string\">french literature</value>\n" +
            "<value xsi:type=\"soapenc:string\">women</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">pfilter</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">audio_video</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">lang</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">san</value>\n" +
            "<value xsi:type=\"soapenc:string\">fro</value>\n" +
            "<value xsi:type=\"soapenc:string\">por</value>\n" +
            "<value xsi:type=\"soapenc:string\">spa</value>\n" +
            "<value xsi:type=\"soapenc:string\">ger</value>\n" +
            "<value xsi:type=\"soapenc:string\">mul</value>\n" +
            "<value xsi:type=\"soapenc:string\">ita</value>\n" +
            "<value xsi:type=\"soapenc:string\">fre</value>\n" +
            "<value xsi:type=\"soapenc:string\">lad</value>\n" +
            "<value xsi:type=\"soapenc:string\">lat</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "<item>\n" +
            "<key xsi:type=\"soapenc:string\">lcc</key>\n" +
            "<value soapenc:arrayType=\"soapenc:string[1]\" xsi:type=\"soapenc:Array\">\n" +
            "<value xsi:type=\"soapenc:string\">p - language and literature.</value>\n" +
            "<value xsi:type=\"soapenc:string\">d - history (general) and history of europe.</value>\n" +
            "<value xsi:type=\"soapenc:string\">n - fine arts.</value>\n" +
            "</value>\n" +
            "</item>\n" +
            "</facets>\n" +
            "         <institution xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">972IDC.972IDC_INST.PPRD</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">false</affiliatedUser>\n" +
            "         <version xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">4.9.28</version>\n" +
            "         <searchToken xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">null</searchToken>\n" +
            "         <categories xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"soapenc:string\">;searchCDI=true;useConVoc;isNotBlended;cdiServicesDataFromPnx</categories>\n" +
            "      </api:countFacetsCompressedWithCategories>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    public static String relatedItems = "{\"recordsData\":[{\"isbn\":[\"9264272135\"],\"title\":\"Boost productivity for inclusive growth\",\"creator\":\"OECD\",\"groupId\":\"cdi_FETCH-oecd_books_10_1787_eco_surveys_jpn_2017_3_en3\"}],\"institution\":\"01HVD.01HVD.PPRD\",\"isKnownUser\":\"false\",\"isCDI\":\"true\"}";

    public static String searchXExample = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.ws.primo.exlibris.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <api:searchXCompressed soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">ישראל</query>\n" +
            "         <sort xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">rank</sort>\n" +
            "         <reverse xsi:type=\"xsd:boolean\">false</reverse>\n" +
            "         <strDidumean xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></strDidumean>\n" +
            "         <language xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">eng</language>\n" +
            "         <strFrom xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">1</strFrom>\n" +
            "         <strTake xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">5</strTake>\n" +
            "         <asFull xsi:type=\"xsd:boolean\">false</asFull>\n" +
            "         <institution xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">01HVD.01HVD.PPRD</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">true</affiliatedUser>\n" +
            "         <sessionId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">api:searchX</sessionId>\n" +
            "         <version xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">4.0.0</version>\n" +
            "         <categories xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></categories>\n" +
            "         <degree xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></degree>\n" +
            "         <explain xsi:type=\"xsd:boolean\">false</explain>\n" +
            "         <explainDocId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></explainDocId>\n" +
            "      </api:searchXCompressed>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";
    public static String searchX = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.ws.primo.exlibris.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <api:searchX soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <query xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">ישארל</query>\n" +
            "         <sort xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">rank</sort>\n" +
            "         <reverse xsi:type=\"xsd:boolean\">false</reverse>\n" +
            "         <strDidumean xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></strDidumean>\n" +
            "         <language xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">eng</language>\n" +
            "         <strFrom xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">1</strFrom>\n" +
            "         <strTake xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">5</strTake>\n" +
            "         <asFull xsi:type=\"xsd:boolean\">false</asFull>\n" +
            "         <institution xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">01HVD.01HVD.PPRD</institution>\n" +
            "         <affiliatedUser xsi:type=\"xsd:boolean\">true</affiliatedUser>\n" +
            "         <sessionId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">api:searchX</sessionId>\n" +
            "         <version xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">4.0.0</version>\n" +
            "         <categories xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></categories>\n" +
            "         <degree xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></degree>\n" +
            "         <explain xsi:type=\"xsd:boolean\">false</explain>\n" +
            "         <explainDocId xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"></explainDocId>\n" +
            "      </api:searchX>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";





}
