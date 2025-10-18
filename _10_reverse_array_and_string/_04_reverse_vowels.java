package _10_reverse_array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-345: Reverse Vowels of a String
 * Given a string s, reverse only the vowels in the string and
 * return the modified string.
 * - Vowels: a, e, i, o, u (both uppercase & lowercase)
 * - All other characters should remain in their original position.
 * 
 * Input : s = "hello"
 * Output: "holle"
 * 
 * Input : s = "leetcode"
 * Output: "leotcede"
*/

public class _04_reverse_vowels {

    /**
     * Approach-1: Brute Force (Using Extra Space)
     * 1. Extract all vowels into a list while traversing the string.
     * 2. Reverse the list of vowels. 
     * 3. Replace vowels in the original string with the reversed voewls.
     * 
     * Steps:
     * 1. Traverse the string and store all vowels in a list.
     * 2. Reverse the vowel list.
     * 3. Replace vowels in the original string with reversed vowels.
     * 
     * TC: O(N) : Two passes - One for collecting vowels, one for replacing
     * SC: O(N) : Extra space for storing vowels
    */

    public static String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] arr = s.toCharArray();

        /**
         * 1. Extract Vowels
        */
        for (char c : arr) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        /**
         * 2. Replace vowels with reversed ones
        */
        int vowelIndex = vowels.size() - 1;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vowels.get(vowelIndex--);
            }
        }

        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }


    /**
     * Approach-2: Two Pointer (In-Place)
     * 1. Use two pointers
     *    - One at the start
     *    - One at the end
     * 2. Swap vowels when both pointers find a vowel
     * 3. Move pointers inward after swapping
     * 
     * Steps:
     * 1. Convert string to char array for in-place modification. 
     * 2. Use two pointers:
     *    - left at the start
     *    - right at the end
     * 3. Move both pointers inward and swap vowels when found
     * 4. Convert char array back to a string. 
     * 
     * TC: O(N) => Single Pass with two pointers
     * SC: O(1) => In-place swapping, no extra space
    */

    public static String reverseVowelsII(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            /**
             * 1. Move left pointer until it finds a vowel
             * 2. Move right pointer until it finds a vowel
             * 3. Swap vowels
             */
            while (left < right && !isVowelII(arr[left])) 
                left++;

            while (left < right && !isVowelII(arr[right])) 
                right--;

            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    private static boolean isVowelII(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
