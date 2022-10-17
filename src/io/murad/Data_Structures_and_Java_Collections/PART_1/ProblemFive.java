package io.murad.Data_Structures_and_Java_Collections.PART_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Search for a (value) in a hash-map, and if presents return its key. Else return null.
 */
public class ProblemFive {

//    static Integer searchValueInHashMap(Map<Integer, String> companyNames, String searchValue) {
//        Integer searchValueIndex = 0;
//        for (Map.Entry<Integer, String> company : companyNames.entrySet()) {
//            if (company.getValue().contains("SEBPO")) {
//                searchValueIndex = company.getKey();
//            } else {
//                return null;
//            }
//
//        }
//
//        return searchValueIndex;
//    }

    public static void main(String[] args) {

        Map<Integer, String> companyNames = new HashMap<>();
        companyNames.put(1, "SEBPO");
        companyNames.put(2, "City Group");
        companyNames.put(3, "Square Ltd");
        companyNames.put(4, "Beximco");

        for (Map.Entry<Integer, String> company : companyNames.entrySet()) {
            if (company.getValue().contains("SEBPO")) {
                System.out.println("Key: " + company.getKey());
                System.out.println(companyNames.get(company.getKey()));
            } else {
                System.out.println("null");
            }

        }

//        System.out.println(searchValueInHashMap(companyNames,"SEBPO"));
//        companyNames.entrySet().stream().filter(company ->
//                company.getValue().contains("SEBPO")
//        );

    }
}
