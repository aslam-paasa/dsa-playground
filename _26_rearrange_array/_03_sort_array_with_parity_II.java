package _26_rearrange_array;

import java.util.ArrayList;
import java.util.List;

public class _03_sort_array_with_parity_II {
    /**
     * Leetcode-922: Sort Array By Parity II
     * You're given an array of even length n, with:
     * a. Half the elements are even
     * b. Half the elements are odd
     * 
     * Goal: Reorder the array so that:
     * a. Even indices have even numbers
     * b. Odd indices have odd numbers
     * 
     * Input : [4, 2, 5, 7]
     * Output: [4, 5, 2, 7]
    */


    /**
     * Approach-1: Brute Force
     * 1. Create two separate arrays:
     *    a. evenList -> Stores even numbers
     *    b. oddList  -> Stores odd numbers
     * 2. Fill original array back:
     *    a. even index -> from evenList
     *    b. odd index  -> from oddList
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
    */

    public int[] sortArrayByParityIIBruteForce(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) even.add(num);
            else odd.add(num);
        }

        int i = 0, e = 0, o = 0;
        while (i < nums.length) {
            if (i % 2 == 0) nums[i++] = even.get(e++);
            else nums[i++] = odd.get(o++);
        }

        return nums;
    }


    /**
     * Approach-2: Two Pointers
     * 1. Use two pointers:
     *    a. evenIndex = 0
     *    b. oddIndex = 1
     * 2. Loop through array:
     *    a. If nums[evenIndex] % 2 != 0 -> it's wrong!
     *       - Swap with nums[oddIndex]
     *       - oddIndex += 2
     *    b. Else: evenIndex += 2
     * 
     * TC: O(n)
     * SC: O(1) - In-Place
    */

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1;

        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 == 0) {
                even += 2;
            } else {
                // swap wrong even with correct odd
                while (nums[odd] % 2 != 0) {
                    odd += 2;
                }
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                even += 2;
                odd += 2;
            }
        }

        return nums;
    }
}
