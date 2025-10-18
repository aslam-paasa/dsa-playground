package _12_linear_traversal;

import java.util.HashMap;

/**
 * GFG: Search an Element in an Array and Return First Occurrence
 * Given an array arr[] of n elements and an integer x, find the
 * first occurrence of x in the array. If x is not found, return -1.
 * 
 * Input : arr[] = {1, 3, 7, 3, 5}, x = 3 
 * Output: 1 [First Occur of 3 is at idx-1]
 * 
 * Input : arr[] = [2, 4, 6, 8], x = 5
 * Output: -1 [5 is not present]
*/

public class _02_first_occurrence {

    /**
     * Approach-1: Brute Force (Linear Search)
     * 1. Traverse the array from left to right
     * 2. Return the first idx where arr[i] == x.
     * 3. If xi is not found, return -1.
     * 
     * Steps:
     * 1. Start from idx-0 and iterate through the array.
     * 2. If arr[i] == x, return i. 
     * 3. If the loop ends without finding x, return -1. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Why this works?
     * - Handles unsorted arrays.
     * - Guaranteed to find the first occurrence.
    */

    public static int firstOccurrenceI(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i; 
        }
        return -1;
    }


    /**
     * Approach-2: Binary Search for Sorted Array
     * 1. If the array is sorted, we can use Binary Search to find
     *    the first occurrence. 
     * 2. Instead of stopping when we find x, we continue searching
     *    in the left half. 
     * 
     * Steps:
     * 1. Set:   low = 0, 
     *           high = n-1 and 
     *           firstIdx = -1.
     * 
     * 2. Find:  mid = (low + high) / 2
     * 
     * 3. If arr[mid] == x, store mid in the firstIdx and search
     *    left half (high = mid - 1)
     * 
     * 4. If arr[mid] < x, search in right half (low = mid + 1).
     * 
     * 5. If arr[mid] > x, search in left half (high = mid - 1). 
     * 
     * 6. Return firstIdx. 
     * 
     * TC: O(log n)
     * SC: O(1)
     * 
     * Why is this better?
     * - Works only if the array is sorted.
     * - Faster than linear search. [Best for single lookup]
    */

    public static int firstOccurrenceBinarySearchII(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        int firstIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                firstIndex = mid; 
                high = mid - 1; 
            } else if (arr[mid] < x) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        
        return firstIndex;
    }


    /**
     * Approach-3: HashMap for unsorted array - Multiple Queries
     * 1. Use a HashMap to store the first occurrence of every element. 
     * 2. If multiple queries are needed, lookup is O(1).
     * 
     * Steps:
     * 1. Traverse the array once, storing the first occurrence of each
     *    element in a HashMap. 
     * 2. If x exists in a HashMap, return its idx. 
     * 3. If x is not in the HashMap, return -1. 
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * Why is this useful?
     * - Handles unsorted arrays efficiently. 
     * - Fastest for multiple lookups. [Best for multiple queries] 
    */

    public static int firstOccurrenceUsingHashMapIII(int arr[], int x) {
        HashMap<Integer, Integer> firstIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!firstIndexMap.containsKey(arr[i])) {
                firstIndexMap.put(arr[i], i); // Store first occurrence
            }
        }

        return firstIndexMap.getOrDefault(x, -1);
    }
}
