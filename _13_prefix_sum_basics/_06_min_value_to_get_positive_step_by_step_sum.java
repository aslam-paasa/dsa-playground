package _13_prefix_sum_basics;

/**
 * Leetcode-1413: Minimum Value to Get Positive Step by Step Sum
 * Given an integer array nums, you need to find the minimum
 * positive integer startValue such that when we calculate the
 * step-by-step sum of nums, the sum is always greater than or
 * equal to 1.
 * 
 * - Input : nums = [-3, 2, -3, 4, 2]
 * - Output: 5
 * - Explanation:
 *   1. If we start with startValue = 5:
 *      - Step-1: 5 + (-3) = 2
 *      - Step 2: 2 + 2 = 4
 *      - Step 3: 4 + (-3) = 1
 *      - Step 4: 1 + 4 = 5
 *      - Step 5: 5 + 2 = 7
 *      Since all sums >= 1, startValue = 5 is the minimum valid
 *      staring value. 
*/

public class _06_min_value_to_get_positive_step_by_step_sum {
    /**
     * Approach-1: Brute Force (Try all possible start values)
     * 1. Initialize startValue = 1
     * 2. Loop through the nums array:
     *    a. Calculate the step-by-step sum. 
     *    b. If any sum is less than 1, increase startValue by 1.
     * 3. Repeat until you find a valid startValue. 
     * 
     * TC: O(n x maxValue) => In the worst case, we check all start
     *                        values up to the maximum negative sum
     * SC: O(1) 
    */

    public static int minStartValueI(int[] nums) {
        int startValue = 1;
        
        while (true) {
            int sum = startValue;
            boolean isValid = true;
            
            for (int num : nums) {
                sum += num;
                if (sum < 1) {
                    isValid = false;
                    break;
                }
            }
            
            /**
             * Valid value mil gaya:
            */
            if (isValid) return startValue;
            startValue++;
        }
    }


    /**
     * Approach-2: Minimum Prefix Sum Calculation
     * 1. Initialize sum = 0 and minSum = 0
     * 2. Traverse through the nums array:
     *    a. Add each element to sum
     *    b. Update minSum to keep track of the smallest sum during
     *       traversal
     * 3. Return 1 - minSum(ensuring the sum never fails below 1).
     * 
     * TC: O(n) => Single pass through the array
     * SC: O(1)
    */

    public static int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;

        for (int num : nums) {
            sum += num;  
            minSum = Math.min(minSum, sum);  // Smallest sum ko track karo
        }

        /**
         * Ensure sum is always >= 1:
        */
        return 1 - minSum;
    }

}
