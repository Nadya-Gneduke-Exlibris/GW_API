package framework.service.httprequest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class HTTPRequest {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    public static String postRequest(String url, String request, ContentType contentType) {

        if (contentType == null) {
            contentType = ContentType.TEXT_XML;
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, contentType.getMimeType());
        httpPost.setHeader("Soapaction", "ddd");
        httpPost.setEntity(new StringEntity(request, contentType));
        HttpResponse httpResponse = null;
        String response = null;

        try {
            httpResponse = HttpClientBuilder.create().build().execute(httpPost);
            response = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (httpResponse == null) {
            return null;
        }
        int status = httpResponse.getStatusLine().getStatusCode();

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            System.out.println("Status code: " + status);
            return null;
        }

        System.out.println("Response: " + response);
        return response;
    }

    public void close() throws IOException {
        httpClient.close();
    }

    public String sendGet(String url) throws Exception {


        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);


            // return it as a String
            String result = EntityUtils.toString(entity);
            System.out.println(result);
            return result;
        }
    }

}
