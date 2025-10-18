package _04_basic_pattern;

import java.util.Scanner;

/**
 * Pattern Problem Rules:
 * 1. Nested Loops
 * 2. Number of times the outer loop runs = no. of rows
 * 3. Number of times the inner loop runs = no. of columns
 * 4. Print the pattern inside inner loop
 * 5. Formulate the inner loop variable's limit(j) in term of outer loop
 *    variable(i) and input(n), i.e. j = f(i,n)
*/

public class _04_pattern {
    public static void main(String[] args) {
        /**
         * N = 5
         * * # i=0 -> 1 col(j)
         * * * # i=1 -> 2 col(j)
         * * * * # i=2 -> 3 col(j)
         * * * * * # i=3 -> 4 col(j)
         * * * * * * # i=4 -> 5 col(j)
         * => We can say inner loop is runnung 'i+1' times.
         */

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = scn.nextInt();

        System.out.println("Here is your pattern: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) { // This part should be dependent on 'i' and/or 'n'
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
