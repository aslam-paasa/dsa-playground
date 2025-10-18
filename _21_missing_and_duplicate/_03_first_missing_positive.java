package _21_missing_and_duplicate;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Leetcode-41: First Missing Positive
 * Given an unsorted array nums, find the smallest missing positive
 * integer.
 * 
 * Input : nums = [3, 4, -1, 1]
 * Output: 2
*/

public class _03_first_missing_positive {
    /**
     * Approach-1: Brute Force (Sorting)
     * 1. Sort the array in ascending order.
     * 2. Start from 1 and check if it's present. 
     * 3. If not found, return the missing positive number. 
     * 
     * TC: O(N logN) 
     * SC: O(1)
    */

    public int firstMissingPositive(int[] nums) {

        /**
         * 1. Sort array:
        */
        Arrays.sort(nums);
        int smallest = 1;

        /**
         * 2. Find the first missing positive:
        */
        for (int num : nums) { 
            if (num == smallest) {
                smallest++;
            }
        }

        /**
         * 3. Return missing positive number:
        */
        return smallest;
    }


    /**
     * Approach-2: HashSet
     * 1. Store all numbers in a HashSet
     * 2. Iterate from 1 to n+1 and find the first missing number. 
     * 
     * TC: O(N) => Traversing Array + Checking Set
     * SC: O(N) => Uses HashSet
    */

    public int firstMissingPositiveII(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        /**
         * 1. Store all positive numbers in HashSet
        */
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        /**
         * 2. Find the first missing positive number
        */
        int smallest = 1;
        while (set.contains(smallest)) {
            smallest++;
        }

        return smallest;
    }


    /**
     * Approach-3: Cyclic Sort
     * 1. Place each number nums[i] at its correct idx (nums[i] - 1)
     *    using swap operations. 
     * 2. After placing elements, find the first idx where
     *    nums[i] != i+1
     * 
     * TC: O(n) => One Pass for sorting + One for finding missing
     * SC: O(1)
    */

    public int firstMissingPositiveIII(int[] nums) {
        int n = nums.length;

        /**
         * 1. Swap elements to their correct positions
        */
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;

            }
        }

        /**
         * 2. Find the first missing positive
        */
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        /**
         * If all are correct, return n + 1
        */
        return n + 1; 
    }


    /**
     * Approach-4: In-Place Marking
     * 1. Replace all nums <= 0 or > n with n+1.
     * 2. Use the indexing technique to mark numbers. 
     * 3. The first positive value in the modified array gives the
     *    missing number. 
    */

    public int firstMissingPositiveIV(int[] nums) {
        int n = nums.length;

        /**
         * Step 1: Ignore invalid numbers:
         * (a) negative
         * (b) zero
         * (c) greater than 'n'
         * Replace them with n+1
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        /**
         * Step 2: Marking numbers:
         * - If abs(nums[i]) is in range [1, n], mark its position
         *   by setting nums[val-1] negative.
         */
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);

            if (val <= n) {
                int idx = val - 1;

                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                }
            }
        }

        /**
         * 3. The first positive index + 1 is the missing number
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        /**
         * 4. If all numbers [1, n] are present, return n + 1
        */
        return n + 1;
    }
}
