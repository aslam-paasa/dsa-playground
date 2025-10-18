package _08_basic_string;

import java.util.Scanner;

/**
 * Template-3: Common Prefix Matching
*/

/**
 * Leetcode-14: Longest Common Prefix
 * Given an array of strings strs, find the longest common prefix
 * (LCP) shared by all the strings. If there is no common prefix,
 * return an empty string. 
 * 
 * - Input : strs = ["flower", "flow", "flight"]
 * - Output: "fl" (Common prefix for all strings is "fl").
 * 
 * - Input : strs = ["dog", "racecar", "car"]
 * - Output: "" (No common prefix).
 * 
 * Key Insight:
 * - The common prefix means the starting part of all strings are
 *   the same.
*/

public class _04_longest_common_prefix {
    /**
     * Approach-1: Brute Force
     * Compare each character of every string one by one until there
     * is a mismatch.
     * 
     * Steps:
     * 1. Edge Case: If the array is empty, return an empty string. 
     * 2. Take First String: Assume the first string is the answer.
     * 3. Character Comparison:
     *    - Loop through each character of the first string. 
     *    - For every other string, if they have the same character
     *      at that position. 
     *    - If any string mismatches, return the prefix up to that
     *      point. 
     * 4. Return Full Prefix: If no mismatch occurs, return the entire
     *    first string.
     * 
     * TC: O(n x m)
     *     - n = Num of strings
     *     - m = Length of the smallest string
     * SC: O(1)
    */

    public static String longestCommonPrefix(String[] strs) {
        /**
         * 1. Edge case - Empty array
         */
        if (strs == null || strs.length == 0) return "";
        
        /**
         * 2. Compare each character of the first string with others:
        */
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            
            /**
             * a. Check the same character position in all other strings:
             *    - If index exceeds length OR mismatch found
             */
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        /**
         * 3. If no mismatch, return the entire first string
        */
        return strs[0];
    }


    /**
     * Approach-2: Horizontal Scanning:
     * Iterate through pairs of strings to find the common prefix. 
     * 
     * Steps:
     * 1. Edge Case: If array length is 0, return an empty string. 
     * 2. Take First String: Assume the first string is the initial
     *    prefix. 
     * 3. Compare Each String:
     *    - For each string in the array, find the common prefix b/w
     *      the current prefix and the next string. 
     * 4. Return Prefix: If the prefix becomes empty, return "". 
     * 
     * TC: O(n x m)
     * SC: O(1)
    */

    public static String longestCommonPrefixII(String[] strs) {
        /**
         * 1. Edge case
        */
        if (strs == null || strs.length == 0) return "";
        
        /**
         * 2. Start with the first string as the prefix
        */
        String prefix = strs[0];
        
        /**
         * 3. Compare with each string
         *    - Reduce the prefix by one character from the end
         *    - If prefix becomes empty, return ""
        */
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }


    /**
     * Approach-3: Vertical Scanning
     * Compare one character at a time across all strings. 
     * 
     * Steps:
     * 1. Edge Case: If the array is empty, return an empty string.
     * 2. Compare character by character:
     *    - For each character in the first string, compare it with
     *      the same position in the other strings. 
     *    - If mismatch found, return the prefix up to that point. 
     * 3. Return result: If no mismatch, return the entire first string. 
     * 
     * TC: O(n x m)
     *     - n = Number of Strings
     *     - m = Length of the smallest string
     * SC: O(1)
     * 
     * Note: Vertical Scanning is Optimal because it checks until a
     *       mismatch is found. And stops as soon as the prefix can't
     *       be extended. 
    */

    public static String longestCommonPrefixIII(String[] strs) {
        /**
         * 1. Edge case
        */
        if (strs == null || strs.length == 0) return "";
        
        /**
         * 2. Iterate through each character of the first string
         */
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            
            /**
             * 3. Compare with the same index in all other strings:
             *    - If the index exceeds length or a mismatch occurs
            */
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        /**
         * 4. If no mismatch found, return the full first string
         */
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        int n = scn.nextInt();
        scn.nextLine(); // Consume newline
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the string " + (i + 1) + ": ");
            strs[i] = scn.nextLine();
        }

        System.out.println("Longest common prefix using Approach-1: " + longestCommonPrefix(strs));
        System.out.println("Longest common prefix using Approach-2: " + longestCommonPrefixII(strs));
        System.out.println("Longest common prefix using Approach-3: " + longestCommonPrefixIII(strs));
        scn.close();
    }
}
