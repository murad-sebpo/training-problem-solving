package io.murad.GET_POST_method_creation_with_Java;

import java.io.IOException;
import java.net.CookieStore;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class InvokeDataByPostMethod {

    public static final String  WEBSITE_URL = "https://www.njportal.com/DOR/BusinessNameSearch/Search/BusinessName";
    public static HttpClient httpClient =  HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();;

    InvokeDataByPostMethod(){

    }

    public static void main(String[] args) throws IOException, InterruptedException {


        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(WEBSITE_URL))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        HttpHeaders headers = response.headers();

        headers.map().forEach((k,v)->{
            System.out.println(k+v);
            System.out.println();


        });

//        System.out.println(response.body());

        System.out.println(headers.allValues("set-cookie").get(0));

        HttpClient httpClient = HttpClient.newHttpClient();
// execute get/post/put or whatever
//        httpClient;
// get cookieStore
//        CookieStore cookieStore = httpClient.getCookieStore();
// get Cookies
//        List<Cookie> cookies = cookieStore.getCookies();

    }
}
