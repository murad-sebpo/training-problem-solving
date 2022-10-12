package io.murad.String_Manipulation_and_Date_Problems.PART_B;


import java.util.Arrays;

/**
 * Take four strings : String name1 = “Taufiq” String name2 = “Tawheed” String name3 = “Tanveer” String name4 = “Taufiq”
 * If two Strings are equal, then print them. Output: Name1 and Name4 matches.
 * And the name is = Taufiq (You can Use your own dummy-data/example.)
 */
public class ProblemOne {

    public static void main(String[] args) {
        String name1 = "Taufiq",
                name2 = "Tawheed",
                name3 = "Tanveer",
                name4 = "Taufiq";

        String[] names = {name1, name2, name3, name4};
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("Name" + (i+1) + " and " +  "Name"+ (j+1) + " matches");
                }
            }
        }
    }
}
