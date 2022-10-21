package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemSeven {
    static void validateDayMonthFormat(String regex, String dayMonth) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dayMonth);

        if (matcher.matches()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }
    public static void main(String[] args) {
        validateDayMonthFormat("^(0?[1-9]|1[0-9]|2[0-9]|3[01])/(0?[1-9]|1[0-2])$","1/29");
        validateDayMonthFormat("^(0?[1-9]|1[0-9]|2[0-9]|3[01])/(0?[1-9]|1[0-2])$","2/29");
    }
}
