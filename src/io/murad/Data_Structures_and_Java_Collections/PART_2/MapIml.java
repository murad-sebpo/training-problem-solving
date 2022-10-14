package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.HashMap;
import java.util.Map;

public class MapIml {

    public static void main(String[] args) {

        Map<String,Integer> examScores = new HashMap<>();

        examScores.put("Data Structure", 90);
        examScores.put("Algorithms",95);
        examScores.put("Java Programming",98);
        examScores.put("C Programming", 85);

        for ( Map.Entry<String , Integer> score : examScores.entrySet()){
            System.out.println(score.getKey() + " - " + score.getValue());
        }
    }
}
