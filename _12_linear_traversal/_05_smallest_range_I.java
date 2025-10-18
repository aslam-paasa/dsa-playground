package _12_linear_traversal;

/**
 * Leetcode-908: Smallest Range I
 * Given an integer array nums and an integer k, modify each element
 * by adding or subtracting any value in [0, k]. Return the min
 * possible difference b/w the max and min elements after modification.
**/

public class _05_smallest_range_I {

    /**
     * Approach-1: Brute Force 
     * 1. Generate all possible values for each number in nums by adding
     *    or subtracting any value from 0 to k. 
     * 2. Create all possible arrays with these new values. 
     * 3. For each modified array, find the max and min values. 
     * 4. Compute the diff b/w max and min values. 
     * 5. Return the min diff found. 
     * 
     * TC: O(2^N x N) => Since we generate all possible subsets (2^N)
     *                   and find min-max for each O(N)
     * SC: O(1) 
     * 
     * Why this is slow?
     * - It generates all possible modified arrays, which is inefficient
     *   for large nums arrays. 
    */

    public int smallestRangeIBruteForce(int[] nums, int k) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        // Generate all possible modified arrays
        for (int mask = 0; mask < (int) Math.pow(2, n); mask++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                int newVal = (mask & (1 << i)) != 0 ? nums[i] + k : nums[i] - k;
                minVal = Math.min(minVal, newVal);
                maxVal = Math.max(maxVal, newVal);
            }

            minDiff = Math.min(minDiff, maxVal - minVal);
        }

        return minDiff;
    }


    /**
     * Approach-2: Better Solution
     * 1. Find the minVal and maxVal values in the original array. 
     * 2. Modifiy the range by adding k to minVal and subtracting k
     *    from maxVal. 
     * 3. Calculate the new possible difference:
     *    - newDiff = max(0, (maxVal - k) - (minVal + k))
     * 4. Return newDiff since we cannot have a nagative diff. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Why is this better?
     * - Instead of generating all possible arrays, we directly calculate
     *   the modified min and max values. 
    */

    public int smallestRangeIBetterSolution(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        // Find the min and max values in the array
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // Calculate minimized difference
        return Math.max(0, (maxVal - k) - (minVal + k));
    }

    /**
     * Approach-3: Optimal Solution
    */

    public static int smallestRangeIOptimal(int[] nums, int k) {
        int min=nums[0] , max= nums[0];

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]<min)  min = nums[i];

            if(nums[i]>max)  max = nums[i];
        }
        
        //finding the minimum and maximum 
        if((max-min)-(2*k)<=0 || max-min==0)
            return 0;
        else
            return (max-min)-(2*k);
    }
}
