package _13_prefix_sum_basics;

/**
 * Leetcode-1480: Running Sum of 1d Array
 * Given an array nums, return an array runningSum where runningSum[i]
 * is the sum of the elements from nums[0] to nums[i].
 * 
 * Input : nums = [1, 2, 3, 4]
 * Output: [1, 3, 6, 10]
 * Explanation:
 * - runningSum[0] = 1
 * - runningSum[1] = 1 + 2 = 3
 * - runningSum[2] = 1 + 2 + 3 = 6
 * - runningSum[3] = 1 + 2 + 3 + 4 = 10
*/

public class _04_running_sum {
    /**
     * Approach-1: Brute Force (Nested Loops)
     * 1. Create a new array runningSum of the same size as nums. 
     * 2. For each index i in nums:
     *    a. Initialize a variable sum to 0. 
     *    b. Run a loop from 0 to i and add all the elements to sum.
     *    c. Store this sum in runningSum[i].
     * 3. Return the runningSum array.
     * 
     * TC: O(n^2) => For each element, we loop from 0 to i
     * SC: O(n)
    */

    public static int[] runningSumI(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];

        // Har index ke liye sum calculate karo
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 0 se i tak ka sum nikalo
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            runningSum[i] = sum; // Store karo runningSum mein
        }

        return runningSum;
    }


    /**
     * Approach-2: Prefix Sum
     * 1. Create a new array runningSum of the same size as nums. 
     * 2. Initialize runningSum[0] = nums[0] because the first sum is
     *    the first element itself. 
     * 3. Loop from 1 to n-1:
     *    a. Add the current element nums[i] to the previous sum
     *       (runningSum[i-1])
     *    b. Store this value in runningSum[i]. 
     * 4. Return the runningSum array. 
     * 
     * TC: O(n) => We traverse the array once
     * SC: O(n) => For storing the runningSum array. 
    */

    public static int[] runningSumII(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];

        // Pehla element wahi hoga
        runningSum[0] = nums[0];

        // Har element ko pichle ka sum add karke store karo
        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }


    /**
     * Approach-3: Prefix Sum In-Place Calculation
     * 1. Modify the input array itself to save space. 
     * 2. Start from index 1 because the first element is already 
     *    correct. 
     * 3. For each index i:
     *    - Update nums[i] as: nums[i] = nums[i] + nums[i-1] 
     * 4. Return the modified nums array. 
     * 
     * TC: O(n) => We traverse the array once
     * SC: O(1) 
    */

    public static int[] runningSumIII(int[] nums) {
        int n = nums.length;

        // In-place calculation
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1]; // Har element mein pichla sum add karo
        }

        return nums;
    }
}
