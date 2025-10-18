package _14_prefix_sum_with_conditional_logic;

/**
 * Leetcode-985: Sum of Even Numbers After Queries
 * You are given an integer array nums and a 2D array queris where
 * each query has two values:
 * - queries[i] = [val, index]
 * 
 * For each query:
 * 1. Add the value val to nums[index].
 * 2. Find the sum of all even numbers in the updated num array.
 * 
 * Return an array where ith element is the result of ith query.
 * 
 * - Input : nums = [1, 2, 3, 4], queries = [[1, 0], [-3, 1], [-4, 0], [2, 3]]
 * - Output: [8, 6, 2, 4]
 * - Explanation:
 *   1. Add  1 to nums[0] => [2, 2, 3, 4],   Even Sum =  2 + 2 + 4 = 8
 *   2. Add -3 to nums[1] => [2, -1, 3, 4],  Even Sum =  2 + 4     = 6
 *   3. Add -4 to nums[0] => [-2, -1, 3, 4], Even Sum = -2 + 4     = 2
 *   4. Add  2 to nums[3] => [-2, -1, 3, 6], Even Sum = -2 + 6     = 4
 *
 */

public class _01_sum_of_even_num_after_queries {

    /**
     * Approach-1: Brute Force
     * 1. Create an empty result list to store the answer for each
     *    query. 
     * 2. For each query:
     *    a. Update teh value of nums[index] by adding val. 
     *    b. Calculate the sum of all even numbers in the nums array.
     *    c. Store this even sum in the result list. 
     * 3. Return the result list. 
     * 
     * TC: O(Q x N) => For each query O(Q), you update a value O(1)
     *                 and recalculate the sum of even numbers O(N).
     * SC: O(Q)     => For the output array.
    */

    public int[] sumEvenAfterQueriesI(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            /**
             * a. Update the value at the index
            */
            nums[index] += val;
            
            /**
             * b. Calculate the sum of even numbers
             */
            int evenSum = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    evenSum += num;
                }
            }
            /**
             * c. Store the result
            */
            result[i] = evenSum;  
        }
        return result;
    }


    /**
     * Approach-2: Better Approach
     * 1. Calculate the initial sum of even numbers in the nums array.
     * 2. For each query:
     *    a. If the current nums[index] is even, subtract it from the
     *       even sum. 
     *    b. Update nums[index] by adding val. 
     *    c. If the new nums[index] is even, add it to the even sum. 
     * 3. Store the even sum in this result. 
     * 
     * TC: O(Q + N) => Initial sum takes O(N), and for each query O(1)
     * SC: O(Q) => O(Q) for the result array.  
    */

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int evenSum = 0;

        /**
         * 1. Calculate the initial sum of even numbers
         */
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }

        /**
         * 2. Process each query
        */
        for (int i = 0; i < n; i++) {
            int val = queries[i][0];
            int index = queries[i][1];

            /**
             * a. If the current value at index is even, subtract it from evenSum
            */
            if (nums[index] % 2 == 0) {
                evenSum -= nums[index];
            }

            /**
             * b. Update the value at the index
             */
            nums[index] += val;

            /**
             * c. If the updated value is even, add it to evenSum
             */
            if (nums[index] % 2 == 0) {
                evenSum += nums[index];
            }

            /**
             * d. Store the current evenSum
             */
            result[i] = evenSum;
        }

        return result;
    }
}
