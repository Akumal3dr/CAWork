package CA1_Algotithms.bruteforceproblems;


/**
 * Reverses only the vowels in a string, keeping all other characters
 * in their original positions. Case-insensitive.
 *
 * @param str the input string
 * @return a new string with the vowels reversed
 */
public class problem4BF {
    public static void main(String[] args) {
        String word = "leetcode";
        String results = reverseVowelBrute(word);
        System.out.println("This is the result " + results);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String reverseVowelBrute(String str) {
        int vowelCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (isVowel(Character.toLowerCase(str.charAt(i)))) {
                vowelCount++;
            }
        }

        char[] vowelArray = new char[vowelCount];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(Character.toLowerCase(str.charAt(i)))) {
                vowelArray[index] = str.charAt(i);
                index++;
            }
        }

        String result = "";
        int reve = vowelCount - 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isVowel(Character.toLowerCase(c))) {
                result += vowelArray[reve];
                reve--;
            } else {
                result += c;
            }
        }
        return result;
    }
}
