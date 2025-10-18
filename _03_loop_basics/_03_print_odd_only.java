package _03_loop_basics;

/**
 * Q. WAP to print all odd numbers from 1 to n.
 *    (For-Loop)
 * 
 *    for (int i = 1; i <= n; i = i + 2) {
 *        System.out.println(i);
 *    }
 */
public class _03_print_odd_only {
    public static void main(String[] args) {
        int n = 20;
        for (int i = 1; i <= n; i = i + 2) {
            System.out.println(i);
        }

        // int x = 1;
        // while(x <= 100) {
        //     System.out.println(x);
        //     x = x+2;
        // }
    }
}
