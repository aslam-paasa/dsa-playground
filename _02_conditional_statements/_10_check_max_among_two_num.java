package _02_conditional_statements;

/**
 * Q. WAP to check the maximum among two numbers.
*/

public class _10_check_max_among_two_num {
    public static int max_Integer(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        System.out.println("Maximum among " + a + " and " + b + " is " + max_Integer(a, b));
    }
}
