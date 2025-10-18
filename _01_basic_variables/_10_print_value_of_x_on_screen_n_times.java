package _01_basic_variables;

/**
 * Function to print the value for X on the screen N-times:
 * a. Check if N is non-negative
 * b. Loop to print the value x, n-times
 *    - Print the value of x
 *    - Print the space b/w nums, but not after the last one
 *    - Move to the next line after printing
 * 
 * Note:
 * - Post Increment: a++ = first use then change the value
 * - Pre Increment : ++a = first change the value then use 
*/

public class _10_print_value_of_x_on_screen_n_times {
    public static void printX(int x, int n) {
        if(n < 0) {
            System.out.println("Invalid number of times");
        }

        for(int i = 0; i < n; ++i) {
            System.out.print(x);

            if(i < n-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
