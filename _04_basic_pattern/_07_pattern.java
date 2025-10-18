package _04_basic_pattern;

import java.util.Scanner;

/**
 * Pattern Problem Rules:
 * 1. Nested Loops
 * 2. Number of times the outer loop runs = no. of rows
 * 3. Number of times the inner loop runs = no. of columns
 * 4. Print the pattern inside inner loop
 * 5. Formulate the inner loop variable's limit(j) in term of outer loop variable(i) and input(n), i.e. j = f(i,n)
*/

public class _07_pattern {
    public static void main(String[] args) {

        // * * * * *  # i=0 -> col=5  (n-i = 5-0 = 5)
        // * * * *    # i=1 -> col=4  (n-i = 5-1 = 4)
        // * * *      # i=2 -> col=3  (n-i = 5-2 = 3)
        // * *        # i=3 -> col=2  (n-i = 5-3 = 2)
        // *          # i=4 -> col=1  (n-i = 5-4 = 1)

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter you number: ");
        int n = scn.nextInt();

        System.out.println();

        System.out.println("Here is your pattern: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
