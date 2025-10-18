package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check if a number is positive or not.
 *    (If-Else)
 * 
 *    if (boolean condition) {
 *        // Body to be executed
 *    } else {
 *        // Body to be executed
 *    }
*/

public class _08_check_positive_num {
    public static boolean isPositive(int n) {
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = scn.nextInt();

        if (isPositive(n)) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
}
