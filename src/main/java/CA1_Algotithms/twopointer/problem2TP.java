package CA1_Algotithms.twopointer;
/**
 * Checks if a string is a palindrome, ignoring case, spaces, and punctuation.
 * Uses the two-pointer approach with skip loops for non-letters.
 *
 * @param str the string to check
 * @return true if the string is a palindrome, false otherwise
 */
public class problem2TP {
    public static void main(String[] args){
        String words = "I love it when a plan comes together";

        boolean results = isPalindromeTwoPointer(words);
        System.out.println("This is the result " + results);
    }

    public static boolean isPalindromeTwoPointer(String str){
        int left = 0;
        int right = str.length() -1;
        while (left < right){
            while(left < right && !Character.isLetter(str.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetter(str.charAt(right))){
                right--;
            }
            char l = Character.toLowerCase(str.charAt(left));
            char r = Character.toLowerCase(str.charAt(right));
            if(l < r ){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
