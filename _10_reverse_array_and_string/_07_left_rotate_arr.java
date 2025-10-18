package _10_reverse_array_and_string;

import java.util.Arrays;

/**
 * GFG: Rotate Array
 * Given an array and an integer n, rotate the array left by n positions.
 * 
 * Input : arr = [1, 2, 3, 4 , 5], n = 2
 * Output: [3, 4, 5, 1, 2]
*/

public class _07_left_rotate_arr {

    /**
     * Approach-1: Brute Force (Using Extra Array)
     * Create a new array and store elements in rotated order.
     *
     * Steps:
     * 1. Store elements from idx n to end in rotatedArray.
     * 2. Append the first n elements at the end.
     *
     * TC: O(n)
     * SC: O(n)
    */

    public static int[] rotateArray(int[] arr, int n) {
        int len = arr.length;
        int[] rotatedArray = new int[len];

        for (int i = 0; i < len; i++) {
            rotatedArray[i] = arr[(i + n) % len];
        }
        return rotatedArray;
    }

    /**
     * Approach-2: Using Array Shift in Place
     * Shift elements n times using a loop
     *
     * Steps:
     * 1. Store the first element separately.
     * 2. Shift remaining elements to the left.
     * 3. Place the stored element at the end.
     * 4. Repeat n times.
     *
     * TC: O(n^2)
     * SC: O(1)
    */

    public static void rotateArrayII(int[] arr, int n) {
        int len = arr.length;
        n = n % len; // Handle cases where n > length

        for (int i = 0; i < n; i++) {
            int temp = arr[0];
            for (int j = 0; j < len - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[len - 1] = temp;
        }
    }


    /**
     * Approach-3: Reverse Trick - In-place Rotation
     * Reverse the first n elements, then reverse the remaining elements,
     * and finally reverse the entire array. 
     * 
     * Steps:
     * 1. Reverse the first n elements. 
     * 2. Reverse the remaining elements.
     * 3. Reverse the entire array. 
    */

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateArrayIII(int[] arr, int n) {
        int len = arr.length;
        n = n % len; // Handle cases where n > length

        reverse(arr, 0, n - 1);
        reverse(arr, n, len - 1);
        reverse(arr, 0, len - 1);
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int n = 2;


        /**
         * Using Approach-1 (Extra Array):
        */
        int[] rotated1 = rotateArray(arr1, n);
        System.out.println("Approach 1: " + Arrays.toString(rotated1));


        /**
         * Using Approach-2 (In-place Shift)
        */
        int[] arr2 = {1, 2, 3, 4, 5};
        rotateArrayII(arr2, n);
        System.out.println("Approach 2: " + Arrays.toString(arr2));

        
        /**
         * Using Approach-3 (Reverse Trick)
        */
        int[] arr3 = {1, 2, 3, 4, 5}; 
        rotateArrayIII(arr3, n);
        System.out.println("Approach 3: " + Arrays.toString(arr3));
    }
}
