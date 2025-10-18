package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to take an integral input and print the statement corresponding to
 * the following conditions
 * a. Divisible by 5 and 8 - print 58
 * b. Divisible only by 5 - print 5
 * c. Divisible only by 8 - print 8
 * d. Divisible by none of these - print "None"
 * 
 * if (boolean condition) {
 * // Body to be executed
 * } else if (boolean condition) {
 * // Body to be executed
 * } else {
 * // Body to be executed
 * }
 */

public class _03_if_else_if_condition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter you number: ");
        int num = scn.nextInt();

        if (num % 5 == 0 && num % 8 == 0) {
            System.out.println("58");
        } else if (num % 5 == 0) {
            System.out.println("5");
        } else if (num % 8 == 0) {
            System.out.println("8");
        } else {
            System.out.println("none!");
        }
    }
}
