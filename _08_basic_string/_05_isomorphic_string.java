package _08_basic_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Template-4: Character Mapping(Isomorphic Strings, String Rotation)
*/

/**
 * Leetcode-205: Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * - Two Strings are isomorphic if the characters in s can be
 *   replaced to get t, while preserving the order and ensuring
 *   a one-to-one mapping between characters. 
 * 
 * - Input : s = "egg", t = "add"
 * - Output: true
 * - Reason: 'e' -> 'a', 'g' -> 'd' (consistent mapping)
 * 
 * - Input : s = "foo", t = "bar"
 * - Output: false
 * - Reason: 'o' -> 'a', 'o' -> 'r' (inconsistent mapping)
 *
 * - Input : s = "paper", t = "title"
 * - Output: true
 * - Reason: 'p' -> 't', 'a' -> 'i', 'e' -> 'l', 'r' -> 'e' (consistent mapping)
 * 
 * Key Insight:
 * 1. Each character in s shows map to one character in t. 
 * 2. No two characters in s can map to the same character is `t. 
*/

public class _05_isomorphic_string {
    /**
     * Approach-1: Brute Force (Check Each Mapping Manually)
     * 1. Create two arrays:
     *    - One for mapping characters from s -> t
     *    - One for mapping characters from t -> s
     * 2. For every character in s and t:
     *    - Ensure both mappings are consistent.
     * 3. If any mismatch occurs, return false. 
     * 
     * Steps:
     * 1. Edge Case: If s and t are of different lengths, return false.
     * 2. Create Mappings: Use two arrays of size 256(for ASCII characters)
     *    to track mappings. 
     * 3. Character Check:
     *    - If a character in s is already mapped, ensure it maps to the
     *      correct character in t. 
     *    - If a character in t is already mapped, ensure it maps to the
     *      correct character in s. 
     * 4. Return true: If all checks pass.
     * 
     * TC: O(n)   => We iterate through both strings once.
     * SC: O(256) => O(1)
    */

    public static boolean isIsomorphicI(String s, String t) {
        /**
         * 1. Edge Case - Different lengths cannot be isomorphic
        */
        if (s.length() != t.length()) return false;

        /**
         * 2. Create mapping arrays for both directions
         *    - Mapping from s to t
         *    - Mapping from t to s
        */
        int[] sToT = new int[256];
        int[] tToS = new int[256];

        /**
         * 3. Check mappings for each character
        */
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            /**
             * a. If a mapping exists and is inconsistent, return false
             *    - If no mapping exists, create a new one
             *    - If mapping exists, ensure it is consistent
             */
            if (sToT[charS] == 0) {
                sToT[charS] = charT; 
            } else if (sToT[charS] != charT) {
                return false; 
            }

            if (tToS[charT] == 0) {
                tToS[charT] = charS;
            } else if (tToS[charT] != charS) {
                return false;
            }
        }

        /**
         * 4. If no mismatches found, return true
        */
        return true;
    }


    /**
     * Approach-2: HashMap
     * Instead of arrays, use two hashmaps to store chars mapping.
     * 
     * Steps:
     * 1. Edge Case: If lengths differ, return false. 
     * 2. Create Maps: Use two HashMaps for mapping s -> t and t -> s.
     * 3. Character Check:
     *    - If the character exists, check if the mapping is consistent.
     *    - If a new mapping is needed, add to both maps. 
     * 4. Return Result: Return true if all checks pass.
     * 
     * TC: O(n) => Iterate through both strings once.
     * SC: O(n) => Extra space for the two hashmaps.
    */

    public static boolean isIsomorphicII(String s, String t) {
        /**
         * 1. Edge Case - If lengths differ
        */
        if (s.length() != t.length()) return false;

        /**
         * 2. Create two HashMaps
        */
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        /**
         * 3. Traverse through both strings
        */
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check s -> t mapping
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) return false;  // Inconsistent mapping
            } else {
                mapST.put(charS, charT);
            }

            // Check t -> s mapping
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) return false;  // Inconsistent reverse mapping
            } else {
                mapTS.put(charT, charS);
            }
        }

        /**
         * 4. If no mismatches found, return true
        */
        return true;
    }


    /**
     * Approach-3: Single Map with Index Check
     * Use a single map to check both mappings using a unique encoding.
     * 
     * Steps:
     * 1. Edge Case: Return false if lengths differ.
     * 2. Character Mapping:
     *    - If a character from s to t appears for the first time, 
     *      store its index. 
     *    - If mappings don't match, return false. 
     * 3. Return false if all characters match. 
     * 
     * TC: O(n) => Iterate through both strings once.
     * SC: O(256) => O(1)
    */

    public static boolean isIsomorphicIII(String s, String t) {
        /**
         * 1. Edge Case - Length check
        */
        if (s.length() != t.length()) return false;

        /**
         * 2. Character mapping arrays
        */
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        /**
         * 3. Iterate and check mappings
        */
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check both mappings
            if (mapS[charS] != mapT[charT]) return false;

            // Store the index as a unique identifier
            mapS[charS] = mapT[charT] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string s: ");
        String s = scn.nextLine();
        System.out.println("Enter the string t: ");
        String t = scn.nextLine();

        System.out.println("Is isomorphic using Approach-1: " + isIsomorphicI(s, t));
        System.out.println("Is isomorphic using Approach-2: " + isIsomorphicII(s, t));
        System.out.println("Is isomorphic using Approach-3: " + isIsomorphicIII(s, t));
        
        scn.close();
    }
}
