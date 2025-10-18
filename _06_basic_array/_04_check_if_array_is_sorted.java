package _06_basic_array;

import java.util.Scanner;

/**
 * Check if the array is sorted:
 * Given an array arr of size n, the task is to check if the given
 * array is sorted in (ascending/increasing/non-decreasing). If
 * the array is sorted then return true, else return false.
 * 
 * Input : n = 5, arr = [1, 2, 3, 4, 5]
 * Output: true
 * 
 * Explanation: The given array is sorted i.e. Every element in the
 * array is smaller than or equals to its next values. So, the
 * answer is True.
 * 
 * Input : n = 5, arr = [5, 4, 6, 7, 8]
 * Output: false
 * 
 * Explanation: The given array is not sorted i.e. every element in
 * the array is not smaller than or equal to its next values. So,
 * the answer is false. Hence element 5 is not smaller than or
 * equal to its future elements.
*/


public class _04_check_if_array_is_sorted {
    /**
     * Approach-1:
     * 1. Start by focusing on the element at the first index. Compare
     *    this element with every subsequent element in the array. 
     * 2. If this element is greater than any of the following elements,
     *    the array is not sorted. 
     * 3. If the element is smaller than or equal to all subsequent
     *    elements, proceed to the next element. 
     * 4. Continue this process for every element in the array. If all 
     *    the elements are in proper order, the array can be said sorted.
     * 
     * Edge Cases:
     * - If the array has zero or one element (N = 0 or N = 1), it's 
     *   sorted. Return true.
     * 
     * TC: O(N^2)
     * SC: O(1)
    */

    public static boolean arraySortedOrNot(int[] arr, int n) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Approach-2:
     * 1. Start from the first element. Compare each element with the
     *    next element in the array. 
     * 2. If at any point the current element is greater than the next
     *    element, return False(the array is not sorted).
     * 3. If all comparisons are valid(the current element is less than
     *    or equal to the next element), continue to the next pair. 
     *    If the end of the array is reached without finding any
     *    out-of-order elements, return True. 
    */

    public static boolean arraySortedOrNot2(int[] arr, int n) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
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

        System.out.println("Array is sorted: " + arraySortedOrNot(arr, n));
        System.out.println("Array is sorted: " + arraySortedOrNot2(arr, n));
        scn.close();
    }
}
