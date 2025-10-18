package _10_reverse_array_and_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode-151: Reverse Words in a String
 * Given a string s, reverse the order of words in the string.
 * - A word is a sequence of non-space characters.
 * - Words are separated by one or more spaces.
 * - The output should not contain leading or trailing spaces,
 *   and words should be separated by a single space. 
 * 
 * Input : s = ["  the sky   is blue  "]
 * Output: "blue is sky the"
 * 
 * Input : s = "hello word"
 * Output: "world hello"
 * 
 * Input : s = "a good   example"
 * Output: "example good a"
**/ 

public class _05_reverse_words {

    /**
     * Approach-1: Brute Force [Using Extra Space - Split & Reverse]
     * 1. First, trim the string to remove leading and trailing spaces.
     * 2. Then, extract words manually by iterating through the string
     *    anf forming words then encountering non-space characters.
     * 3. Finally, reverse the words order and join them back using
     *    a single space. 
     * 
     * Steps:
     * 1. Trim leading and trailing spaces.
     * 2. Iterate over the string, extract the words one by one
     *    (ignoring multiple spaces).
     * 3. Store the words in a List<String>
     * 4. Reverse the order of words and join them using " "
     * 
     * TC: O(N) => Single Pass for extraction + Reversing
     * SC: O(N) => Storing words in a list
    */


    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int n = s.length();
        int i = 0;
        /**
         * 1. Trim leading spaces
         * 2. Extract words manually
         *    - Skip spaces between words
         * 3. Reverse word order
         * 4. Join words with single space
        */
        while (i < n && s.charAt(i) == ' ') i++;
        while (i < n) {
            StringBuilder word = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }
            words.add(word.toString());
            while (i < n && s.charAt(i) == ' ') i++;
        }
        Collections.reverse(words);
        return String.join(" ", words);
    }


    /**
     * Approach-2: In-place using Two Pointer String Reversal
     * Convert the string to a character array for in-place  modifications. 
     * 1. Remove extra spaces.
     * 2. Reverse the entire string. 
     * 3. Reverse each word in-place.
     * 
     * Steps:
     * 1. Remove extra spaces using two pointer approach. 
     * 2. Reverse the entire string to bring words in the correct
     *    order. 
     * 3. Reverse each word individually to fix their order.
     * 
     * TC: O(n) => One pass for trimming,
     *          => One for reversing,
     *          => One for fixing words
     * SC: O(1)
    */

    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseWordsII(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        /**
         * 1. Remove extra spaces and return the valid length
         * 2. Reverse the entire valid string
         * 3. Reverse each word
        */ 
        int newLength = removeExtraSpaces(arr, n);
        reverse(arr, 0, newLength - 1);

        int start = 0;
        for (int i = 0; i < newLength; i++) {
            if (arr[i] == ' ' || i == newLength - 1) {
                reverse(arr, start, (i == newLength - 1) ? i : i - 1);
                start = i + 1;
            }
        }

        return new String(arr, 0, newLength);
    }

    public static int removeExtraSpaces(char[] arr, int n) {
        int i = 0, j = 0;

        /**
         * 1. Skip leading spaces
         * 2. Copy word
         * 3. Skip spaces between words
         * 4. Add a single space
         * 5. New length of the valid string
        */
        while (j < n) {
            while (j < n && arr[j] == ' ') j++;
            while (j < n && arr[j] != ' ') arr[i++] = arr[j++];
            while (j < n && arr[j] == ' ') j++; 
            if (j < n) arr[i++] = ' '; 
        }
        return i; 
    }
}
