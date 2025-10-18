package _08_basic_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Template-5: Frequency Count(Anagram, Sorting by Occurrence)
*/

/**
 * Leetcode-242: Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 * 
 * - An anagram is a word formed by rearranging the letters of 
 *   another word using exactly the same characters and same
 *   frequency.
 * 
 * - Input : s = "anagram", t = "nagaram"
 * - Output: true
 * - Reason: Both strings have the same characters with the same
 *           frequency.
 * 
 * - Input : s = "rat", t = "car"
 * - Output: false
 * - Reason: 'r' and 'c' are different.
 * 
 * Key Insight:
 * - To check if two strings are anagram, the frequency of each
 *   character must be identical in both strings. 
*/

public class _07_valid_anagram {
    /**
     * Approach-1: Brute Force (Sort and Compare)
     * 1. Sort both strings.
     * 2. Compare the sorted versions - if they are same, the strings
     *    are anagram. 
     * 
     * Steps:
     * 1. Edge Case: If lengths are not equal, return false. 
     * 2. Sort both s and t. 
     * 3. Compare it sorted versions are equal. 
     * 4. Return true if they match, otherwise false. 
     * 
     * TC: O(n logn) => Sorting both strings
     * SC: O(n)      => Storing sorted strings
    */

    public static boolean isAnagram(String s, String t) {
        /**
         * 1. Edge Case - Lengths must be equal
        */
        if (s.length() != t.length()) return false;

        /**
         * 2. Convert to character arrays and sort them
        */
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        /**
         * 3. Compare the sorted arrays
        */
        return Arrays.equals(sArray, tArray);
    }


    /**
     * Approach-2: Frequency Map with HashMap1
     * 1. Count frequency of each character in s. 
     * 2. Decrease the count while traversing t. 
     * 3. If any mismatch occurs, return false. 
     * 
     * Steps:
     * 1. Edge Case: If length are not equal, return false.
     * 2. Count Frequency: Use a HashMap to store counts for s. 
     * 3. Check Frequency: Decrease the count for each character in t. 
     * 4. If any mismatch or leftover occurs, return false. 
     * 5. Otherwise, return false. 
     * 
     * TC: O(n) => Traversing both strings once
     * SC: O(n) => Storing frequency of characters in a HashMap
    */

    public static boolean isAnagramII(String s, String t) {
        /**
         * 1. Edge Case - Lengths must be the same
         */
        if (s.length() != t.length()) return false;

        /**
         * 2. Create a frequency map for string s
        */
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        /**
         * 3. Check if characters in t match the frequency
        */
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;  // If char is missing or excess
            }
            map.put(ch, map.get(ch) - 1);
        }

        /**
         * 4.  All frequencies matched
        */
        return true;
    }


    /**
     * Approach-3: Character Array For Frequency
     * Since input is lowercase English letters, use a fixed array of
     * size 26 for counting. 
     * 
     * Steps:
     * 1. Edge Case: If lengths are not equal, return false. 
     * 2. Count Frequency: Use an integer array of size 26 for both
     *    strings. 
     * 3. Check Counts: If any value is non-zero, return false. 
     * 4. Otherwise, return true.
     * 
     * TC: O(n) => Only requires two passes through the strings. 
     * SC: O(1) => Uses a fixed array of size 26.
    */

    public static boolean isAnagramIII(String s, String t) {
        /**
         * 1. Edge Case - Lengths must be the same
        */
        if (s.length() != t.length()) return false;

        /**
         * 2. Create a frequency array for lowercase letters
        */
        int[] count = new int[26];

        /**
         * 3. Populate frequency array for s and t
        */
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for s
            count[t.charAt(i) - 'a']--; // Decrement for t
        }

        /**
         * 4. Check if all counts are zero
         *    - If any mismatch, not an anagram
        */
        for (int num : count) {
            if (num != 0) return false;
        }

        /**
         * 5. All counts match, hence valid anagram
        */
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string s: ");
        String s = scn.nextLine();
        System.out.println("Enter the string t: ");
        String t = scn.nextLine();
        
        System.out.println("Is anagram using Approach-1: " + isAnagram(s, t));
        System.out.println("Is anagram using Approach-2: " + isAnagramII(s, t));
        System.out.println("Is anagram using Approach-3: " + isAnagramIII(s, t));

        scn.close();
    }
}
