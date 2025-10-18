package _08_basic_string;

import java.util.Scanner;

/**
 * Template-4: Character Mapping(Isomorphic Strings, String Rotation)
*/

/**
 * Leetcode-796: Rotate String
 * Given two strings s and goal, return true if and only if s can
 * become goal after any number of shifts on s. 
 * - A shift means moving the first character of s to the end of
 *   the string.
 * 
 * - Input : s = "abcde", goal = "cdeab"
 * - Output: true
 * - Reason: We can rotate "abcde" by shifting left 2 times:
 *           => "abcde" -> "bcdea" -> "cdeab"
 * 
 * - Input : s = "abcde", goal = "abced"
 * - Output: false
 * - Reason: No rotation of s match goal. 
 * 
 * Key Insight:
 * - If goal is a rotation of s, then goal must be a substring of
 *   s + s.
*/

public class _06_rotate_string {
    /**
     * Approach-1: Brute Force (Simulate Rotations)
     * 1. Simulate all possible rotations of string s. 
     * 2. Check if any rotation matches the goal. 
     * 
     * Steps:
     * 1. Edge Case: If the length of s and goal are not equal, return
     *    false. 
     * 2. Rotate the String: For each possible rotation:
     *    - Move the first character to the end. 
     *    - Check if it equals goal.
     * 3. Return Result: If any rotation matches goal, return true.
     *    Else false. 
     * 
     * TC: O(n^2) => We perform n rotations, and each rotation takes
     *               O(n) time.
     * SC: O(n)   => For storing rotated strings.
    */

    public static boolean rotateStringI(String s, String goal) {
        /**
         * 1. Edge Case - Lengths must be equal
        */
        if (s.length() != goal.length()) return false;

        /**
         * 2. Simulate all possible rotations
         *    - Create a rotated version by moving first char to the end
         *    - Check if rotated string matches the goal
        */
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (rotated.equals(goal)) return true;
        }

        /**
         * 3. If no match is found, return false
        */
        return false;
    }


    /**
     * Approach-2: Concatenate and Check Substring
     * If goal is a rotation of s, then goal must be a substring of s+s.
     * 
     * Steps:
     * 1. Edge Case: If lengths differ, return false. 
     * 2. Concatenate: Create a new string: s + s
     * 3. Check Substring: If goal is a substring of this new string,
     *    return true. 
     * 4. Otherwise, return false. 
     * 
     * TC: O(n) => String comparison and substring check both take 
     *             linear time. 
     * SC: O(n) => For storing the concatenated string. 
    */

    public static boolean rotateString(String s, String goal) {
        /**
         * 1. Edge Case - Lengths must be the same
        */
        if (s.length() != goal.length()) return false;

        /**
         * 2. Concatenate the string with itself
        */
        String combined = s + s;

        /**
         * 3. Check if 'goal' is a substring of the combined string
        */
        return combined.contains(goal);
    }


    /**
     * Approach-3: KMP Algorithm for Substring search
     * Instead of using the contains() method, use the Knuth-Morris-Pratt
     * (KMP) algorithm for faster substring search. 
     * 
     * Steps:
     * 1. Edge Case: Return false if lengths differ. 
     * 2. Concatenate: s + s to capture all rotations. 
     * 3. Use KMP: Check if the goal is a substring of the combined string. 
     * 4. Return true if found, else false.
     * 
     * SC: O(n) => KMP Algorithm for substring search. 
     * TC: O(n) => For KMP Pattern matching table. 
    */

    public static boolean rotateStringIII(String s, String goal) {
        /**
         * 1. Edge Case - Lengths must be equal
        */
        if (s.length() != goal.length()) return false;

        /**
         * 2. Concatenate s with itself
        */
        String combined = s + s;

        /**
         * 3. Check for substring using KMP
        */
        return kmpSearch(combined, goal);
    }

    /**
     * KMP Search Algorithm:
     */
    private static boolean kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        /**
         * a. Create LPS (Longest Prefix Suffix) array
        */
        int[] lps = computeLPS(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) return true;  // Match found
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;  // No match found
    }

    /**
     * Build LPS array: Longest Prefix Suffix
    */
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string s: ");
        String s = scn.nextLine();
        System.out.println("Enter the string goal: ");
        String goal = scn.nextLine();

        System.out.println("Is rotate string using Approach-1: " + rotateStringI(s, goal));
        System.out.println("Is rotate string using Approach-2: " + rotateString(s, goal));
        System.out.println("Is rotate string using Approach-3: " + rotateStringIII(s, goal));
        
        scn.close();
    }
}
