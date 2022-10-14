package io.murad.Data_Structures_and_Java_Collections.PART_1;

import java.util.Collections;
import java.util.LinkedList;

public class ProblemEight {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] numbers = {34, 54, 78, 21, 34, 45, 89};

        for (int num : numbers) {
            linkedList.add(num);
        }

        Collections.reverse(linkedList);

        // Reverse Linked List
        System.out.println("Linked List In Reverse Order: " + linkedList);
    }
}
