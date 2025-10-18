package _05_digit_traversals;

import java.util.Scanner;

/**
 * Leetcode-1281: Subtract the Product and Sum of Digits of an Integer
 * Given an integer n, calculate the product of its digits and the
 * sum of its digits. Return the result of product - sum. 
 * 
 * Input : n = 234
 * Output: 15
 * - Product = 2 * 3 * 4 = 24
 * - Sum = 2 + 2 + 4 = 9
 * - Result = 24 - 9 = 15 
 * 
 * Input : n = 4421
 * Output: 21
 * - Product = 4 * 4 * 2 * 1 = 32
 * - Sum = 4 + 4 + 2 + 1 = 11
 * - Result = 32 - 11 = 21 
*/

public class _04_subtract_the_product_of_and_sum_of_digits_of_an_integer {
    /**
     * Approach-1: Brute Force [String]
     * - Convert n to a string to extract digits
     * - Compute product and sum separately. 
     * - Return product - sum. 
     * 
     * Steps:
     * 1. Convert n to a string
     * 2. Initialize product = 1 and sum = 0
     * 3. Iterate through the string and update product and sum
     * 4. Return product - sum 
     * 
     * TC: O(d) => d is the num of digits in n (logarithmic in n)
     * SC: O(d) => Storing the string representation
    */

    public static int subtractProductAndSumI(int n) {
        String numStr = String.valueOf(n);
        int product = 1, sum = 0;

        for (char digit : numStr.toCharArray()) {
            int d = digit - '0';
            product *= d;
            sum += d;
        }

        return product - sum;
    }

    /**
     * Approach-2: Mathematics [No String Concatenation]
     * 1. Extract digits using modulo (% 10) and integer division (/ 10)
     * 2. Compute product and sum simultaneously. 
     * 
     * Steps:
     * 1. Initialize product = 1, sum = 0
     * 2. Use a loop to extract digits (n % 10)
     * 3. Multiply digits for product and add for sum
     * 4. Reduce n by n / 10
     * 5. Return product - sum 
     * 
     * TC: O(d) => d is the num of digits in n. 
     * SC: O(1)
    */

    public static int subtractProductAndSumII(int n) {
        int product = 1, sum = 0;

        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }

        return product - sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        
        System.out.println("You entered: " + n);
        System.out.println("Subtract the product and sum of digits of an integer using Approach-1: " + subtractProductAndSumI(n));
        System.out.println("Subtract the product and sum of digits of an integer using Approach-2: " + subtractProductAndSumII(n));
        scn.close();
    }

}
