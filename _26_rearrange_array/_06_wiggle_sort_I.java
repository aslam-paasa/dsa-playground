package _26_rearrange_array;

import java.util.Arrays;

public class _06_wiggle_sort_I {
    /**
     * Leetcode-280: Wiggle Sort
     * Rearrange the array such that:
     * nums[0] <= nums[1] >= nums[2] <= nums[3] ...
     * This is called wiggle pattern - it looks like a wave.
     * 
     * Input : [3, 5, 2, 1, 6, 4]
     * Output: [3, 5, 1, 6, 2, 4]
     * Explanation:
     * - 3 <= 5
     * - 5 >= 1
     * - 1 <= 6
     * - 6 >= 2
    */


    /**
     * Approach-1: Brute Force
     * 1. Sort the array
     * 2. Then swap every adjacent pair starting from index 1
     * 
     * Steps:
     * 1. Sort the array
     * 2. Loop i = 1 to n-1 with step 2
     * 3. Swap i and i+1 (if in bounds)
     * 
     * TC: O(n log n)
     * SC: O(1)
    */

    public void wiggleSortBruteForce(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i += 2) {
            // Swap current with next
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }


    /**
     * Approach-2: Sort + Fill Alternate
     * 1. Sort the array
     * 2. Fill a new array:
     *    a. Even indices : fill with smaller half
     *    b. Odd indices  : fill with larger half
     * Requires extra space, but gives stable wave
     * 
     * Steps:
     * 1. Sort the array
     * 2. Use two pointers:
     *    a. small = mid
     *    b. large = end
     * 3. Alternate filling res[i]:
     *    a. even index -> nums[small--]
     *    b. odd index  -> nums[large--]
     * This builds wave-like placement (similar to wiggle sort II prep)
    */

    public void wiggleSortSortAndFillAlternate(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] res = new int[n];

        int small = (n - 1) / 2;
        int large = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[small--];
            } else {
                res[i] = nums[large--];
            }
        }
    }


    /**
     * Approach-3: Single Pass Greedy Swap
     * 1. Walk the array one index at a time
     *    a. At even idx: ensure nums[i] <= nums[i+1]
     *    b. At odd idx: ensure nums[i] >= nums[i+1]
     * 2. If condition not met - swap
     * 
     * Steps:
     * 1. Loop i from 0 to n-2
     * 2. For:
     *    a. i % 2 == 0 -> check: nums[i] <= nums[i+1]
     *    b. i % 2 != 0 -> check: nums[i] >= nums[i+1]
     * 3. If condition not met - swap
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // Check position and condition
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) ||
                (i % 2 == 1 && nums[i] < nums[i + 1])) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
