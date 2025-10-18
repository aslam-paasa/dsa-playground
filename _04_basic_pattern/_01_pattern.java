package _04_basic_pattern;

/**
 * Pattern Problem Rules:
 * 1. Nested Loops
 * 2. Number of times the outer loop runs = no. of rows
 * 3. Number of times the inner loop runs = no. of columns
 * 4. Print the pattern inside inner loop
 * 5. Formulate the inner loop variable's limit(j) in term of outer loop variable(i) and input(n), i.e. j = f(i,n)
*/

public class _01_pattern {
    public static void main(String[] args) {
        /**
         * 00 01 02 03 -> i=0, j=0 to 3
         * 10 11 12 13 -> i=1, j=0 to 3
         * 20 21 22 23 -> i=2, j=0 to 3
         * 30 31 32 33 -> i=3, j=0 to 3
         */

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(i + "" + j + " ");
            }
            System.out.println();
        }
    }
}
