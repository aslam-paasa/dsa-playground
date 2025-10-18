package _03_loop_basics;

import java.util.Scanner;

/**
 * Q. WAP to print all odd and even numbers from 1 to n.
 */
public class _04_print_odd_and_even {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int p = 1;
        while (p <= num) {
            int rem = p % 2;

            if (rem == 0) {
                System.out.println(p + " is even");
            } else {
                System.out.println(p + " is odd");
            }
            p++;
        }
    }
}
