package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTen {

    public static void main(String[] args) {
//        charAt(str. length - 1)
        Pattern pattern = Pattern.compile("^(.).*\\1$");
        Matcher matcher = pattern.matcher("all ala imi");
        String words = "";

        while (matcher.find()) {
            System.out.println(matcher.group());
//            words = words + matcher.group() + " ";
        }

//        String[] wordTOArr = words.split(" ");

//        for (int i = 0; i < wordTOArr.length; i++) {
//            System.out.println(wordTOArr[i]);
//            char ch = wordTOArr[i].charAt(0);
//            char chlast = (char) (wordTOArr[i].length() - 1);
//            if (ch == chlast) {
//                System.out.println(true);
//            }
//        }

    }

}