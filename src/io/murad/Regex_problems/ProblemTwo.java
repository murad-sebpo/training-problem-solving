package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {

    static void validateEmail(String regex, String emailToMatch) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailToMatch);

        if (matcher.matches()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }

    public static void main(String[] args) {
        validateEmail("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}$", "x@x.com");
        validateEmail("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}$", "x@x");
        validateEmail("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}$", "x.x@x");
        validateEmail("^(?!.*\\.\\.)[\\w\\.!#\\$%&'*+-/=?^_`{|}~]{1,35}+@[\\w.]+\\.[a-zA-Z]{1,15}$", "murad.hossain@gmail.com");

    }
}
