package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check if a number is a multiple of 3 or not.
 *    (If-Else)
 * 
 *    if (boolean condition) {
 *        // Body to be executed
 *    } else {
 *        // Body to be executed
 *    }
 */

public class _09_check_multi_of_three_num {
    public static boolean isMultipleOfThree(int n) {
        if (n % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = scn.nextInt();

        if (isMultipleOfThree(n)) {
            System.out.println("Multiple of 3");
        } else {
            System.out.println("Not a multiple of 3");
        }
    }
}
