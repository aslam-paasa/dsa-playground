package _17_array_based_big_integer_template;

/**
 * Leetcode-66: Plus One
 * You are given a large inetger represented as an array digits[]
 * where:
 * a. Each element in the array represents a digit. 
 * b. The most siginificant digit is at the beginning. 
 * c. You need to add 1 to the integer and return the updated array.
 * 
 * - Input : digits = [1, 2, 3]
 * - Output: [1, 2, 4]
 * - Explanation: 123 + 1 = 124
 * 
 * - Input : digits = [9, 9, 9]
 * - Output: [1, 2, 4]
 * - Explanation: 999 + 1 = 1000
*/  

public class _01_plus_one_to_array {
    /**
     * Approach-1: Brute Force
     * 1. Start from the last digit - add 1 to it. 
     * 2. If no carry is generated, return the array. 
     * 3. If there's a carry, keep propagating the carry backwards. 
     * 4. If the carry still exists after the loop (like in 999), 
     *    insert 1 at the beginning. 
     * 
     * Approach:
     * 1. Traverse the array backwards
     * 2. Add 1 to the last digit. 
     * 3. Handle the carry:
     *    a. If no carry, return the array. 
     *    b. If carry propagates to the first digit, insert 1 at the
     *       front. 
     * 4. Return the updated array. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        /**
         * Traverse from the last digit:
         * - No carry, return result
         * - If 9, set to 0 and continue
         */
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        /**
         * If we reach here, all digits were 9 (e.g., 999 → 1000):
         * - Set the first digit to 1
         * - All other positions are 0 by default
         */
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; 
        return newDigits;
    }


    /**
     * Approach-2: Carry Forward Method
     * 1. Instead of using array space for small inputs, update the
     *    array in-place. 
     * 2. Handle carry efficiently:
     *    - If carry exists after processing all digits, create a new
     *      array. 
     * 3. Works in O(n) time and O(1) space for in-place updates. 
    */

    public static int[] plusOneII(int[] digits) {
        int carry = 1; // We are adding +1
        int n = digits.length;

        /**
         * Traverse from the last digit:
         * - No carry, return the result
         * - Set current digit to 0 and propagate carry
         */
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }

        /**
         * If all digits were 9 (like 999 → 1000):
         */
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
