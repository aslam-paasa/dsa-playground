package _06_basic_array;

import java.util.Scanner;

/**
 * Count of odd numbers in array:
 * Given an array of n elements. The task is to return the count
 * of the number of odd numbers in the array.
 * 
 * Input : n = 5, arr = [1, 2, 3, 4, 5]
 * Output: 3
 * 
 * Explanation: The three odd elements are {1, 3, 5}
*/

/**
 * Intuition:
 * A simple way to solve this problem is by traversing the whole
 * array and checking each element if it is odd. The count of the
 * odd numbers found will be the number.
*/

/**
 * Approach:
 * 1. Initialize a counter to zero to keep track of odd numbers.
 *    Initialize a for-loop to iterate through each element in the
 *    array. 
 * 2. For each element, check if it is odd by checking it divisibility
 *     by 2 and increment counter if odd. 
 * 3. After iterating through all elements, the counter will contain
 *    the total count of odd numbers.
 * 
 * Dry Run:
 * 1. Initialization
 *     idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *            i
 * 
 *     sum = 0 
 * 
 * 2.  Iterate over all the array element:
 *     idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *            i
 *     arr[i] % 2 = 1, i.e. odd     => count = 1
 *     
 * Pass-1: arr[i] is odd so increase count, and increase the value
 *         of i
 * 
 * 3.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *               i
 *     arr[i] % 2 = 0, i.e. even     => count = 1
 *     
 * Pass-2: arr[i] is even, so increase the value of i
 * 
 * 4.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                  i
 *     arr[i] % 2 = 1, i.e. odd      => count = 2
 *     
 * Pass-3: arr[i] is odd so increase count, and increase the value of i
 * 
 * 5.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                     i
 *     arr[i] % 2 = 0, i.e. even     => count = 2
 *     
 * Pass-4: arr[i] is even, so increase the value of i
 * 
 * 6.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                        i
 *     arr[i] % 2 = 1, i.e. odd     => count = 3
 *     
 * Pass-5: arr[i] is odd so increase the count, and increase the value of i
 * 
 * 7.  idx    0  1  2  3  4
 *     arr = [1, 2, 3, 4, 5]
 *                           i
 *     count = 3
 *     
 * => 'i' has exceeded the array, so we stop the iterations and
 *    return 'count'. 
 * 
 * TC: O(N)
 * SC: O(1)
*/


public class _02_count_of_odd_elements_in_array {
    public static int countOdd(int[] arr, int n) {
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Count of odd elements: " + countOdd(arr, n));
        scn.close();
    }
}
