package CA1_Algotithms.twopointer;

import java.util.Arrays;

/**
 * Checks if two integer arrays contain the same elements in any order,
 * using the two-pointer approach: sort both arrays, then compare index by index.
 *
 * @param num1 the first array
 * @param num2 the second array
 * @return true if both arrays contain the same elements, false otherwise
 */

public class problem1TP {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};
        int[] num2 = {3, 2, 1};
        //int[] num2 = {2, 3, 5}; testing
        boolean results = areArraysEqualTwoPointer(num1, num2);
        System.out.println("This is the results " + results);
    }

    public static boolean areArraysEqualTwoPointer(int[] num1, int[] num2) {
        if(num1.length != num2.length){
            return false;
        }
        Arrays.sort(num1);
        Arrays.sort(num2);
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }
}