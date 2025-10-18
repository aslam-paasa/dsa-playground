package _13_prefix_sum_basics;

/**
 * GFG: Prefix Sum Array - Implementation
 * GIven an array arr[] of size n, implement prefix sum array such
 * that prefix[i] stores the sum of elements from index 0 to i. 
*/

public class _01_prefix_sum_array {
    /**
     * Approach-1: Brute Force (Repeat Summation)
     * - For every index i, calculate the sum of all elements from idx
     *   0 to i using a loop. 
     * - TC: O(N^2)
     * - SC: O(N)
    */

    public int[] prefixSumBrute(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
    
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            prefix[i] = sum;
        }
    
        return prefix;
    }

    
    /**
     * Approach-2: Better (Using Extra Variable with Array)
     * - We initialize the first value, and for every next index, we
     *   add current element to previous prefix value. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public int[] prefixSumBetter(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
    
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
    
        return prefix;
    }


    /**
     * Approach-3: Optimized (In-Place Prefix Sum)
     * - We modify the original array itself to store the prefix sums.
     * - Use this when modifying the original array is allowed. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public int[] prefixSumOptimizedInPlace(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        return arr;
    }
}
