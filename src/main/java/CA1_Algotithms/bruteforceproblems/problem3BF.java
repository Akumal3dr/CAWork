package CA1_Algotithms.bruteforceproblems;
/**
 * Finds the shortest contiguous subarray whose sum is at least the target.
 * Uses brute force (checks every possible subarray).
 *
 * @param "num" the array of positive integers
 * @param "tar" the target sum
 * @return an int[] with {start, end} positions, or {0} if no valid subarray exists
 */
public class problem3BF {
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int tar = 7;

        int[] results = shortestSubarrayBrute(nums, tar);
        System.out.println("Start: " + results[0] + ", End: " + results[1]);
    }

    public static int[] shortestSubarrayBrute(int[] nums, int tar){
        int bestStart = -1;
        int bestEnd = -1;
        int bestLength = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= tar){
                    int length = j - i + 1;
                    if(length < bestLength){
                        bestLength = length;
                        bestStart = i;
                        bestEnd = j;
                    }
                }
            }
        }
        if(bestStart == -1){
            return new int[]{0};
        }
        return new int[]{bestStart, bestEnd};
    }


}
