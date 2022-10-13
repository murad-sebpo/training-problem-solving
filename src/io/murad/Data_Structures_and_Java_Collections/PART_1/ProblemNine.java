package io.murad.Data_Structures_and_Java_Collections.PART_1;

/**
 * How do you count the occurrence of a given character in a string?
 */
public class ProblemNine {

    static int characterOccurrenceCount(String text, char ch) {
        char[] convertedToChar = text.toCharArray();
        int charCount = 0;
        for (int i = 0; i < convertedToChar.length; i++) {
            if (convertedToChar[i] == ch) {
                charCount++;
            }
        }

        return charCount;
    }

    public static void main(String[] args) {

        String text = "How do you count the occurrence of a given character in a string?";
        System.out.println("This character occurrence is: " + characterOccurrenceCount(text, 'g'));


    }
}
