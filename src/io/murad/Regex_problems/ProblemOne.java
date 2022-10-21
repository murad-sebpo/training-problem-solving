package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemOne {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("he he goes to school");

        int count = 0;
        String words = "";
        while (matcher.find()) {
            words = words + " " + matcher.group();
        }

        String[] wordToStringArr = words.split(" ");

        for (int i = 0; i < wordToStringArr.length; i++) {
            count = 1;
            for (int j = i + 1; j < wordToStringArr.length; j++) {
                if (wordToStringArr[i].equals(wordToStringArr[j])) {
                    count++;
                    System.out.println(wordToStringArr[i] + " = " + count);
                }
            }
        }
    }
}
