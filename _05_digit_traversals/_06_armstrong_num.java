package _05_digit_traversals;

import java.util.Scanner;

/**
 * GFG: Armstrong Number
 * A number is called an armstrong number if the sum of its digits
 * raised to the power of the number of digits is equal to the number
 * itself. 
 * 
 * For example, 153 is an armstrong number because:
 * 1^3 + 5^3 + 3^3 = 1 + 125 + 7 = 153
 * 
 * Given an integer N, return YES if it is an Armstrong number,
 * otherwise return NO. 
*/

public class _06_armstrong_num {

    /**
     * Approach-1: Brute Force [String]
     * 1. Convert N to a string to count its digits. 
     * 2. Extract each digit, raise to the power of numDigits, and sum
     *    them. 
     * 3. Compare the sum with N. 
     * 
     * Steps:
     * 1. Convert N to a string to count digits. 
     * 2. Initialize sum = 0
     * 3. Iterate through digits, compute digit ^ numofDigits, and
     *    add to sum
     * 4. Compare sum with N
     * 5. Return YES if equal, otherwise NO
     * 
     * TC: O(d)
     * SC: O(d)
    */

    public static String isArmstrongI(int N) {
        String numStr = String.valueOf(N);
        int numDigits = numStr.length();
        int sum = 0;

        for (char digit : numStr.toCharArray()) {
            int d = digit - '0';
            sum += Math.pow(d, numDigits);
        }

        return sum == N ? "YES" : "NO";
    }


    /**
     * Approach-2: Mathematics [No String Conversion]
     * 1. Extract digits using modulo(% 10) and integer division(/ 10)
     * 2. Compute the sum of digits ^ numofDigits without converting N
     *    to a string. 
     * 
     * Steps:
     * 1. Copy N into temp to count digits (numDigits).
     * 2. Extract each digit (N % 10), raise to power numDigits, and sum.
     * 3. Compare sum with N.
     * 4. Return "YES" if equal, otherwise "NO".
     * 
     * TC: O(d)
     * SC: O(1) 
    */

    public static String isArmstrongII(int N) {
        int numDigits = 0, temp = N, sum = 0;

        /**
         * 1. Count the number of digits
        */
        while (temp > 0) {
            numDigits++;
            temp /= 10;
        }

        temp = N;

        /**
         * 2. Calculate sum of each digit raised to numDigits
        */
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }

        return sum == N ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int N = scn.nextInt();

        System.out.println("You entered: " + N);
        System.out.println("Is the number an Armstrong number using Approach-1: " + isArmstrongI(N));
        System.out.println("Is the number an Armstrong number using Approach-2: " + isArmstrongII(N));
        scn.close();
    }
}
