package io.murad.Data_Structures_and_Java_Collections.PART_1;

import java.util.Arrays;

public class ProblemSix {
    public static int findMissingNumber(int arr[]) {
        int sizeOfArray = arr.length + 1;
        int totalWithMissing = sizeOfArray * (sizeOfArray + 1) / 2;
//        System.out.println(totalWithMissing);
        int sumTillMissing = 0;
        for (int num : arr) {
            sumTillMissing = sumTillMissing + num;
        }
//        System.out.println(sumTillMissing);
        return totalWithMissing - sumTillMissing;
    }


    public static void main(String[] args) {
//        Missing Number = (N(N+1))/2) - (A[1]+A[2]+...+A[100])

        int[] numbers = {1, 2, 3, 4, 5, 6, 8, 9, 10};

        System.out.println(findMissingNumber(numbers));


    }
}
