package io.murad.Regex_problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemOne {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("hi hello hi hello");

        int count = 0;
        String words = "";
        while(matcher.find()){
//            System.out.println(matcher.group());
            words = words + " " + matcher.group();
//            System.out.println(matcher.group() +" = "+ matcher.groupCount());
//            if (words.equals(matcher.group())){
//                System.out.println(words.length() + " = "+count++);
//            }
//            count++;
        }

//        System.out.println(count);
//        System.out.println(words);
//
        String[] wordss = words.split(" ");

        for(int i=0; i<wordss.length;i++){
            count = 1;
            for(int j=i+1; j<wordss.length;j++){
                if(wordss[i].equals(wordss[j])){
                    System.out.println(wordss[i] + " = " + count++);
                }
            }
        }

        for(String w : wordss){
            System.out.println(w);
        }
    }
}
