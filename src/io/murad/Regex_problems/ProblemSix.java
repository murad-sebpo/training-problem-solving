package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSix {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<([a-z]+)\\s?[a-z]*\\/?>(\\n?.*\\n?<\\/\\1>)?");
        Matcher matcher = pattern.matcher("<div>..</div><div>..</div><p>..</p>");

        String str = "";
        while(matcher.find()){
            System.out.println(matcher.group());
            str = str + matcher.group();
        }

    }
}
