package _03_loop_basics;

/**
 * Q. WAP to print all even numbers from 0 to n.
 *   (For-Loop)
 * 
 *    for (int i = 0; i <= n; i = i + 2) {
 *       System.out.println(i);
 *    }
 */
public class _02_print_even_only {
    public static void main(String[] args) {
        int n = 20;

        int i;
        for (i = 0; i <= n; i = i + 2) {
            System.out.println(i);
        }
        System.out.println(i); // i+2 = 22
    }
}
