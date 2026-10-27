package CA1_Algotithms.twopointer;

/**
 * Finds the shortest subarray whose sum is at least the target.
 * Uses a sliding window: the right pointer expands the window,
 * and the left pointer shrinks it when the sum is big enough.
 *
 * @param num the array of positive numbers
 * @param tar the target sum
 * @return the start and end positions of the shortest subarray,
 *         or {0} if no subarray is big enough
 */

public class problem3TP {
    public static void main(String[] args) {
        int[] num = {2, 3, 1, 2, 4, 3};
        int tar = 7;

        int[] results = shortestSubarrayTwoPointer(num, tar);
        System.out.println("Start: " + results[0] + ", End: " + results[1]);
    }

    public static int[] shortestSubarrayTwoPointer(int[] num, int tar){
        int left = 0;
        int sum = 0;
        int bestStart = -1;
        int bestEnd = -1;
        int bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < num.length; right++) {
            sum += num[right];
            while (sum >= tar) {
                int length = right - left + 1;
                if (length < bestLength) {
                    bestLength = length;
                    bestStart = left;
                    bestEnd = right;
                }
                sum -= num[left];
                left++;
            }

        }
        if (bestStart == -1) return new int[]{0};
        return new int[]{bestStart, bestEnd};
    }

}
