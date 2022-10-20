package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ProblemNine {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher("abcd12XY15c1552d13");
        String stringToFindOdd = "";
        while (matcher.find()) {
            stringToFindOdd = stringToFindOdd + matcher.group() + ",";
        }

        String[] convertStringToArr = stringToFindOdd.split(",");

        for (int i = 0; i < convertStringToArr.length; i++) {
            int number = parseInt(convertStringToArr[i]);
            if (!(number % 2 == 0)) {
                System.out.print(number + ",");
            }

        }
    }
}
