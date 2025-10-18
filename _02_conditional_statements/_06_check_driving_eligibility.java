package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check if a person is eligible to drive based on their age.
 *    (Ternary Operator)
 * 
 *    a. Using if-else statement
 *       if (boolean condition) {
 *           // Body to be executed
 *       } else {
 *           // Body to be executed
 *       }
 * 
 *    b. Using ternary operator
 *       return (condition) ? true : false;
 * 
 *    c. Using return statement
 *       return (condition);
 */

public class _06_check_driving_eligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        if (check(age)) {
            System.out.println("Eligible to drive");
        } else {
            System.out.println("Not eligible to drive");
        }
    }

    public static boolean check(int age) {
        return (age >= 18);
    }
}
