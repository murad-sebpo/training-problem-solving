package io.murad.Data_Structures_and_Java_Collections.PART_3;

import java.util.Arrays;
import java.util.List;

/**
 *
 * ii) Convert the array to a List, and then print the List using enhanced for loop.
 * Do it in a function called 'convertingToListAndPrint(int[] arr)
 */
public class ProblemTwo {
    static void convertingToListAndPrint(int arr[]) {
        List<Integer> convertedArrayList = Arrays.stream(arr).boxed().toList();
        convertedArrayList.forEach(convertedArr -> {
            System.out.println(convertedArr);
        });
    }

    public static void main(String[] args) {
        int[] arr = {52, 78, 36, 45, 98, 66, 75};

        //Convert and Print the arr to ArrayList
        convertingToListAndPrint(arr);
    }
}
