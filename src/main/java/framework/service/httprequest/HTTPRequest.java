package framework.service.httprequest;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class HTTPRequest {

    public static String postRequest(String url, String request)  {
        System.out.println(request);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.TEXT_XML.getMimeType());
        httpPost.setHeader("Soapaction","ddd");
        httpPost.setEntity(new StringEntity(request, ContentType.TEXT_XML));
        HttpResponse httpResponse = null;
        String response = null;
        try {
            httpResponse = HttpClientBuilder.create().build().execute(httpPost);
            response = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = httpResponse.getStatusLine().getStatusCode();

        if (httpResponse.getStatusLine().getStatusCode() != 200)
        {
            System.out.println("Status code: " + status);
            return null;
        }
        return response;
    }

    public static String postRequest(String url, String request, ContentType contentType) throws IOException {

        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, contentType.getMimeType());
        httpPost.setHeader("Soapaction","ddd");
        httpPost.setEntity(new StringEntity(request, contentType));
        HttpResponse httpResponse = null;
        String response = null;

        try {
            httpResponse = HttpClientBuilder.create().build().execute(httpPost);
            response = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int status = httpResponse.getStatusLine().getStatusCode();

        if (httpResponse.getStatusLine().getStatusCode() != 200)
        {
            System.out.println("Status code: " + status);
            return null;
        }

        System.out.println("Response: " + response);
        return response;
    }

}
