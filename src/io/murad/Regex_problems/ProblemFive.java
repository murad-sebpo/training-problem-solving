package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemFive {

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
        validTimeFormat("^(0[1-9]|[12][0-9]|3[01])[/.](0[1-9]|1[012])[/.](1[0-8]|19|20)\\d\\d$","12/12/1212");
        validTimeFormat("^(0[1-9]|[12][0-9]|3[01])[/.](0[1-9]|1[012])[/.](1[0-8]|19|20)\\d\\d$","12/13/1212");
        validTimeFormat("^(0[1-9]|[12][0-9]|3[01])[/.](0[1-9]|1[012])[/.](1[0-8]|19|20)\\d\\d$","12/12/12122");
        validTimeFormat("^(0[1-9]|[12][0-9]|3[01])[/.](0[1-9]|1[012])[/.](1[0-8]|19|20)\\d\\d$","32/12/1212");
    }
}
