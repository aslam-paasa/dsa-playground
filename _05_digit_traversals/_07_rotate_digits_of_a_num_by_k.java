package _05_digit_traversals;

import java.util.Scanner;

/**
 * GFG: Rotate Digits of a Number by K
 * Given a number N and an integer K, rotate the digits of N K-times
 * - If K > 0, rotate right(clockwise)
 * - If K < 0, rotate left (anti-clockwise)
 * - If K == 0, return N as it is
 * - If K is greater than the number of digits in N, take 
 *   K % numDigits to avoid extra rotations. 
 * 
 * Input : N = 12345, K = 2
 * Output: 45123
 * - 1st rotation: 51234
 * - 2nd rotation: 45123 
 * 
 * Input : N = 12345, K = -2
 * Output: 34512
 * - 1st rotation: 23451
 * - 2nd rotation: 34512
 * 
 * Input : N = 98765, K = 5
 * Output: 98765
 * - Rotating 5 times brings it back to original.  
*/

public class _07_rotate_digits_of_a_num_by_k {

    /**
     * Approach-1: Brute Force [Convert to String and Rotate]
     * 1. Convert N to a string to manipulate digits easily. 
     * 2. Rotate left or right K times using substring operations. 
     * 
     * Steps:
     * 1. Convert N to a string. 
     * 2. Count number of digits as numDigits.
     * 3. Take K % numDigits to avoid unnecessary full rotations. 
     * 4. If K > 0, rotate right using substring.
     * 5. If K < 0, rotate left using substring.
     * 6. Convert back to integer and return.
     * 
     * TC: O(K) => Rotating takes O(k), but optimized to O(1)
     * SC: O(d)
    */

    public static int rotateNumber(int N, int K) {
        String numStr = String.valueOf(N);
        int numDigits = numStr.length();

        /**
         * 1. Optimize K to avoid full rotations
         * 2. Convert negative to equivalent positive rotation
         */
        K = K % numDigits;
        if (K < 0) K += numDigits; 

        /**
         * 3. Rotate Right
        */
        String rotated = numStr.substring(numDigits - K) + numStr.substring(0, numDigits - K);
        
        return Integer.parseInt(rotated);
    }


    /**
     * Approach-2: Mathematics [No String Conversion]
     * 1. Use integer operations (/ and %) instead of converting to a
     *    string. 
     * 2. Divide N into two parts and swap them. 
     * 
     * Steps:
     * 1. Count number of digits numDigits in N. 
     * 2. Optimize K using K % numDigits
     * 3. If K < 0, convert it into an equivalent positive rotation
     * 4. Right Rotation:
     *    - Divide into two parts: N / 10^K and N % 10^K
     *    - Swap them and reconstruct the number. 
     * 5. Left Rotation(same concept but with different division)
     * 6. Return the rotated number. 
     * 
     * TC: O(log N)
     * SC: O(1)
    */

    public static int rotateNumberII(int N, int K) {

        /**
         * 1. Count Digits
        */
        int numDigits = countDigits(N);

        /**
         * 2. Optimize K to avoid full rotations
         * 3. Convert negative to equivalent positive rotation
        */
        K = K % numDigits;
        if (K < 0) K += numDigits;

        int divisor = (int) Math.pow(10, K);
        int rightPart = N % divisor;  
        int leftPart = N / divisor;   

        /**
         * 4. Reconstruct rotated number
        */
        int rotated = rightPart * (int) Math.pow(10, numDigits - K) + leftPart;
        return rotated;
    }

    private static int countDigits(int N) {
        int count = 0;
        while (N > 0) {
            count++;
            N /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int N = scn.nextInt();
        System.out.println("Enter the number of rotations: ");
        int K = scn.nextInt();

        System.out.println("You entered: " + N + " and " + K);
        System.out.println("Rotated number using Approach-1: " + rotateNumber(N, K));
        System.out.println("Rotated number using Approach-2: " + rotateNumberII(N, K));
        scn.close();
    }
}
