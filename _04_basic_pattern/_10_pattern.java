package _04_basic_pattern;

import java.util.Scanner;

public class _10_pattern {
    public static void main(String[] args) {

        // N = 5
        // * #i=0, col=1
        // * * #i=1, col=2
        // * * * #i=2, col=3
        // * * * * #i=3, col=4
        // * * * * * #i=4, col=5
        // * * * * #i=5, col=4
        // * * * #i=6, col=3
        // * * #i=7, col=2
        // * #i=8, col=1

        // i < n => j = i+1
        // i >= n => 2*n-i-1

        // n i j
        // ----------
        // 5 5 4
        // 5 6 3
        // 5 7 2
        // 5 8 1

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = scn.nextInt();

        System.out.println();

        System.out.println("Here is your pattern: ");

    }
}
