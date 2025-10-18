package _02_conditional_statements;

/**
 * Q. WAP to find minimum of 3 numbers using Nested If-Else
 */

public class _04_min_of_three_num {
    public static void main(String[] args) {
        int a = 80, b = 90, c = 60;

        if (a < b) {
            if (a < c)
                System.out.println("A is smallest");
            else
                System.out.println("C is smallest");
        } else {
            if (b < c)
                System.out.println("B is smallest");
            else
                System.out.println("C is smallest");
        }
    }
}
