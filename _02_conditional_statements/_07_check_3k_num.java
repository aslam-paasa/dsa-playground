package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check if a number is a multiple of 3k, 3k+1, or 3k+2
 * 
 *    There are some numbers which are called '3K' numbers
 *    and there are some numbers which are called '3K+1' numbers,
 *    and there are some numbers which are called '3K+2' numbers.
 *    
 *    For example,
 *    (a) 18 = 3*6,   12 = 3*4   => 3K
 *    (b) 19 = 3*6+1,  7 = 3*2+1 => 3K+1
 *    (c) 20 = 3*6+2, 14 = 3*4+2 => 3K+2
*/

public class _07_check_3k_num {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int marks = scn.nextInt();

        if (marks % 3 == 0) {
            System.out.println("3K");
        } else {
            if (marks % 3 == 1) {
                System.out.println("3K+1");
            } else {
                System.out.println("3K+2");
            }
        }
    }
}
