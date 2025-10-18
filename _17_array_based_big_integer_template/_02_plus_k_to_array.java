package _17_array_based_big_integer_template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode-989: Add to Array-Form of Integer
 * You are given:
 * a. An integer array num[] where each element represents a digit
 *    of a large integer. 
 * b. An integer k which you need to add to the number represented
 *    by the array.
 * Your task is to return the sum in the same array form.
 * 
 * - Input : [1, 2, 0, 0], k = 34
 * - Output: [1, 2, 3, 4]
 * - Explanation: 1200 + 34 = 1234
 * 
 * - Input : [9, 9, 9, 9], k = 1
 * - Output: [1, 0, 0, 0, 0]
 * - Explanation: 9999 + 1 = 10000
*/

public class _02_plus_k_to_array {
    /**
     * Approach-1: Brute Force [Testcase Failed]
     * 1. Convert the num[] array to a full integer value.
     * 2. Add k to this number.
     * 3. Extract digits to the resulting sum and store them back in
     *    an array.
     * 
     * Steps:
     * 1. Traverse the num[] array and build the number. 
     * 2. Add k to the number. 
     * 3. Convert the sum back to an array by extracting each digit.
     * 
     * TC: O(n + d)
     *     - O(n) => To build the num from the array
     *     - O(d) => Where d is the num of digits in the resulting sum
     * SC: O(d)   => Space required for the output list.
    */

    public static List<Integer> addToArrayForm(int[] num, int k) {
        long number = 0;
        
        /**
         * 1. Convert array to integer
         */
        for (int digit : num) {
            number = number * 10 + digit;
        }

        /**
         * 2. Add k to the number
         */
        number += k;

        /**
         * 3. Convert the number back to an array
         */
        List<Integer> result = new ArrayList<>();
        if (number == 0) {
            result.add(0);
            return result;
        }

        while (number > 0) {
            result.add(0, (int) (number % 10)); // Extract last digit
            number /= 10;
        }

        return result;
    }

    /**
     * Approach-2:  Digit-by-Digit Addition
     * 1. Add k digit-by-digit from the righmost side(like manual
     *    addition).
     * 2. Carry is handled if a sum exceeds 9. 
     * 3. Continue until both num[] and k are fully processed. 
     * 
     * Steps:
     * 1. Start from the last index of the array.
     * 2. Add the last digit of k and handle the carry. 
     * 3. Continue until both the array and k are processed. 
     * 4. If carry remains, add it to the result. 
     * 5. Reverse the result before returning. 
     * 
     * TC: O(n + d)
     *     - O(max(n, d)) => We loop through the larger of the two 
     *                       inputs(num[] or k).
     *     - O(n)         => For reversing the list at the end
     * SC: O(n + d)       => Space for the result list. 
    */

    public static List<Integer> addToArrayFormII(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int i = n - 1;
        int carry = 0;

        /**
         * Traverse from the end of the array:
         * - Take digit from array (or 0 if out of bounds)
         * - Add last digit of k and carry
         * - Store the last digit of sum
         * - Update carry
         * - Remove last digit of k
         * - Move to the left in the array
         */
        while (i >= 0 || k > 0) {
            int digit = (i >= 0) ? num[i] : 0; 

            int sum = digit + (k % 10) + carry;
            result.add(sum % 10); 
            carry = sum / 10;

            k /= 10;
            i--;
        }

        /**
         * If there is still a carry left, add it:
         */
        if (carry > 0) {
            result.add(carry);
        }

        /**
         * Reverse the result to get the correct order:
         */
        Collections.reverse(result);

        return result;
    }
}
