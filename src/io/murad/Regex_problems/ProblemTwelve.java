package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwelve {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("  ^((?!ab).)*$", Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher("abad acdd adabdd");
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
