package _10_reverse_array_and_string;

/**
 * Leetcode-541: Reverse String II
 * You are given a string s and an integer k. Reverse the first k
 * characters for every 2k characters.
 * - If there are fewer than k characters left, reverse all of them.
 * - If there are k or more but fewer than 2k, reverse only the
 *   first k characters.
 * 
 * Input: s = "abcdefg", k = 2  
 * Output: "bacdfeg"
 * 
 * Input: s = "abcd", k = 2 
 * Output: "bacd"
*/

public class _03_reverse_string_range {
    /**
     * Approach-1: Brute Force (Extra String for Reversal)
     * 1. Break the string into chunks of 2k and reverse the first k
     *    characters in each chunk.
     * 2. Store the reversed result in a new StringBuilder.
     * 
     * Steps:
     * 1. Iterate over the string in steps of 2k
     * 2. Reverse the first k characters and append the remaining.
     * 3. Use a StringBuilder to store and return the result.
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            // Reverse the first k characters
            StringBuilder temp = new StringBuilder(s.substring(i, Math.min(i + k, n)));
            result.append(temp.reverse());

            // Append the remaining characters in the 2k block
            if (i + k < n) {
                result.append(s.substring(i + k, Math.min(i + 2 * k, n)));
            }
        }

        return result.toString();
    }

    /**
     * Approach-2: In-place modification with Character Array
     * 1. Convert the string into a character array for in-place
     *    modifications.
     * 2. Use two pointers to reverse the first k characters in every
     *    2k block. 
     * 
     * Steps:
     * 1. Convert the string into a character array. 
     * 2. Iterate in steps of 2k. 
     * 3. Reverse the first k characters within the array using the
     *    two-pointer method. 
     * 4. Convert the character back to a string. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseStrII(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            reverse(arr, left, right);
        }

        return new String(arr);
    }
}
