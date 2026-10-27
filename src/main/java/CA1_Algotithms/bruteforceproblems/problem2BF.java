package CA1_Algotithms.bruteforceproblems;

/**
 * Checks if a string is a palindrome (reads the same forwards and backwards),
 * ignoring case, spaces, and punctuation. Uses brute force: builds a cleaned
 * string, reverses it, then compares the two.
 *
 * @param str the string to check
 * @return true if the string is a palindrome, false otherwise this will return false
 */
public class problem2BF {
    public static void main(String[] args){
        String words = "I will be kind of the pirates";

        boolean results = isPalindromeBrute(words);
        System.out.println("The results for this is " + results);
    }

    public static boolean isPalindromeBrute(String str){
        String clean = "";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetter(c))
                clean += Character.toLowerCase(c);
        }

        String reverse = "";
        for(int i = clean.length() -1; i >= 0; i--){
            reverse += clean.charAt(i);
        }
        return clean.equals(reverse);
    }

}
