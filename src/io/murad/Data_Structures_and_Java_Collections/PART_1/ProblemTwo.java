package io.murad.Data_Structures_and_Java_Collections.PART_1;

/**
 * Find the largest and smallest number in an unsorted integer array.
 */
public class ProblemTwo {

    public static void main(String[] args) {

        int[] arr = {45, 87, 23, 89, 13, 35, 96};

        // Find Largest
        int largestValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestValue) {
                largestValue = arr[i];
            }
        }
        System.out.println("Largest Number: " + largestValue);

        //Find Smallest
        int smallestValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallestValue) {
                smallestValue = arr[i];
            }
        }
        System.out.println("Smallest Number: " + smallestValue);
    }
}
