package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwelve {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("(a|b)*b(a|b)*b(a|b)*b(a|b)*");
        Matcher matcher = pattern.matcher("abba abbab baba abbbd");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
