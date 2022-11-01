package io.murad;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;
import org.apache.http.util.EntityUtils;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.util.URIUtil;

public class Main {
    public String scrapeData(String regex, String content) {
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        StringBuilder outputContent = new StringBuilder();

        while (matcher.find()) {
            outputContent.append(matcher.group(1));
        }
        return outputContent.toString();
    }
    public static void main(String[] args) throws IOException, URISyntaxException {
        String POST_URL = "https://www.njportal.com/DOR/BusinessNameSearch/Search/BusinessName";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.addHeader("User-Agent", "Chrome/107.0.0.0");
        httpPost.addHeader( "Content-Type", "text/html");
        httpPost.addHeader( "charset", "utf-8");


        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("__RequestVerificationToken", "3h5-sz4N0zTDltSG7r6a65LF2dHA8sv5oq6AdKrRQzEqgq7mJnD8vkm3NCXbDI6kYc0O49DhXMVE8XSkvR6ipHYDjgc_z7S6M8u8g8jt2ygH-Z60AYnXlevEwgOUX3AXxbaqcw2"));
        urlParameters.add(new BasicNameValuePair("BusinessName", "%"+25+"a"));

//        String urlParameters = "__RequestVerificationToken=3h5-sz4N0zTDltSG7r6a65LF2dHA8sv5oq6AdKrRQzEqgq7mJnD8vkm3NCXbDI6kYc0O49DhXMVE8XSkvR6ipHYDjgc_z7S6M8u8g8jt2ygH-Z60AYnXlevEwgOUX3AXxbaqcw2&BusinessName=%25a"
//        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
//        httpPost.setEntity(postParams);
//
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//
//        System.out.println("POST Response Status:: "
//                + httpResponse.getStatusLine().getStatusCode());
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                httpResponse.getEntity().getContent()));


        HttpGet httpGet = new HttpGet(POST_URL);
//        httpGet.addHeader("User-Agent", "Chrome/107.0.0.0");
        CloseableHttpResponse httpResponse2 = httpClient.execute(httpGet);

        System.out.println("GET Response Status:: "
                + httpResponse2.getStatusLine().getStatusCode());
        System.out.println(httpResponse2.getHeaders("Set-Cookie").toString());
//        System.out.println(httpResponse2.getEntity().getContent());

//        Scanner sc = new Scanner(httpResponse2.getEntity().getContent());
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse2.getEntity().getContent()));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }

        bufferedReader.close();


//        while(sc.hasNext()) {
//
//            System.out.println(sc.nextLine());
//
//        }

//        System.out.println(stringBuilder.toString());

        Main m = new Main();
        String div = m.scrapeData("__RequestVerificationToken.+?value=\"(.+?)\"",stringBuilder.toString());
        System.out.println(div);

        Map<String,String> params = new HashMap<>();
        params.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        params.put("__RequestVerificationToken","");
        params.put("BusinessName",25+"%");

        HttpParams paramss = new BasicHttpParams();
//        paramss.setParameter("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        paramss.setParameter("__RequestVerificationToken",div);
        paramss.setParameter("BusinessName",25+"%a");

        List nameValuePairs = new ArrayList();
        nameValuePairs.add(new BasicNameValuePair("__RequestVerificationToken", div));
        nameValuePairs.add(new BasicNameValuePair("BusinessName", 25+"%a"));

        URIBuilder builder = new URIBuilder(POST_URL);
        builder.setParameter("__RequestVerificationToken", div).setParameter("BusinessName", "%a");

        System.out.println(builder.build());

//        HttpPost httpPost1 = new HttpPost(builder.build());

        HttpPost httpPost1 = new HttpPost(POST_URL);
//        httpPost1.addHeader("__RequestVerificationToken",div);
//        httpPost1.addHeader("BusinessName", "%a");

        List<NameValuePair> urlParameterss = new ArrayList<NameValuePair>();
        urlParameterss.add(new BasicNameValuePair("__RequestVerificationToken", div));
        urlParameterss.add(new BasicNameValuePair("BusinessName", "%a"));
        HttpEntity postParams = new UrlEncodedFormEntity(urlParameterss);
        httpPost1.setEntity(postParams);

        System.out.println(httpPost1.getURI());
        PostMethod method = new PostMethod(builder.build().toString());

        httpPost1.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpPost1.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost1.setHeader("Accept-Language","en-US,en;q=0.9");
        httpPost1.setHeader("Cache-Control", "max-age=0");
        httpPost1.setHeader("Connection", "keep-alive");
//        httpPost1.addHeader("Content-Length", "180");
        httpPost1.setHeader("Content-Type","application/x-www-form-urlencoded");
//        httpPost1.addHeader("Content-Type","text/html");
        httpPost1.setHeader("Host", "www.njportal.com");
        httpPost1.setHeader("Origin","https://www.njportal.com");
        httpPost1.setHeader("Referer","https://www.njportal.com/DOR/BusinessNameSearch/Search/BusinessName");

        httpPost1.setHeader("sec-ch-ua-mobile","?0");
        httpPost1.setHeader("sec-ch-ua-platform","Windows");
        httpPost1.setHeader("Sec-Fetch-Dest","document");
        httpPost1.setHeader("Sec-Fetch-Mode","navigate");
        httpPost1.setHeader("Sec-Fetch-Site","same-origin");
        httpPost1.setHeader("Sec-Fetch-User","?1");
        httpPost1.setHeader("Upgrade-Insecure-Requests", "1");
        httpPost1.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");

        CloseableHttpResponse httpResponse3 = httpClient.execute(httpPost1);

        org.apache.http.Header[] header = httpResponse2.getAllHeaders();
        for (org.apache.http.Header head : header){
            System.out.println(head.getName() + " - " + head.getValue());
        }


//        HttpEntity postParams = new UrlEncodedFormEntity(nameValuePairs);
//        System.out.println(postParams.toString());
//        httpPost.setEntity(postParams);

        System.out.println("POST Response Status:: " + httpResponse3.getStatusLine().getStatusCode());

        String result = EntityUtils.toString(httpResponse3.getEntity());
        System.out.println(result);

//        StringBuilder stringBuilder2 = new StringBuilder();
//
//        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpResponse3.getEntity().getContent()));
//
//        String line2;
//
//        while ((line2 = bufferedReader2.readLine()) != null) {
//            stringBuilder.append(line2 + "\n");
//        }
//
//        System.out.println(stringBuilder2.toString());
//        bufferedReader2.close();
//
//        HttpClient client = new HttpClient();
//        HttpMethod method2 = new PostMethod(POST_URL);
//
//        try {
//            // Set query string information for accessing the page using a
//            // simple string information.
//            method.setQueryString(URIUtil.encodeQuery("__RequestVerificationToken="+div+"&"+"BusinessName"+"%a"));
//            client.executeMethod(method2);
//
//            // Other cleaner alternative is to use the NameValuePair object to
//            // define the parameters for an HTTP GET method.
//            org.apache.commons.httpclient.NameValuePair param1 = new org.apache.commons.httpclient.NameValuePair("__RequestVerificationToken", URIUtil.encodeQuery(div));
//            org.apache.commons.httpclient.NameValuePair param2 = new org.apache.commons.httpclient.NameValuePair("BusinessName", URIUtil.encodeQuery("%a"));
//            org.apache.commons.httpclient.NameValuePair[] paramsp = new org.apache.commons.httpclient.NameValuePair[]{param1, param2};
//            method.setQueryString(paramsp);
//            client.executeMethod(method2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }


//        HttpResponse response = Request.Post("http://www.example.com").bodyForm(
//                        Form.form().add("username", "John").add("password", "pass").build())
//                .execute().returnResponse();
    }
}