package io.murad.String_Manipulation_and_Date_Problems.PART_A;

import java.util.Arrays;

/**
 *
 * Given a String String cricketPlayers = "Shakib Al Hasan, Tamim Iqbal, Mashrafe Mortaza, Mushfiqur Rahim, Liton Das, Rubel Hossain"
 * i) Split 'cricketPlayers' and store in array called 'cricketPlayersArr'
 * ii) Some names in cricketPlayers, have more than one space in between their first and last name.
 * Code such that, the names are separated by ONE SPACE only and print them
 * Output - Cricketer 1 - Shakib Al Hasan Cricketer 2 - Tamim Iqbal ...
 */
public class ProblemOne {

    public static void main(String[] args){
        String cricketPlayers = "Shakib Al  Hasan, Tamim  Iqbal, Mashrafe Mortaza, Mushfiqur Rahim, Liton Das, Rubel Hossain";

        String[] cricketPlayersArr  = cricketPlayers.split(",");

        for(String players : cricketPlayersArr){
            String playersNameWithoutExtraSpaces = players.replaceAll("\\s+"," ");
            System.out.println(playersNameWithoutExtraSpaces);
        }

    }
}
