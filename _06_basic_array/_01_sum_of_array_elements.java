package _06_basic_array;

import java.util.Scanner;

/**
 * Sum Of Array Elements:
 * - The sum of array, begin by initializing the sum to zero,
 *   representing the starting point with no accumulated value.
 * - Then sequentially add each element of the array to this sum.
 * - This approach ensures that, by the end of the process, the
 *   sum reflects the total value of all elements in the array. 
*/

/**
 * Approach:
 * 1. Initialize a variable sum to 0. This variable will hold the
 *    total sum of the array elements. 
 * 2. Iterate through each element in the array using a loop.
 *    For each element, add it to the sum variable. 
 * 3. After the loop ends, the sum variable will contain the total
 *    sum of all the elements in the array. 
 * 
 * Initalization:
 * 1.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *            i
 * 
 *     sum = 0 
 * 
 * 2. Iterate over all the array elements
 * 
 *     idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *               i
 *     sum = sum + arr[i] = 1
 * 
 * Pass-1: Add the current element to sum, and increase the value
 *         of i.
 * 
 * 3.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                  i
 *     sum = sum + arr[i] = 3
 * 
 * Pass-2: Again add the current element to sum, and increase the
 *         value of i. 
 * 
 * 4.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                     i
 *     sum = sum + arr[i] = 6
 * 
 * Pass-3: Again add the current element to sum, and increase the
 *         value of i. 
 * 
 * 5.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                        i
 *     sum = sum + arr[i] = 10
 * 
 * Pass-4: Again add the current element to sum, and increase the
 *         value of i. 
 * 
 * 5.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                           i
 *     sum = sum + arr[i] = 15
 * 
 * Pass-5: Again add the current element to sum, and increase the 
 *         value of i. 
 * 
 * 6. Sum = 15 ['i' has exceeded the array, so we stop the iterations
 *              and return 'sum']
 * 
 * TC: O(N)
 * SC: O(1)
*/


public class _01_sum_of_array_elements {
    public static int sum(int[] arr, int n) {
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt(); 
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Sum of array elements: " + sum(arr, n));

        scn.close();
    }
}
