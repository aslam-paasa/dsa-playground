package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check the grades of a student based on the following conditions
 *    a. 10 - Outstanding
 *    b. 9 - Excellent
 *    c. 8 - Good
 *    d. 7 - Average
 *    e. < 7 - Failed
 *    (Switch Statement)
 * 
 *    switch (expression) {
 *        case constant1:
 *            // Body to be executed
 *            break;
 *        case constant2:
 *            // Body to be executed
 *            break;
 *        default:
 *            // Body to be executed
 *            break;
 *    }
*/

public class _05_check_grades {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your grade: ");
        int grade = scn.nextInt();

        switch (grade) {
            case 10:
                System.out.println("Outstanding");
                break;
            case 9:
                System.out.println("Excellent");
                break;
            case 8:
                System.out.println("Good");
                break;
            case 7:
                System.out.println("Average");
                break;
            default:
                System.out.println("Failed");
                break;
        }
    }
}
