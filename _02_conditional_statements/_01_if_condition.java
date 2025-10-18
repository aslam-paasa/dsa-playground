package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to print congratulations message if score of a student is 
 *    greater than 80. (If-Statement only)
 *    
 *    if (boolean condition) {
 *         // Body to be executed
 *    }
 */

public class _01_if_condition {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        
        System.out.println("Enter your score: ");
        int score = scn.nextInt();

        if(score > 80) {
            System.out.println("Congratulations!!");
        } 
    }

}
