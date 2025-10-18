package _05_digit_traversals;

import java.util.Scanner;

public class _02_reverse_integer {
    /**
     * Leetcode-7: Reverse Integer
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the values to go out of the 32 bit integer 
     * range [-2^31, 2^31 - 1], return 0. 
    */

    /**
     * Approach-1: Brute Force (String)
     * 1. Convert the integer x to a string. 
     * 2. Reverse the string. 
     * 3. Convert it back to an integer. 
     * 4. If th reversed integer exceeds the 32-bit range, return 0.
     * 5. Return the reversed integer. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static int reverseI(int x) {
        boolean isNegative = x < 0;
        String numStr = new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString();
        try {
            int reversed = Integer.parseInt(numStr);
            return isNegative ? -reversed : reversed;
        } catch (NumberFormatException e) {
            return 0; // Handle overflow case
        }
    }


    /**
     * Approach-2: Modulo & Division
     * 1. Extract the last digit of x using x % 10.
     * 2. Build the reversed num by multiplying the current result by
     *    10 and adding the last digit.
     * 3. Check if the result exceeds the 32-bit integer range before
     *    updating it. 
     * 4. Repeat until x becomes 0. 
     * 5. Return the reversed number.
     * 
     * TC: O(log10 N) => Each division step reduces x by one digit
     * SC: O(1)
    */

    public static int reverseII(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            rev = rev * 10 + digit;
        }
        return rev;
    }


    /**
     * Approach-3: Without Explicit Overflow Check
     * 1. Instead of checking overflow conditions separately, we can
     *    let Java handle it using try-catch. 
     * 2. Extract digits one by one using modulo and divison. 
     * 3. Multiply the reversed number by 10 and add the extracted
     *    digit. 
     * 4. If an exception occurs due to overflow, return 0. 
    */

    public static int reverseIII(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            try {
                rev = Math.multiplyExact(rev, 10); // Checks for overflow
                rev = Math.addExact(rev, digit);
            } catch (ArithmeticException e) {
                return 0;
            }
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        System.out.println("You entered: " + x);

        System.out.println("Reverse of the number using Approach-1: " + reverseI(x));
        System.out.println("Reverse of the number using Approach-2: " + reverseII(x));
        System.out.println("Reverse of the number using Approach-3: " + reverseIII(x));

        scn.close();
    }
}