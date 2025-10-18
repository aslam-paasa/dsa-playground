package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to print congratulations message if score of a student is greater than 80. 
 *    Also, wish luck to students whose score is less than or equal to 80,
 *    (If-Else Statement only)
 * 
 *    if (boolean condition) {
 *         // Body to be executed
 *    } else {
 *         // Body to be executed
 *    }
*/

public class _02_if_else_condition {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your score: ");
        int score = scn.nextInt();

        if(score > 80) {
            System.out.println("Congratulations!!");
        } else {
            System.out.println("Better luck next time!");
        }
    }
}
