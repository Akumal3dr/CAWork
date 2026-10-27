package CA1_Algotithms.twopointer;

/**
 * Reverses only the vowels in a string using the two-pointer approach.
 * Non-vowel characters stay in their original positions. Case-insensitive.
 *
 * @param str the input string
 * @return a new string with the vowels reversed
 */
public class problem4TP {
    public static void main(String[] args){
        String words = "weapon";

        String results = reverseVowelsTwoPointer(words);
        System.out.println("This is the result " + results);
    }
    /**
     * Checks whether a character is a lowercase vowel (a, e, i, o, u).
     *
     * @param c the character to check
     * @return true if c is a vowel, false otherwise
     */

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String reverseVowelsTwoPointer(String str){
        int left = 0;
        int right = str.length() -1;
        char[] chars = str.toCharArray();
        while(left < right){
            while(left < right && !isVowel(Character.toLowerCase(chars[left]))){
                left++;
            }
            while(left < right && !isVowel(Character.toLowerCase(chars[right]))){
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;

        }
        return new String(chars);
    }
}
