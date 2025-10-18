package _18_string_based_arithmetic_template;

/**
 * GFG: Difference of Two Large Numbers
 * Given two non-negative integers represented as strings num1 and
 * num2, return their difference as a string:
 * 1. Assume num1 is always greater than or equal to num2
 *    (no negative results).
 * 2. Both num1 and num2 contain only digits '0'-'9'. 
 * 3. No leading zeros in the output except for the number '0'
 *    itself. 
 * 
 * - Input : num1 = "456", num2 = "77"
 * - Output: "379"
 * 
 * - Input : num1 = "1000", num2 = "1"
 * - Output: "999"
 * 
 * - Input : num1 = "987654321", num2 = "123456789"
 * - Output: "864197532"
 * - Explanation: 987654321 - 123456789 = 864197532
*/

public class _02_subtract_two_strings {
    /**
     * Approach-1: Brute Force
     * 1. Reverse both strings - Makes subtraction easier from right
     *    to left. 
     * 2. Subtract digits one by one with borrow(like manual subtraction)
     * 3. Remove leading zeros and return the result. 
     * 
     * TC: O(n)
     *     - We process both numbers digit by digit : O(n)
     *     - To traverse the result and remove leading zeros : O(n)
     * SC: O(n) 
     *     - For storing the result in StringBuilder : O(n)
    */

    public static String subtractStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int borrow = 0;

        /**
         * 1. Traverse both numbers from the end
         */
        while (i >= 0) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            /**
             * a. Handle borrow if digit1 is smaller:
             *    - If Case:
             *      - Borrow from next digit
             *      - Set borrow flag
             *    - Else Case:
             *      - Reset borrow flag
             */
            if (digit1 < (digit2 + borrow)) {
                digit1 += 10;
                borrow = 1; 
            } else {
                borrow = 0; 
            }

            int diff = digit1 - digit2 - borrow;
            result.append(diff);
            
            i--; j--; // Move left
        }

        /**
         * 3. Remove leading zeros
         */
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        /**
         * 4. Reverse and return the result
         */
        return result.reverse().toString();
    }


    /**
     * Approach-2: In-place Borrow Handling
     * 1. No need to reverse - We handle digits from right to left. 
     * 2. Use StringBuilder to store the result. 
     * 3. Avoid multiple passes - Remove leading zeros in the same loop. 
     * 
     * TC: O(n)
     * SC: O(n)
    */

    public static String subtractStringsII(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int borrow = 0;

        /**
         * 1. Traverse both numbers from the right
         */
        while (i >= 0) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            /**
             * 2. Handle borrow if needed
             */
            if (digit1 < (digit2 + borrow)) {
                digit1 += 10; // Borrow from the next digit
                borrow = 1;   // Set borrow
            } else {
                borrow = 0;   // Reset borrow
            }

            int diff = digit1 - digit2 - borrow;
            result.append(diff);

            i--; j--;
        }

        /**
         * 3. Remove leading zeros (optimized in-place)
         */
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        /**
         * 4. Reverse to get the final answer
         */
        return result.reverse().toString();
    }
}
