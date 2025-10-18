package _01_getting_started;

import java.util.Scanner;

public class _03_taking_input {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        /**
         * Scanner Input:
         * a. scn.nextInt()     - for integer input
         * b. scn.nextFloat()   - for float input
         * c. scn.nextDouble()  - for double input
         * d. scn.nextBoolean() - for boolean input
         * e. scn.nextLine()    - for string input (line by line)
         * f. scn.next()        - for string input (word by word)
        */
        System.out.print("Enter 1st number: ");
        int a = scn.nextInt(); // a = 60

        System.out.print("Enter 2nd number: ");
        int b = scn.nextInt(); // b = 40

        int c = a + b; // c = 60 + 40 => 100
        System.out.println("The sum of your numbers: " + c);
    }
}
