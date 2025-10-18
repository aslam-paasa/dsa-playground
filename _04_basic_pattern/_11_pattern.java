package _04_basic_pattern;

import java.util.Scanner;

public class _11_pattern {
    public static void main(String[] args) {
        // Square Pattern
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i==0 || i==n-1 || j==0 || j==n-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
