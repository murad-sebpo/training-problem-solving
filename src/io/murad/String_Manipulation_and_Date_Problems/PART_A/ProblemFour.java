package io.murad.String_Manipulation_and_Date_Problems.PART_A;

import java.util.Scanner;

/**
 *
 * For a given String, print the frequency of each individual character. If such characters do not exist, for example - 'z', it won't print.
 * Output (Suppose) A: 19 times B : 3 times C: 2 times etc.
 * CASE-INSENSITIVE, so both lower and upper case will be regarded as one character. Modify the String as your wish.
 *
 */
public class ProblemFour {

    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Enter a String to print the frequency of Characters: ");
        String text = inputString.nextLine();
        int[] frequencyOfCharacter = new int[text.length()];

        char[] convertedStringToCharacter = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            frequencyOfCharacter[i] = 1;
            for (int j = i + 1; j < text.length(); j++) {
                if (convertedStringToCharacter[i] == convertedStringToCharacter[j]) {
                    frequencyOfCharacter[i]++;
                    convertedStringToCharacter[j] = '0';
                }
            }
        }
        for (int i = 0; i < frequencyOfCharacter.length; i++) {
            if (convertedStringToCharacter[i] != ' ' && convertedStringToCharacter[i] != '0') {
                System.out.println(convertedStringToCharacter[i] + ":" + frequencyOfCharacter[i] + " times");
            }

        }

    }
}
