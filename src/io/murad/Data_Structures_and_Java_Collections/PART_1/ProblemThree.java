package io.murad.Data_Structures_and_Java_Collections.PART_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProblemThree {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        int[] numbers = {34, 54, 78, 21, 34, 45, 89};

        for (int num : numbers) {
            linkedList.add(num);
        }
        System.out.println("Length of LinkedList: " + linkedList.size());
    }
}
