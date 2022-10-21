package io.murad.Regex_problems;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemFourteen {

    static DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");

    static String validDate(String regex, String time) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);

        String date = "";

        while (matcher.find()) {
            date = date + matcher.group();
        }

        return date;
    }

    public static Date convertStringToDate(String date) throws ParseException {
        Date convertedDate = dateFormat.parse(date);
        return convertedDate;
    }

    public static void main(String[] args) throws ParseException {

//        System.out.println(validDate("^(0?[1-9]|1[012]).(0?[1-9]|1[0-9]|2[0-9]|30|31).(?:(?:19|20)[0-9]{2})$", "10.31.2019"));

        String dateString1 = validDate("^(0?[1-9]|1[012]).(0?[1-9]|1[0-9]|2[0-9]|30|31).(?:(?:19|20)[0-9]{2})$", "10.31.2019");
        String dateString2 = validDate("^(0?[1-9]|1[012]).(0?[1-9]|1[0-9]|2[0-9]|30|31).(?:(?:19|20)[0-9]{2})$", "01.11.2014");

        Date date1 = convertStringToDate(dateString1);
        Date date2 = convertStringToDate(dateString2);

        if (date1.compareTo(date2) > 0) {
            System.out.println(dateString1 + " date is greater");
        } else {
            System.out.println(dateString2 + " date is greater");
        }

    }
}
