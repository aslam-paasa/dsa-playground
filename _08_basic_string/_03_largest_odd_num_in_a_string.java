package _08_basic_string;

import java.util.Scanner;

/**
 * Template-2: String Traversal & Odd Number Extraction
*/

/**
 * Leetcode-1903
 * Given a numeric string num, return the largest odd number that
 * can be formed by non-empty substring of num. If no odd number
 * exists, return an empty string.
 * 
 * - Input : "35427"
 * - Output: "35427 => Entire string is odd because it end with 7 
 *                     which is odd)"
 * 
 * - Input : "4206"
 * - Output: ""     => No odd number is present 
 * 
 * - Input : "52"
 * - Output: "5" (The largest odd number is 5)
 * 
 * Key Insight:
 * - An odd number always end with 1, 3, 5, 7, or 9.
 * - So, the last odd digit determines the largest odd number.
*/

public class _03_largest_odd_num_in_a_string {
    /**
     * Approach-1: Brute Force
     * 1. Check All Substring: Generate all possible substrings.
     * 2. Check Odd Number   : Find the largest substring ending with 
     *                         an odd digit. 
     * 
     * Steps:
     * 1. Initialize an empty string to store the largest odd number. 
     * 2. Loop through all substrings:
     *    - If the substring end with an odd digit, update the result.
     * 3. Return the largest odd substring.
     * 
     * TC: O(n^2) => Generating all substrings takes O(n^2) time. 
     * SC: O(n)   => Space for storing the largest odd substring
    */

    public static String largestOddNumber(String num) {
        String largestOdd = "";
        
        /**
         * 1. Check all substrings
        */
        for (int i = 0; i < num.length(); i++) {
            for (int j = i; j < num.length(); j++) {
                String subStr = num.substring(i, j + 1);
                
                /**
                 * 2. Check if the last character is odd
                 *    - Update largest odd if it's bigger
                */
                if (subStr.charAt(subStr.length() - 1) % 2 != 0) {
                    if (subStr.length() > largestOdd.length()) {
                        largestOdd = subStr;
                    }
                }
            }
        }
        
        return largestOdd;
    }


    /**
     * Approach-2: Right-To-Left
     * 1. Largest Odd Number will always be the longest prefix ending
     *    with an odd digit. 
     * 2. Scan from Right: Find the first odd digit and return the
     *    substring from 0 to that point. 
     * 
     * Steps:
     * 1. Start from the End: Iterate from the last character
     * 2. Find First Odd    : If the character is odd, return the substring. 
     * 3. No Odd Found      : Return an empty string. 
     * 
     * TC: O(n)
     * SC: O(n) => For storing the output
    */

    public static String largestOddNumberII(String num) {
        /**
         * 1. Traverse from right to left
        */
        for (int i = num.length() - 1; i >= 0; i--) {
            /**
             * 2. Check if current character is an odd digit
             *    - Return the largest odd substring
            */
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        
        /**
         * 3. If no odd digit is found, return an empty string
        */
        return "";
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scn.nextLine();

        System.out.println("Largest odd number using Approach-1: " + largestOddNumber(str));
        System.out.println("Largest odd number using Approach-2: " + largestOddNumberII(str));
        
        scn.close();
    }
}
