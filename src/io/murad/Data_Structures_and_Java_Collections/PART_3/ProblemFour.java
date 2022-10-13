package io.murad.Data_Structures_and_Java_Collections.PART_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Construct a dictionary (HashTable/HashMap any one of your wish), and print them.
 * Each individual can have none, one or more than one address. Code for the given scenario, making the individual name as the unique key
 * -> Akib has 3 addresses = Mirpur, Dhanmondi, Shiddheshwari -> Sajeeb has 1 address = Lalmatia -> Niloy has 2 addresses = Puran Dhaka, Rajarbag -> Ratul lives abroad has no address
 * <p>
 * i) Construct the Dictionary, using the scenario above.
 * ii) Print them such that the output is like this
 * <p>
 * Individual 1: Akib Address 1: Mirpur Address 2: Dhanmondi Address 3: Shiddheshwari
 * <p>
 * The one with no address should show - "NO ADDRESS", but you cannot put 'NO ADDRESS' in the dictionary.
 */
public class ProblemFour {

    public static void main(String[] args) {
        Map<String, List<String>> dictionary = new HashMap<>();
        Map<String, Map<String,String>> dictionarys = new HashMap<>();


        dictionary.put("1", List.of("Mirpur", "Dhanmondi"));
        dictionary.put("2", null);

//        dictionary.

        for (String key : dictionary.keySet()) {
//                   for(List )
            for(List<String> d : dictionary.values()){
                if(key!=null){
                    System.out.println(" Individual "+ key + d );
                }else{
                    System.out.println("Adress not found");
                }

            }
        }


    }

}
