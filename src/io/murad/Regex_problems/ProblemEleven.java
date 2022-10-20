package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemEleven {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher("Mam Did You tesT alL Students");
        String words = "";
        while (matcher.find()) {
            words = words + matcher.group() + " ";
            System.out.println(matcher.group());
        }

        String[] wordss = words.split(" ");
        System.out.println(wordss[0]);
        char[] wordToCharArr = wordss[0].toCharArray();

        for (int i = 0; i < wordss[0].length(); i++) {
            for (int j = i + 1; j < wordss[0].length(); j++) {
                System.out.println(wordToCharArr[i]);
                if (wordToCharArr[i] == wordToCharArr[j]) {
                    System.out.print(wordToCharArr[j] + " ");
                }
            }
        }
    }
}