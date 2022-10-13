package io.murad.Data_Structures_and_Java_Collections.PART_3;


/**
 * i) Find the maximum and minimum value of the given array, making sure the line below is in the code
 * System.out.println("The Max value is: " + findMaxValue(arr) + "and Min Value is: " + findMinValue(arr).
 * Basically, you have to complete those 2 unimplemented methods. Cannot use built-in functions
 */
public class ProblemOne {

    public static int findMaxValue(int arr[]) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int findMinValue(int arr[]) {
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] arr = {45, 87, 23, 89, 13, 35, 96};
        System.out.println("The Max value is: " + findMaxValue(arr) + " and Min Value is: " + findMinValue(arr));
    }
}
