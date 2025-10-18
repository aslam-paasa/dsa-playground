package _19_integer_based_big_integer_template;

import java.util.ArrayList;
import java.util.List;

/**
 * GFG: Factorials of Large Numbers
 * Given an integer N, your task is to compute the factorial of N.
 * Since the value of N! can be veru large, return the result as
 * an array of digits in the correct order. 
 * 
 * - Input : N = 5
 * - Output: 120
 * - Explanation: 5! = 5 x 4 x 3 x 2 x 1 = 120
 * 
 * - Input : N = 10
 * - Output: 3628800
 * - Explanation: 10! = 3628800
 * 
 * Understanding the Problem:
 * Factorial(N!) means multiplying all positive integers from 1 to N:
 * - N! = n x (N-1) x (N-2) x .... x 1
 * The problem is that for large N(like 100 or more), the factorial
 * value becomes so big that it can't fit in primitive data types
 * (int, long).
*/

public class _01_large_factorials {
    /**
     * Approach-1: Brute Force
     * 1. Array as Storage: Use an array to store each digit of the
     *    factorial. 
     * 2. Multiplication by Each Number: Multiply each number from 1
     *    to N. 
     * 3. Carry Management: Handle carry while multiplying. 
     * 4. Reverse Output: Store and display the array in the correct
     *    order. 
     * 
     * TC: O(N x M), where: N = Input Number
     *                      M = Num of digits in the result(logarithmic growth)
     *     - O(N) => For multiplying each number from 1 to N
     *     - O(digits in result) => For managing carry and digit updates.
     * 
     * SC: O(digits in result) => To store the large factorial
     *     - O(N) due to array storage for large numbers
    */

    public static List<Integer> factorial(int N) {
        List<Integer> result = new ArrayList<>();

        /**
         * Start with 1 because 0! = 1 and 1! = 1
        */
        result.add(1); 

        /**
         * 1. Multiply each number from 2 to N
        */
        for (int num = 2; num <= N; num++) {
            multiply(result, num);
        }

        return result;
    }

    /**
     * Helper method to multiply the current result with a number:
     */
    private static void multiply(List<Integer> result, int num) {
        int carry = 0;
        
        /**
         * 2. Multiply each digit by num and add carry:
         *    - Store the last digit
         *    - Extract the carry
         */
        for (int i = result.size() - 1; i >= 0; i--) {
            int product = result.get(i) * num + carry;
            result.set(i, product % 10);
            carry = product / 10;
        }

        /**
         * 3. Add remaining carry as new digits
         *    - Insert at the beginning
         */
        while (carry > 0) {
            result.add(0, carry % 10); 
            carry /= 10;
        }
    }
}
