package _26_rearrange_array;

import java.util.ArrayList;
import java.util.List;

public class _04_rearrange_array_elements_by_sign {
    /**
     * Leetcode-2149: Rearrange Array Elements by Sign
     * Given an array nums where:
     * a. Length is even
     * b. half is positive, half is negative
     * 
     * Return an array where:
     * a. Positive numbers go at even indices
     * b. Negative numbers go at odd indices
     * c. But preserve the relative order of positive and negative elements
     * 
     * Input : [3, 1, -2, -5, 2, -4]
     * Output: [3, -2, 1, -5, 2, -4]
    */

    /**
     * Approach-1: Brute Force
     * 1. Create two separate lists:
     *    a. positives[]
     *    b. negatives[]
     * 2. Alternative inserting from both lists into a result array
     * 
     * Steps:
     * 1. Loop over input - fill two lists
     * 2. Use one loop to alternate inserting:
     *    a. positive at even indices
     *    b. negative at odd indices
     * 3. Return result
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
    */

    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[nums.length];
        int i = 0, p = 0, n = 0;

        while (i < nums.length) {
            result[i++] = pos.get(p++);
            result[i++] = neg.get(n++);
        }

        return result;
    }


    /**
     * Approach-2: Two Pointers
     * 1. Create a result array
     * 2. Use two index pointers:
     *    a. posIndex = 0 (even)
     *    b. negIndex = 1 (odd)
     * 3. Loop over input and place elements in correct positions
     * 
     * Step-1:
     * 1. Initialize posIndex = 0, negIndex = 1
     * 2. Loop over nums:
     *    a. If positive:
     *       - result[posIndex] = num
     *       - posIndex += 2
     *    b. If negative:
     *       - result[negIndex] = num
     *       - negIndex += 2
     * 3. Return result
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space
     * 
     * 
     * Note: This is a variant of partitioning:
     * a. Put elements < pivot left : Put +ve at even, -ve at odd
     * b. Use swapping              : Uses position-based placing
    */

    public int[] rearrangeArrayTwoPointers(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0, negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }   
}
