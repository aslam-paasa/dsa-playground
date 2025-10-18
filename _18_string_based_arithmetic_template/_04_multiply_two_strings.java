package _18_string_based_arithmetic_template;

/**
 * Leetcode-43: Multiply Strings
 * Given two non-negative integers num1 and num2 represented as
 * strings, return their product as a string.
 * 
 * - You cannot use built-in big integer librarier.
 * 
 * - Input : num1 = "123", num2 = "45"
 * - Output: "5535"
 * - Explanation: 123 x 45 = 5535
 * 
 * - Input : num1 = "2", num2 = "3"
 * - Output: "6"
 * 
 * - Input : num1 = "0", num2 = "0"
 * - Output: "0"
 * 
 * Understanding the Problem:
 * We need to manually perform string multiplication like how we
 * do it on paper:
 * 1. Multiply each digit of num1 by each digit of num2.
 * 2. Store the results in the appropriate positions(like in column
 *    multiplication).
 * 3. Handle carry and convert the result back to a string. 
*/

public class _04_multiply_two_strings {
    /**
     * Approach-1: Brute Force
     * 1. Reverse both strings for easier multiplication(right-to-left
     *    reversal).
     * 2. Multiply each digit of num1 with each digit of num2. 
     * 3. Store the sum at the correct position in a result array. 
     * 4. Handle carry and update the result. 
     * 5. Convert the result array to a final string. 
     * 
     * TC: O(m x n) => For multiplying every digit of num1 with num2.
     * SC: O(m + n) => For storing the result in an array. 
    */

    public static String multiply(String num1, String num2) {
        /**
         * If either number is zero, return "0":
         */
        if (num1.equals("0") || num2.equals("0")) return "0";

        /**
         * Result array to store multiplication:
        */
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        /**
         * 1. Multiply each digit and store the result
         */
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to existing value

                /**
                 * 2. Store carry and current digit:
                 */
                result[i + j + 1] = sum % 10; // Current digit
                result[i + j] += sum / 10;    // Carry to next position
            }
        }

        /**
         * 3. Build the final result string
         */
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
