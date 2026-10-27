package CA1_Algotithms.bruteforceproblems;

public class problem1BF {
    public static void main(String[] args){
        int[] num1 = {3,2,1};
        int[] num2 = {1,2,3};

        boolean results = areArraysEqualBrute(num1, num2);
        System.out.println("The result is " + results);
    }

    /**
     * Check if two ints arrys contain the same elements, in any order
     * uses brute force, a nested look and a tracker(used)
     * @param num1 my first array
     * @param num2 my second array
     * @return true if both arrays contain the smae elements, false if not
     */

    public static boolean areArraysEqualBrute(int[] num1, int[] num2){
        if(num1.length != num2.length){
            return false;
        }

        boolean[] used = new boolean[num2.length];
        for(int i = 0; i < num1.length; i++){
            boolean found = false;
            for(int j = 0; j < num2.length; j++) {
                if (!used[j] && num1[i] == num2[j]) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }

        }
            return true;

    }

}
