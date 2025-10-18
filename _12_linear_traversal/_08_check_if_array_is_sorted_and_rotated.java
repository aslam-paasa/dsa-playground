package _12_linear_traversal;

import java.util.Arrays;

/**
 * Leetcode-1752: Check if Array is Sorted and Rotated
 * Given an array nums, determine whether it is a sorted array that
 * has been rotated some number of times.
 * 
 * Conditions for a valid rotated array:
 * 1. Only one "drop" allowed - A drop is when nums[i] > nums[i+1]
 * 2. The array should still be sorted if rotated back :
 *    The last element can be smaller than the firstm but only
 *    once. 
*/

public class _08_check_if_array_is_sorted_and_rotated {

    /**
     * Approach-1: Brute Force
     * 1. Generate All Possible rotations of the array. 
     * 2. Check if any rotation is sorted in ascending order.
     * 3. If any rotated version is sorted, return true;
     *    otherwise, return false. 
     * 
     * TC: O(N logN + N^2) => O(N^2)
     *     - O(N logN) for sorting
     *     - O(N^2) for checking each rotation 
     * SC: O(N) => Extra space for the sorted array
     * 
     * Why is this slow?
     * - Checking every possible rotations makes it inefficient.
    */

    public boolean check(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // Get the sorted version of nums

        for (int i = 0; i < n; i++) {
            if (isRotation(nums, sorted, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRotation(int[] nums, int[] sorted, int shift) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[(i + shift) % n] != sorted[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Approach-2: Better Approach [Counting Drops]
     * 1. Count how many times nums[i] > nums[i+1] 
     *    (this is a "drop" in order)
     * 2. If the count is 0 (already sorted) or exactly 1 (one rotation),
     *    return true. 
     * 3. If there are more than 1 drop, return false.
     * 
     * TC: O(N) => Single loop to check "drops"
     * SC: O(1)
     * 
     * Why is this better?
     * - One pass solution instead of checking every rotation. 
    */

    public boolean checkII(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Count "drops" where nums[i] > nums[i+1]
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1; // Only one drop allowed
    }
}
