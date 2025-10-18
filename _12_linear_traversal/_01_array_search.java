package _12_linear_traversal;

import java.util.HashSet;

/**
 * GFG: Linear Search
 * Given an array arr[] and n elements and an integer x, find 
 * whether x exists in the array or not. 
 * 
 * Input : arr[] = {1, 3, 5, 7, 9}, x = 7
 * Output: 2 [7 is present at idx-2]
 * 
 * Input : arr[] = {2, 4, 6, 8}, x = 5
 * Output: -1 [5 is not present]
*/

public class _01_array_search {

    /**
     * Approach-1: Brute Force (Linear Search)
     * 1. Traverse the entire array and compare each element with x. 
     * 2. If found, return idx. 
     * 3. If not found, return -1. 
     * 
     * Steps:
     * 1. Loop through the array from idx 0 to n-1. 
     * 2. If arr[i] == x, return i. 
     * 3. If the loop ends without finding x, return -1. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Downside: Slow for large arrays.
    */

    public static int search(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i; // Found x, return index
        }
        return -1; // x not found
    }


    /**
     * Approach-2: Binary Search - Sorted Array
     * 1. If the array is sorted, we can apply Binary Search. 
     * 2. Divide the array into two halves and eliminate on half in
     *    each step. 
     * 
     * Steps:
     * 1. Set low = 0 and high = n-1.
     * 2. Find mid = (low + high) / 2.
     * 3. If arr[mid] == x, return mid.
     * 4. If x is smaller, search in the left half (high = mid - 1).
     * 5. If x is greater, search in the right half (low = mid + 1).
     * 6. If low > high, return -1.
     * 
     * TC: O(log N) => Reduces search space by half in each
     * SC: O(1)
     * 
     * Limitation:
     * - Works only for sorted arrays. 
     * - If the array is unsorted, we must sort it first O(n logn)
     *   sorting time. 
    */

    public static int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) return mid; // Element found
            
            if (arr[mid] < x) low = mid + 1; // Search in right half
            else high = mid - 1; // Search in left half
        }
        
        return -1; // Element not found
    }


    /**
     * Approach-3: Hashing - Unsorted Array 
     * 1. Use HashSet for fast lookups O(1) avg time. 
     * 2. Store all elements in a HashSet and check if x exists. 
     * 
     * Steps:
     * 1. Insert all elements into a HashSet. 
     * 2. Check if x exists using contains(). 
     * 
     * TC: O(N) => One pass to insert elements, one pass to check. 
     * SC: O(N) => HashSet stores all elements. 
     * 
     * Why is this useful? 
     * - Handles unsorted arrays efficiently. 
     * - Fast lookups using HashSet. 
    */

    public static boolean searchUsingHashSet(int arr[], int x) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) set.add(num); // Store all elements
        
        return set.contains(x); // Check if x exists
    }
}
