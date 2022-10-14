package io.murad.Data_Structures_and_Java_Collections.PART_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    static String dictionary(Map<String, List<String>> dictionary) {
        final StringBuilder builder = new StringBuilder();
        String addresses = "";
        String names = "";
        for (String name : dictionary.keySet()) {
            builder.append(name);
            if (dictionary.get(name) != null) {
                for (String address : dictionary.get(name)) {

//                    System.out.println(name + " Address " + address + " , ");
//                    addresses = address;
                    builder.append(address);
                }
            } else {
//                System.out.println(name + " NO ADDRESS");
                return name + " NO ADDRESS";
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Map<String, List<String>> dictionary = new HashMap<>();

        dictionary.put("Akib", List.of("Mirpur", "Dhanmondi", "Shiddheshwari"));
        dictionary.put("Sajeeb", List.of("Lalmatia"));
        dictionary.put("Niloy", List.of("Puran Dhaka", "Rajarbag"));
        dictionary.put("Ratul", null);

        for (String name : dictionary.keySet()) {

            if (dictionary.get(name) != null) {
                for (String address : dictionary.get(name)) {
                    System.out.println(name + " Address " + address);
                }
            } else {
                System.out.println(name + " NO ADDRESS");
            }
        }
//        System.out.println(dictionary(dictionary));

    }

}
