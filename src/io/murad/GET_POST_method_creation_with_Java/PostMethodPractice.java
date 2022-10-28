package io.murad.GET_POST_method_creation_with_Java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostMethodPractice {

    private static HttpURLConnection connection;
    private static String WEBSITE_URL = "https://httpbin.org/post";

    public static void main(String[] args) throws IOException {


        var urlParameters = "name=Jack&occupation=programmer";

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            var url = new URL(PostMethodPractice.WEBSITE_URL);

            connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Java client");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (var wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(postData);
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
