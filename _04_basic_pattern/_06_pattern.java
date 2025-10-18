package _04_basic_pattern;

import java.util.Scanner;

public class _06_pattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = scn.nextInt();

        System.out.println("Here is your pattern: ");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i + 1; j++) { // This part should be dependent on 'i' and/or 'n'
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
    }
}
