package _02_conditional_statements;

import java.util.Scanner;

/**
 * Q. WAP to check if a year is a leap year or not.
 *    (If-Else)
 * 
 *     a. Divisible by 400
 *        Or,
 *     b. Divisible by 4 and NOT divisble by 100
 *    
 *    2020 : Leap Year
 *    a. Divisible by 400 (False) 
 *    b. Divisible by 4 and NOT divisble by 100 (True)
 *    
 *    1900: Not Leap Year
 *    a. Divisible by 400 (False) 
 *    b. Divisible by 4 and NOT divisble by 100 (False) 
*/

public class _12_check_leap_year {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a year: ");
        int year = scn.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
    }
}
