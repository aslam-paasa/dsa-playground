package _26_rearrange_array;

import java.util.ArrayList;
import java.util.List;

public class _02_sort_array_with_parity {
    /**
     * Leetcode-905: Sort Array By Parity
     * Given an integer array nums, move all even integers to the front,
     * followed by all odd integers.
     * 
     * Input : [3, 1, 2, 4]
     * Output: [2, 4, 3, 1]
     * 
     * Explanation:
     * -> Even numbers: [2, 4]
     * -> Odd numbers : [3, 1]
     * -> Any valid output with all evens first and all odds after is accepted.
     * 
     * Note:
     * 1. You can return any order, as long as:
     *    a. All evens come before all odds
     * 2. You do not need to maintain relative order of elements, means we can
     *    do unstable partitioning.
    */

    /**
     * Approach-1: Brute Force
     * 1. Use extra space and make two arrays:
     *    a. One for evens
     *    b. One for odds
     * 2. Merge both
     * 
     * Steps:
     * 1. Create evenList, oddList
     * 2. Loop over nums and fill both lists
     * 3. Combine both lists into result array
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
    */

    public int[] sortArrayByParityBruteForce(int[] nums) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) evens.add(num);
            else odds.add(num);
        }

        int[] result = new int[nums.length];
        int i = 0;
        for (int e : evens) result[i++] = e;
        for (int o : odds) result[i++] = o;

        return result;
    }


    /**
     * Approach-2: In-place using extra space
     * 1. Use a single result array
     * 2. Use one pointer for front, one for rear
     * 3. Fill evens from front, odds from back
     * 
     * Steps:
     * 1. Create result array
     * 2. Use: 
     *    a. start = 0
     *    b. end = nums.length - 1
     * 3. Loop through nums:
     *    a. If even -> result[start++] = num
     *    b. If odd  -> result[end--]   = num
     * 4. Return result
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
    */

    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[start++] = num;
            } else {
                result[end--] = num;
            }
        }

        return result;
    }


    /**
     * Approach-3: In-place partitioning
     * 1. Use two pointers:
     *    a. left = 0
     *    b. right = nums.length - 1
     * 2. If nums[left] is even, it's in the right place -> left++
     * 3. If it's odd, swap with nums[right] and move right--
     * 
     * This way, you partition the array into even and odd sections in-place.
     * 
     * Steps:
     * 1. Initialize left = 0, right = nums.length - 1
     * 2. While left < right:
     *    a. If nums[left] is even, left++
     *    b. Else: swap(nums[left], nums[right]) and right--
     * 3. Return nums
     * 
     * TC: O(n)
     * SC: O(1) - In-Place
    */

    public int[] sortArrayByParityTwoPointers(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else {
                // swap with right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        return nums;
    }   
}
