package _04_basic_pattern;

import java.util.Scanner;

/**
 * Pattern Problem Rules:
 * 1. Nested Loops
 * 2. Number of times the outer loop runs = no. of rows
 * 3. Number of times the inner loop runs = no. of columns
 * 4. Print the pattern inside inner loop
 * 5. Formulate the inner loop variable's limit(j) in term of outer loop
 * variable(i) and input(n), i.e. j = f(i,n)
 */

public class _08_pattern {
    public static void main(String[] args) {

        // N => 5

        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter you number: ");
        int n = scn.nextInt();

        System.out.println();

        System.out.println("Here is your pattern: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}
