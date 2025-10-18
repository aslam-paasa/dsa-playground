package _21_missing_and_duplicate;

import java.util.HashMap;

/**
 * GFG: Maximum Repeating Number
 * Given an array arr[] of size N, where elements are in range[0, K],
 * find the number that repeats the most. If multiple numbers have the
 * same freq, return the smallest one. 
 * 
 * Input : arr[] = {2, 3, 3, 5, 3, 4, 1, 7}, K = 7  
 * Output: 3
 * Explanation:
 * - 3 appears 3-times, which is maximum. 
 * 
 * Constraints:
 * 1. 1 ≤ N ≤ 10^5
 * 2. 0 ≤ arr[i] ≤ K
 * 3. Allowed extra space? ✅ O(1)
 * 4. Runtime constraint?  ✅ O(N)
*/

public class _07_maximum_repeating_element {
    /**
     * Approach-1: Brute Force (Nested Loops)
     * 1. Count frequency of each element using nested loops. 
     * 2. Return the element and maximum frequency. 
     * 
     * TC: O(N^2) => Nested loop for comparisons
     * SC: O(1)
     * 
     * Drawback: Too slow for large inputs
    */

    public int maxRepeatingI(int[] arr, int K) {
        int maxCount = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count > maxCount || (count == maxCount && arr[i] < result)) {
                maxCount = count;
                result = arr[i];
            }
        }

        return result;
    }


    /**
     * Approach-2: Using HashMap
     * 1. Store frequency of each element in a HashMap. 
     * 2. Return the element with max freq. 
     * 
     * TC: O(N) => Single loop for counting
     * SC: O(N) => Uses HashMap to store frequencies
     * 
     * Drawback: Uses O(K) extra space
    */

    public int maxRepeatingII(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int result = 0;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > maxCount || (map.get(num) == maxCount && num < result)) {
                maxCount = map.get(num);
                result = num;
            }
        }

        return result;
    }


    /**
     * Approach-3: Index Marking
     * 1. Since elements are in range [0, k], we can mark counts directly
     *    in arr[].
     * 2. Instead of using extra space, modify arr[] itself by increasing
     *    values at indexes. 
     * 
     * Steps:
     * 1. Increase frequency count directly:
     *    => arr[arr[i] % (K + 1)] += (K + 1)
     * 2. Find the max element by checking: 
     *    => arr[i] / (K + 1).
     * 3. Restore the original array if needed. 
     * 
     * TC: O(N) => Single Pass for marking & Checking
     * SC: O(1) => Modifies input array in place
     * 
     * Best Approach
    */

    public int maxRepeatingIII(int[] arr, int K) {
        int n = arr.length;

        /**
         * 1. Increase frequencies directly in the array
        */
        for (int i = 0; i < n; i++) {
            arr[arr[i] % (K + 1)] += (K + 1);
        }

        /**
         * 2. Find the maximum repeating number
        */
        int maxCount = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] / (K + 1) > maxCount) {
                maxCount = arr[i] / (K + 1);
                result = i;
            }
        }

        /**
         * 3. (Optional): Restore the original array
        */
        for (int i = 0; i < n; i++) {
            arr[i] %= (K + 1);
        }

        return result;
    }
}
