package _12_linear_traversal;

/**
 * Leetcode-1588: Sum of All Odd Length Subarrays
 * Given an array arr of positive integers, return the sum of
 * all odd-length subarrays.
 * 
 * Input : arr = [1, 4, 2, 5, 3]
 * Output: 58
 * Explaination: The odd-length subarrays are:
 * - [1], [4], [2], [5], [3], [1,4,2], [4,2,5], [2,5,3], [1,4,2,5,3]
 * - Sum = 58
*/

public class _14_sum_of_all_odd_length_subarrays {

    /**
     * Approach-1: Brute Force (Generate All Odd-Length Subarrays)
     * 1. Use nested loops to generate all subarrays.
     * 2. The outer loop pick the starting idx (i).
     * 3. The inner loop pick the ending idx (j).
     * 4. Consider only subarrays with odd length ((j-i+1) % 2 == 1)
     * 5. Calculate their sum and add it to the total.
     * 
     * TC: O(N^3) => Three nested loops
     * SC: O(1)
     * 
     * Why is this slow?
     * - Generates and sum each subarray manually, making it inefficient.
    */

    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((j - i + 1) % 2 == 1) { // Check if length is odd
                    for (int k = i; k <= j; k++) {
                        totalSum += arr[k]; // Sum up elements in this subarray
                    }
                }
            }
        }

        return totalSum;
    }


    /**
     * Approach-2: Better Approach (Prefix Sum)
     * 1. Precompute prefix sum: prefixSum[i] stores the sum from
     *    arr[0] to arr[i].
     * 2. Use nested loops to generate all subarrays. 
     * 3. Check if subarray length is odd, then sum it using:
     *    => sum = prefixSum[j] − prefixSum[i−1]
     * 4. This avoids summin elements manually in each iteration. 
     * 
     * TC: O(N^2) => Two loops, but uses prefix sum for fast lookup.
     * SC: O(N)   => Stores prefix sums
     * 
     * Why is this better?
     * - Prefix sum avoids unnecessary reputed summation for subarrays.
    */

    public int sumOddLengthSubarraysII(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        int totalSum = 0;

        /**
         * 1. Compute prefix sum:
        */
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        /**
         * 2. Iterate over all odd-length subarrays:
         *    - Increment by 2 to get only odd lengths
        */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j += 2) { 
                totalSum += prefixSum[j + 1] - prefixSum[i];
            }
        }

        return totalSum;
    }


    /**
     * Approach-3: Direct Contribution Counting
     * 1. Each element arr[i] appears in multiple odd-length subarrays. 
     * 2. Count how many times arr[i] appears in such subarrays. 
     * 3. Contribution of arr[i] to total sum:
     *    => Total Occurrences = (left choices × right choices + 1) / 2
     * 4. Sum up the contributions
     * 
     * TC: O(N) 
     * SC: O(1)
     * 
     * Why is this the best approach?
     * - Avoids nested loops and unnecessary summations. 
    */

    public int sumOddLengthSubarraysIII(int[] arr) {
        int totalSum = 0;
        int n = arr.length;

        /**
         * 1. Number of elements before (including i)
         * 2. Number of elements after (including i)
         * 3. Odd count contribution
        */
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i; 
            int totalOccurrences = (left * right + 1) / 2;
            
            totalSum += arr[i] * totalOccurrences;
        }

        return totalSum;
    }
}
