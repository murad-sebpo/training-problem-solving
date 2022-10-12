package io.murad.String_Manipulation_and_Date_Problems.PART_A;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * i) Capture the local machine date (Month-Day-Year (with leading zeros) format i.e 07/27/2020) using the Java Date API -You can refer to the documentation - https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
 * ii) Compare the date you captured above, with 3 other dates below. Print their status, whether the given dates are in the PAST or FUTURE.
 * Convert String -> Date, if necessary.
 * String date1 = "03/22/1993" String date2 = "07/19/2022" String date3 = "01/01/2010"
 */
public class ProblemSix {

    public static final Date currentDateFromLocalMachine = new Date();
    public static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public static void checkDatePastOrFuture(Date date) {
        if (currentDateFromLocalMachine.after(date)) {
            System.out.println("This date is in the PAST");
        } else if (currentDateFromLocalMachine.before(date)) {
            System.out.println("This date is in the Future");
        }
    }

    public static Date convertStringToDate(String date) throws ParseException {
        Date convertedDate = dateFormat.parse(date);
        return convertedDate;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Current Date From Local Machine: " + dateFormat.format(currentDateFromLocalMachine));

        String date1 = "03/22/1993";
        String date2 = "07/19/2022";
        String date3 = "01/01/2010";


        checkDatePastOrFuture(convertStringToDate(date1));
        checkDatePastOrFuture(convertStringToDate(date2));
        checkDatePastOrFuture(convertStringToDate(date3));

    }
}
