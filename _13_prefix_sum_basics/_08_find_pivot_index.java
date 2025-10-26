package _13_prefix_sum_basics;

/**
 * Leetcode-724: Find Pivot Index
 * Given an array nums, find the pivot index.
 * - The pivot index is the index where the sum of all elements to
 *   the left is equal to the sum of all elements to the right.
 * - If no such index exists, return -1. 
 * - If there are multiple pivot indices, return the leftmost one.
 * 
 * - Input : nums = [1, 7, 3, 6, 5, 6]
 * - Output: 3
 * - Explanation:
 *   - Left side of the index 3  => 1 + 7 + 3 => 11
 *   - Right side of the index 3 => 5 + 6     => 11
*/

public class _08_find_pivot_index {
    /**
     * Approach-1: Brute Force (Check each index)
     * 1. Loop through each index from 0 to n-1
     * 2. For each index:
     *    a. Calculate the left sum(sum of elements before it). 
     *    b. Calculate the right sum(sum of elements after it).
     * 3. If left sum == right sum, return the index. 
     * 4. If no pivot is found, return -1. 
     * 
     * TC: O(n^2) => For each index, we calculate the left and right sums
     * SC: O(1)
    */

    public static int findPivotIndex(int[] nums) {
        int n = nums.length;

        /**
         * 1. Loop through each index:
         *    a. Calculate left sum
         *    b. Calculate right sum
         *    c. Check if left sum == right sum
        */
        for (int i = 0; i < n; i++) {
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        /**
         * 2. No pivot index found
        */
        return -1;
    }


    /**
     * Approach-2: Prefix Sum Arrays
     * 1. Calculate the total sum of the array
     * 2. Loop through each index:
     *    a. Left Sum  = Sum of elements before the index
     *    b. Right Sum = Total Sum - left sum - current element
     * 3. If left sum == right sum, return the index. 
     * 4. If no pivot is found, return -1. 
     * 
     * TC: O(n) => One pass to calculate total sum, another pass to
     *             find the pivot. 
     * SC: O(1)
    */

    public static int findPivotIndexII(int[] nums) {
        int totalSum = 0;

        /**
         * 1. Calculate total sum of the array
        */
        for (int num : nums) {
            totalSum += num; 
        }

        /**
         * 2. Loop through each index:
         *    - If left sum == right sum, return index
         *    - Update left sum
        */
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; 
            }
            leftSum += nums[i]; 
        }

        /**
         * 3. No pivot index found
        */
        return -1;
    }
}
