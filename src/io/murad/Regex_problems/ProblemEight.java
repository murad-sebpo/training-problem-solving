package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemEight {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-z&&[^aeiou]]");
        Matcher matcher = pattern.matcher("Only match constant in a set using char set intersection");

        while(matcher.find()){
            System.out.print(matcher.group());
        }
    }
}
