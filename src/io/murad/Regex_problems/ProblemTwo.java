package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {

    static void testRegEx(String regex, String stringToMatch) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringToMatch);

        if (matcher.matches()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }


    }

    public static void main(String[] args) {
        testRegEx("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}\\$", "x@x.com");
        testRegEx("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}\\$", "x@x");
        testRegEx("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}\\$", "x.x@x");
        testRegEx("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}\\$", "murad.hossain@gmail.com");
    }
}
