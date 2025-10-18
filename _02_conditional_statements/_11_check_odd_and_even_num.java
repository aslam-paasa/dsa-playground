package _02_conditional_statements;

/**
 * Q. WAP to check if a number is even or odd.
*/
public class _11_check_odd_and_even_num {
    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 4;

        if (isEven(n)) {
            System.out.println(n + " is Even");
        } else {
            System.out.println(n + " is Odd");
        }
    }
}
