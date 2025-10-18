package _12_linear_traversal;

/**
 * Leetcode-665: Non-Decreasing Array
 * Given an array nums[], check if you make it non-decreasing by
 * modifying at most one element. 
 * - A non-decreasing array means: nums[i] ≤ nums[i+1] for all valid 1.
 * - Return true if possible, otherwise return false.
*/

public class _17_non_decreasing_array {

    /**
     * Approach-1: Brute Force (Try Modifying Each Element)
     * 1. Iterate through the array and find the first violation where
     *    nums[i] > nums[i+1].
     * 2. Try modifying nums[i] to nums[i+1] and check if the array
     *    becomes non-decreasing.
     * 3. If not, try modifying nums[i+1] to nums[i] and check again.
     * 4. If either change works, return true, otherwise return false.
     * 
     * TC: O(N^2) => We check every element and create modified copies
     * SC: O(N)   => Uses extra space for cloned arrays.
     * 
     * Why is this slow?
     * - Nested loops and array cloning make it inefficient for large
     *   inputs.
    */

    public boolean checkPossibilityI(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int[] modified1 = nums.clone();
                modified1[i] = nums[i + 1];

                int[] modified2 = nums.clone();
                modified2[i + 1] = nums[i];

                return isNonDecreasingI(modified1) || isNonDecreasingI(modified2);
            }
        }

        return true;
    }

    private boolean isNonDecreasingI(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }


    /**
     * Approach-2: Count Violations
     * 1. Track how many times nums[i] > nums[i+1].
     * 2. If this happens more than once, return false.
     * 3. When nums[i] > nums[i+1]:
     *    - Modify nums[i] if i == 0 or nums[i-1] <= nums[i+1]. 
     *    - Otherwise, modify nums[i+1]. 
     * 4. Continue checking for other violations. 
     * 
     * TC: O(N) => Single pass through the array.
     * SC: O(1) 
     * 
     * Why is this better?
     * - No extra space needed and only a single loop is used.
    */

    public boolean checkPossibilityII(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;

                if (count > 1) return false;

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1]; // Modify nums[i]
                } else {
                    nums[i + 1] = nums[i]; // Modify nums[i+1]
                }
            }
        }

        return true;
    }
}
