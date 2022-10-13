package io.murad.Data_Structures_and_Java_Collections.PART_1;

/**
 * Find all pairs of an integer array whose sum is equal to a given number.
 */
public class ProblemOne {

    static void getAllPairsOfArray(int[] numbers, int sumNumber) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == sumNumber) {
                    System.out.printf("Pairs: %d , %d", numbers[i], numbers[j]);
                    return;
                }
            }
        }
        System.out.println("No pairs found.");
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 6, 8, 2, 9};
        getAllPairsOfArray(numbers, 6);

    }
}
