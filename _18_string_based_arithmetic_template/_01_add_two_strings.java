package _18_string_based_arithmetic_template;

/**
 * Leetcode-415: Add Strings
 * Given two non-negative integers represented as strings num1 and
 * num2, return their sum as a string.
 * 
 * Note:
 * 1. You cannot convert strings directly to integer(because of
 *    possible overflow).
 * 2. Both num1 and num2 contain only digits '0'-'9'. 
 * 3. No leading zeros except the number '0' itself. 
 * 
 * - Input : num1 = "456", num2 = "77"
 * - Output: "533"
 * - Explanation: 456 + 77 = 533
 * 
 * - Input : num1 = "0", num2 = "0"
 * - Output: "0"
*/

public class _01_add_two_strings {
    /**
     * Approach-1: Brute Force
     * 1. Reverse both strings to make it easier to add from the right
     *    (units place).
     * 2. Add digits one by one with carry(like manual addition).
     * 3. Reverse the result and return it. 
     * 
     * TC: O(n + m) 
     *     - O(max(n, m)) => We process both strings once, where n and m
     *                       are their lengths.
     *     - O(n + m)     => To reverse the result
     * SC: O(n + m)       => Storing the result in StringBuilder
    */

    public static String addStringsI(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        /**
         * 1. Traverse both strings from the end
         *    - Store the last digit
         *    - Update carry
         *    - Move to the left
         */
        while (i >= 0 || j >= 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            
            i--; j--;
        }

        /**
         * 2. If carry remains, add it
         */
        if (carry > 0) {
            result.append(carry);
        }

        /**
         * 3. Reverse the result and return
         */
        return result.reverse().toString();
    }


    /**
     * Approach-2: In-place Digit Addition
     * 1. No need to reverse: Traverse from the end directly. 
     * 2. Use StringBuilder and append digits while processing. 
     * 3. Avoid extra loops by processing both strings together. 
     * 
     * TC: O(n + m) => We process each digit from both numbers once.
     * SC: O(n + m) => Output string
    */

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        /**
         * 1. Traverse both numbers from the end
         *    - Add last digit
         *    - Carry forward
         *    - Move to the left
         */
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10); // Add last digit
            carry = sum / 10;        // Carry forward

            i--; j--; // Move to the left
        }

        /**
         * 2. Since we added from the back, reverse at the end
         */
        return result.reverse().toString();
    }
}
