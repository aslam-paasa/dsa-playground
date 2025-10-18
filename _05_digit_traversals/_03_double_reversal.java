package _05_digit_traversals;

import java.util.Scanner;

public class _03_double_reversal {
    /**
     * Leetcode-2119: A Number After a Double Reversal
     * Given an integer num, return true if num is the same as double
     * reversal, otherwise return false. 
     * 
     * Input : num = 526
     * Output: true
     * => Reverse once  => 625, 
     * => Reverse again => 526 (same as original)
     *
     * Input : num = 1200
     * Output: false
     * => Reverse once => 21,
     * => Reverse again => 12
    */

    /**
     * Approach-1: Reverse Twice
     * - Reverse the number once
     * - Reverse the reversed number again 
     * - If we get the original number, return true, otherwise false
     * 
     * Steps:
     * 1. Reverse num using a loop
     * 2. Reverse the result again
     * 3. Compare with the original number
     * 
     * TC: O(log N)
     * SC: O(1)
    */

    public static boolean isSameAfterReversalsI(int num) {
        return num == reverseNumberI(reverseNumberI(num));
    }

    private static int reverseNumberI(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }


    /**
     * Approach-2: Check for trailing zeros
     * - A number remains the same after double reversal if it has
     *   no trailing zeros. 
     * - Exception: 0 is always valid since reversing 0 keeps it 0.
     * 
     * Steps:
     * 1. If num == 0, return true
     * 2. If num has trailing zeros (num % 10 == 0) return false
     * 3. Otherwise, return true
     * 
     * TC: O(1)
     * SC: O(1) 
    */

    public static boolean isSameAfterReversalsII(int num) {
        return num == 0 || num % 10 != 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = scn.nextInt();

        System.out.println("You entered: " + num);
        System.out.println("Is the number the same after double reversal using Approach-1: " + isSameAfterReversalsI(num));
        System.out.println("Is the number the same after double reversal using Approach-2: " + isSameAfterReversalsII(num));
        scn.close();
    }
}
