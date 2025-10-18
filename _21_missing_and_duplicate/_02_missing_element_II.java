package _21_missing_and_duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode-448: Find all numbers disappeared in an array
 * Given an array nums of size n where elements are in the range
 * [1, n], some elements appear once, and some are missing. Return
 * all numbers that do not appear in the array. 
 * 
 * Input : nums = [4, 3, 2, 7, 8, 2, 3, 1]
 * Output: [5, 6]
*/

public class _02_missing_element_II {
    /**
     * Approach-1: Brute Force (Extra Array)
     * 1. Create a boolean array present[] of size n+1 to track which
     *    numbers exist in nums. 
     * 2. Iterate from 1 to n and add missing num to the result. 
     * 
     * TC: O(N) => Two passes : Marking + Finding Missing
     * SC: O(N) => Extra boolean array
    */

    public List<Integer> findDisappearedNumbersI(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();

        /**
         * 1. Mark numbers present in nums:
        */
        for (int num : nums) {
            present[num] = true;
        }

        /**
         * 2. Find missing numbers:
        */
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }


    /**
     * Approach-2: HashSet
     * 1. Store all nums in a HashSet
     * 2. Check for missing num from 1 to n. 
     * 
     * TC: O(N) => Traversing array + Checking Set
     * SC: O(N) => Store elements in HashSet
    */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        /**
         * 1. Store all numbers in HashSet
        */
        for (int num : nums) {
            set.add(num);
        }

        /**
         * 2. Find missing numbers
        */
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }


    /**
     * Approach-3: In-place Marking
     * Key Idea: Marking Elements as Nagative
     * 1. Since numbers are in range [1, n], use indexing to mark presence. 
     * 2. For each nums[i], mark nums[nums[i] - 1] as negative to indicate
     *    its presence. 
     * 3. Traverse the array again to find positive values, which indicate
     *    missing numbers. 
     * 
     * TC: O(N) => Two Passes: Marking + Finding
     * SC: O(1) 
    */

    public List<Integer> findDisappearedNumbersIII(int[] nums) {
        List<Integer> result = new ArrayList<>();

        /**
         * 1. Mark presence using negative values
        */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        /**
         * 2. Find missing numbers (positive values)
        */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
