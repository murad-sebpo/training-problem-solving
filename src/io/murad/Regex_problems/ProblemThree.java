package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemThree {

    static void validateIPAddress(String regex, String ipAddress) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }


    }

    public static void main(String[] args) {
        validateIPAddress("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$","10.10.10.10");
        validateIPAddress("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$","310.10.10.10");
        validateIPAddress("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$","255.10.10.10");
        validateIPAddress("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$","2555.10.10.10");
    }


}
