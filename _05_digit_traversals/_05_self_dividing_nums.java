package _05_digit_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Leetcode-728: Self Dividing Numbers
 * A self dividing number is a number that is divisible by each of
 * its digits. 
 * 
 * Given two integers left and right, return all self-dividing
 * numbers in the range [left, right]. 
 * 
 * Input : left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * Explanation:
 * - 128 is not a self-dividing number because:
 *   a. 128 % 2 == 0, 
 *   b. 128 % 8 == 0, but 
 *   c. 128 % 1 == 0.
 * - 26 is not a self-dividing number because 26 % 6 != 0.
 * - 12 is a self-dividing number because 
 *   a. 12 % 1 == 0 and 
 *   b. 12 % 2 == 0.
*/

public class _05_self_dividing_nums {
    /**
     * Approach-1: Brute Force [Check Each Number]
     * - For each number in the range [left, right], check if all its
     *   digits divide it evenly. 
     * - If all digits divide the number, add it to the result list. 
     * 
     * Steps:
     * 1. Iterate from left to right. 
     * 2. For each number, extract digits using % and /
     * 3. Check if the number is divisible by all its digits
     * 4. If yes, add it to the list
     * 5. Return the list of self-dividing numbers. 
     * 
     * TC: O(n x d) => n is num in range, taking d-operations(num of digits)
     * SC: O(1)
    */

    public static List<Integer> selfDividingNumbersI(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int num = left; num <= right; num++) {
            if (isSelfDividingI(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private static boolean isSelfDividingI(int num) {
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;

            // If digit is 0 or num is not divisible by digit, return false
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            
            temp /= 10;
        }
        
        return true;
    }


    /**
     * Approach-2: Early Exit for Faster Execution
     * 1. Instead of checking all digits, exit early if a non-self
     *    dividing digit (like 0) is found. 
     * 2. This prevents unnecessary calculations and speeds up execution. 
     * 
     * Steps:
     * 1. Iterate from left to right. 
     * 2. Extract digits and check divisibility. 
     * 3. If any digit is zero or not a divisor, break early. 
     * 4. Add only valid numbers to the list. 
     * 5. Return the final list. 
     * 
     * TC: O(n x d) => Similar to brute but faster due to early exit. 
     * SC: O(1)
    */

    public static List<Integer> selfDividingNumbersII(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividingII(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private static boolean isSelfDividingII(int num) {
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            
            // Early exit condition
            if (digit == 0 || num % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the left and right range: ");
        int left = scn.nextInt();
        int right = scn.nextInt();

        System.out.println("You entered: " + left + " and " + right);
        System.out.println("Self dividing numbers using Approach-1: " + selfDividingNumbersI(left, right));
        System.out.println("Self dividing numbers using Approach-2: " + selfDividingNumbersII(left, right));
        scn.close();
    }

}
