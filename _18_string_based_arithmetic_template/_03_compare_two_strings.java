package _18_string_based_arithmetic_template;

/**
 * GFG: Compare two large numbers
 * Given two large positive integers num1 and num2 as strings,
 * your task is to compare these numbers. 
 * 
 * Return:
 * a. 1,  if num1 > num2
 * b. -1, if num1 < num2
 * c. 0,  if num1 = num2
 * 
 * - Input : num1 = "987654321", num2 = "123456789"
 * - Output: 1
 * - Explanation: 987654321 is greater than 123456789
 * 
 * - Input : num1 = "1000", num2 = "1000"
 * - Output: 0
 * - Explanation: Both numbers are equal
 * 
 * - Input : num1 = "12345", num2 = "98765"
 * - Output: -1
 * - Explanation: 12345 is smaller than 98765 
*/

public class _03_compare_two_strings {
    /**
     * Approach-1:
     * 1. Compare lengths: Longer number is greater. 
     * 2. If lengths are equal: Compare each digit from left to right.
     * 3. Return the result based on comparison. 
     * 
     * TC: O(n) => For comparing all digits (when lengths are the same)
     * SC: O(1)
    */

    public static int compareLargeNumbers(String num1, String num2) {
        /**
         * 1. Compare lengths first
         *    - num1 is greater
         *    - num2 is greater
         */
        if (num1.length() > num2.length()) return 1;
        if (num1.length() < num2.length()) return -1;

        /**
         * 2. Compare digit by digit (when lengths are the same)
         *    - num1 is greater
         *    - num2 is greater
         */
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) > num2.charAt(i)) return 1;
            if (num1.charAt(i) < num2.charAt(i)) return -1; 
        }

        /**
         * 3. If all digits are the same
         */
        return 0;
    }    
}
