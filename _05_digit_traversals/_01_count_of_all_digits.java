package _05_digit_traversals;

import java.util.Scanner;

/**
 * Q. Given an integer N, count the number of digits in N.
 */
public class _01_count_of_all_digits {

    /**
     * Approach-1: Brute Force
     * 1. Convert the number N into a string. 
     * 2. Find the length of the string, which will give the count
     *    of digits. 
     * 3. Return the length. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static int countDigitsI(int N) {
        String numStr = Integer.toString(N); 
        return numStr.length(); 
    }


    /**
     * Approach-2:
     * 1. Initialize a count variable to 0.
     * 2. Use a loop to repeatedly divide N by 10. 
     * 3. Each division removes one digit, so increases count in every
     *    step. 
     * 4. Stop when N becomes 0, and return count. 
     * 
     * TC: O(log10 N) => Num of iterations == Num of digits in N
     * SC: O(1)
    */

    public static int countDigitsII(int N) {
        int count = 0;
        while (N > 0) {
            count++;
            N /= 10; // Remove the last digit
        }
        return count;
    }


    /**
     * Approach-3: Logarithm
     * 1. Use the mathematical formula:
     *    - Count of digits = floor(log10 N) + 1
     * 2. Return the computed value. 
     * 
     * TC: O(1)
     * SC: O(1)
    */

    public static int countDigitsIII(int N) {
        if (N == 0) return 1; // Special case for N = 0
        return (int) (Math.log10(N) + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int N = scn.nextInt();


        System.out.println("Count of digits using Approach-1: " + countDigitsI(N));
        System.out.println("Count of digits using Approach-2: " + countDigitsII(N));
        System.out.println("Count of digits using Approach-3: " + countDigitsIII(N));

        scn.close();
    }
}
