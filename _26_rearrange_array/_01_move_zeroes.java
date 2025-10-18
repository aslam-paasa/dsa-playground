package _26_rearrange_array;

import java.util.ArrayList;
import java.util.List;

public class _01_move_zeroes {
    /**
     * Leetcode-283: Move Zeroes
     * Move all 0s in the array to the end while maintaining the relative
     * order of the non-zero elements.
     * 
     * Input : [0, 1, 0, 3, 12]
     * Output: [1, 3, 12, 0, 0]
     * 
     * Note: Order should be preserved, i.e., 
     *       a. Maintain the original order of non-zero elements
     *       b. All 0s should be moved to the end
     *       c. Must do in-place
    */

    /**
     * Approach-1: Brute Force
     * Create a new array or ArrayList:
     *  a. First copy all non-zero elements
     *  b. Then add required number of 0s
     * 
     * Steps:
     * 1. Traverse input array, add non-zero values to temp
     * 2. Add 0s until length matches original array
     * 3. Copy temp back into original array
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
    */

    public void moveZeroesBruteForce(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            if (num != 0) temp.add(num);
        }

        while (temp.size() < nums.length) {
            temp.add(0);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp.get(i);
        }
    }


    /**
     * Appproach-2: Overwrite + Fill Zeros
     * Overwrite the input array:
     * a. First pass - Move non-zeroes to the front
     * b. Keep idx of next position (k)
     * c. After first pass, fill the rest of the array with 0s
     * 
     * Steps:
     * 1. Create a variable k = 0
     * 2. Loop through array:
     *    If current is not 0, set nums[k++] = nums[i]
     * 3. After loop, fill remaining positions with 0.
     * 
     * TC: O(n)
     * SC: O(1) - In-Place
    */

    public void moveZeroesOverwriteAndFillZeros(int[] nums) {
        int k = 0; // index for placing non-zero

        // Step 1: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // Step 2: Fill remaining elements with zero
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }


    /**
     * Approach-3: Two Pointers + Swapping
     * Use two pointers to swap non-zero elements with 0s keeping order:
     * 1. left points to the position where the next non-zero should go
     * 2. right scans the array
     * 
     * Steps:
     * 1. Initialize left = 0
     * 2. Loop right from 0 to end:
     *    If nums[right] != 0:
     *    - swap(nums[left], nums[right])
     *    - left++
     * 
     * This way:
     * a. All non-zeros come to front
     * b. Zeroes move back naturally
     * 
     * TC: O(n)
     * SC: O(1) - In-Place
    */

    public void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
