package _21_missing_and_duplicate;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode-645: Set Mismatch
 * You are given an array nums[] of size N, where numbers are in
 * range [1, N].
 * 1. One number appears twice (duplicate).
 * 2. One number is missing from the range. 
 * 3. Find both numbers and return them as [duplicate, missing].
 * 
 * Input : nums = [1, 2, 2, 4]
 * Output: [2, 3]
 * Explanation:
 * - 2 appears twice
 * - 3 is missing
 * 
 * 
 * Constraints:
 * - 2 ≤ N ≤ 10^4
 * - 1 ≤ nums[i] ≤ N
 * - Allowed extra space? ✅ O(1)
 * - Runtime constraint?  ✅ O(N)
*/

public class _08_missing_and_repeating {
    /**
     * Approach-1: Brute Force (Sorting)
     * 1. Sort the array. 
     * 2. Check which number repeats (same as the prev one).
     * 3. Find missing number by checking if nums[i] != i+1. 
     * 
     * TC: O(N logN) => Sorting
     * SC: O(1)      => In-place sorting
     * 
     * Drawback: Sorting increases time complexity
    */

    public int[] findErrorNumsI(int[] nums) {
        Arrays.sort(nums);
        int duplicate = -1, missing = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }

        /**
         * If last element is missing:
        */
        if (nums[nums.length - 1] != nums.length) {
            missing = nums.length;
        }

        return new int[]{duplicate, missing};
    }


    /**
     * Approach-2: HashMap
     * 1. Use a HashMap to store frequencies. 
     * 2. Find the duplicate (count = 2) and missing (count = 0).
     * 
     * TC: O(N) => Single Loop to count & check
     * SC: O(N) => Uses HashMap
     * 
     * Drawback : Uses extra space
    */

    public int[] findErrorNumsII(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int duplicate = -1, missing = -1;

        /**
         * Count frequencies:
        */
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /**
         * Find duplicate & missing:
        */
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i) && map.get(i) == 2) {
                duplicate = i;
            } else if (!map.containsKey(i)) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }


    /**
     * Approach-3: Index Marking
     * 1. Modify nums[] in-place to track counts. 
     * 2. Convert values negative to mark seen numbers. 
     * 
     * Steps:
     * 1. Mark numbers:
     *    - If nums[Math.abs(nums[i]) - 1] > 0, make it negative.
     *    - If already negative → it's the duplicate.
     * 2. Find missing: 
     *    - The missing number will be the index + 1 that is still 
     *      positive.
     * 
     * TC: O(N) => Single Pass for marking & Checking
     * SC: O(1) => Modifies input array in place
     * 
     * Best Approach!
    */

    public int[] findErrorNumsIII(int[] nums) {
        int duplicate = -1, missing = -1;

        /**
         * Find the duplicate:
        */
        for (int i = 0; i < nums.length; i++) {

            int idx = Math.abs(nums[i]) - 1;
            
            if (nums[idx] < 0) {
                duplicate = Math.abs(nums[i]);
            } else {
                nums[idx] *= -1;
            }
        }

        /**
         * Find the missing number: 
        */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
