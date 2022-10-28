package io.murad.GET_POST_method_creation_with_Java;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class GETMethodPractice {

    public String WEBSITE_URL = "https://hackernoon.com/";

    public void getURLInfo() throws IOException {
        URL url = new URL(WEBSITE_URL);
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host Name: " + url.getHost());
        System.out.println("Port Number: " + url.getPort());
        System.out.println("File Name: " + url.getFile());
        System.out.println(url.getAuthority());
        System.out.println(url.getContent());
    }

    private String getWebsiteContent(String webUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(webUrl);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String scrapeData(String regex, String content) {
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        StringBuilder outputContent = new StringBuilder();

        while (matcher.find()) {
            outputContent.append(matcher.group());
        }
        return outputContent.toString();
    }

    public void storeDataToFile(String extractedContent) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Training\\Groovy Practice\\problem-solving-training\\src\\io\\murad\\GET_POST_method_creation_with_Java\\content.txt"));
        bufferedWriter.write(extractedContent);
        System.out.println("Content Stored");

        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException {

        var getMethodPractice = new GETMethodPractice();

        getMethodPractice.getURLInfo();

//        System.out.println(getMethodPractice.getWebsiteContent(getMethodPractice.WEBSITE_URL));

        String content = getMethodPractice.getWebsiteContent(getMethodPractice.WEBSITE_URL);

        String outputData = getMethodPractice.scrapeData("<title>(.*?)</title>", content.toString());
        outputData = outputData + getMethodPractice.scrapeData("<button>(.*?)</button>", content.toString());
//        System.out.println(outputData);

        getMethodPractice.storeDataToFile(outputData);
    }

}
