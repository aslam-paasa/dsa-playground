package _06_basic_array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * GFG: Reverse an Array
 * Input : [1, 2, 3, 4, 5]
 * Output: [5, 4, 3, 2, 1]
*/

public class _03_reverse_array {
    /**
     * Approach-1: Brute Force (Using Extra Array)
     * Create a new array and store elements in reverse order.
     * 
     * Steps:
     * 1. Create an empty array reversedArray.
     * 2. Iterate arr from the last idx to the first.
     * 3. Copy elements into reversedArray.
     * 
     * TC: O(n)
     * SC: O(n)
    */
    
    public static int[] reverseArrayI(int[] arr) {
        int n = arr.length;
        int[] reversedArray = new int[n];

        for (int i = 0; i < n; i++) {
            reversedArray[i] = arr[n - 1 - i];
        }
        return reversedArray;
    }

    /**
     * Approach-2: Using Two Pointer In-Place Swap
     * Swap the first and last element, then the second and second-last,
     * and so on. 
     * 
     * Steps:
     * 1. Use two pointers: left at the start, right at the end.
     * 2. Swap arr[left] and arr[right]. 
     * 3. Move left forward and right backward. 
     * 4. Repeat until left < right. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static void reverseArrayII(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }


    /**
     * Approach-3: Recursion
     * Use recursion to swap elements at left and right indices. 
     * 
     * Steps:
     * 1. Base Case : If left >= right, stop recursion. 
     * 2. Swap arr[left] and arr[right]. 
     * 3. Recursively call revresedArray() with left+1 and right-1. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static void reverseArrayIII(int[] arr, int left, int right) {
        if (left >= right) return;

        // Swap elements
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArrayIII(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();

        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone(); 
        int[] arr3 = arr.clone();

        System.out.println("Approach-1: Brute Force (Using Extra Array) " + Arrays.toString(reverseArrayI(arr1)));
        
        reverseArrayII(arr2);
        System.out.println("Approach-2: Two Pointer In-Place Swap " + Arrays.toString(arr2));
        
        reverseArrayIII(arr3, 0, n - 1);
        System.out.println("Approach-3: Using Recursion " + Arrays.toString(arr3));
        
        scn.close();
    }
}
