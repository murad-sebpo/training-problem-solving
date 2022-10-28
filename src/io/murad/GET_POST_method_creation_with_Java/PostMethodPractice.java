package io.murad.GET_POST_method_creation_with_Java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostMethodPractice {

    private static HttpURLConnection connection;
//    private static String WEBSITE_URL = "https://httpbin.org/post";

    private static String WEBSITE_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException {

        Map<String,String> posts = new HashMap<>();
        posts.put("userId","101");
        posts.put("id","1");
        posts.put("title","Fancy Image Decorations: Outlines and Complex Animations");
        posts.put("body","We’ve spent the last two articles in this three-part series playing with gradients to make really neat image decorations using nothing but the <img> element. In this third and final piece, we are going to explore more techniques using the CSS outline property. That might sound odd because we generally use outline to draw a simple line around an element — sorta like border but it can only draw all four sides at once and is not part of the Box Model.");


        var urlParameters = "name=Jack&occupation=programmer";

//        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        var articles = posts.toString().getBytes(StandardCharsets.UTF_8);

        try {

            var url = new URL(PostMethodPractice.WEBSITE_URL);

            connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Java client");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (var wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(articles);
            }

            StringBuilder content;

            try (var br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println(content.toString());

        } finally {

            connection.disconnect();
        }
    }
}
