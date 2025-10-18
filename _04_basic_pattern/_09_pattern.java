package _04_basic_pattern;

import java.util.Scanner;

/**
 * Pattern Problem Rules: 95% pattern problems are solved using this rule
 * 1. Nested Loops
 * 2. Number of times the outer loop runs = no. of rows
 * 3. Number of times the inner loop runs = no. of columns
 * 4. Print the pattern inside inner loop
 * 5. Formulate the inner loop variable's limit(j) in term of outer loop
 * variable(i) and input(n), i.e. j = f(i,n)
 */

public class _09_pattern {
    public static void main(String[] args) {

        // N => 5
        // *
        // * * *
        // * * * * *
        // * * * * * * *
        // * * * * * * * * *

        // ------------------
        // i spaces stars
        // ------------------
        // 0 4 1
        // 1 3 3
        // 2 2 5
        // 3 1 7
        // 4 0 9

        // Two loops:
        // (a) for spaces: (n-i-1) => (5-0-1) = 4, (5-1-1) = 3 etc...
        // (b) for stars: (2*i+1) => (2*0+1) = 1, (2*1+1) = 3 etc...

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = scn.nextInt();

        System.out.println();

        System.out.println("Here is your pattern: ");
        for (int i = 0; i < n; i++) {

            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            // Stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
