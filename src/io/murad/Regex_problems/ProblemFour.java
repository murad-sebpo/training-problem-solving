package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemFour {

    static void validTimeFormat(String regex, String time) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);

        if (matcher.matches()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }

    public static void main(String[] args) {
        validTimeFormat("^(0?[1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]$","12:59:59");
        validTimeFormat("^(0?[1-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]$","12:60:59");
    }
}
