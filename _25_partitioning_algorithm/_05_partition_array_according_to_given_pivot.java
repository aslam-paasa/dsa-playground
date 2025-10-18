package _25_partitioning_algorithm;

import java.util.ArrayList;
import java.util.List;

public class _05_partition_array_according_to_given_pivot {
    /**
     * Leetcode-2161: Partition Array According to Given Pivot
     * Given an integer array nums and an integer pivot, 
     * Rearrange nums into a new array so that:
     * 1. All elements less than pivot come first
     * 2. All elements equal to pivot come next
     * 3. All elements greater than pivot come last,
     *    and we must maintain the original relative order within each groups.
     * 
     * Input : nums = [9, 12, 5, 10, 14, 3, 10], pivot = 10
     * Output: nums = [9, 5, 3, 10, 10, 12, 14]
     * 
     * Note: Order should be preserved, i.e., 
     *       a. Maintain the original order of elements < pivot
     *       b. Maintain the original order of elements > pivot
     *       c. No need to maintain the order of elements == pivot
     * 
     * Explanation:
     * -> Elements < 10: [9, 5, 3]
     * -> Elements = 10: [10, 10]
     * -> Elements > 10: [12, 14]
     * 
     * Note: This is DNF with a custom pivot
    */

    /**
     * Approach-1: Brute Force
     * 1. Just create three separate arrays:
     *    a. One for < pivot
     *    b. One for == pivot
     *    c. One for > pivot
     * 2. Combine them in order
     * 
     * Steps:
     * 1. Create 3 ArrayList<Integer>
     *    a. left for < pivot
     *    b. middle for == pivot
     *    c. right for > pivot
     * 2. Loop through nums:
     *    Add to left, equal or right based on comparison
     * 3. Merge them to form the final array
     * 
     * TC: O(n)
     * SC: O(n)
     */

     public int[] pivotArrayBruteForce(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) left.add(num);
            else if (num == pivot) equal.add(num);
            else right.add(num);
        }

        int[] result = new int[nums.length];
        int index = 0;

        for (int n : left) result[index++] = n;
        for (int n : equal) result[index++] = n;
        for (int n : right) result[index++] = n;

        return result;
    }


    /**
     * Approach-2: Avoid storing equal groups
     * 1. Same concept as Brute Force, but don't store equal[] separately.
     * 2. Instead, just count how many times pivot appears.
     * 3. Saves a bit of memory compared to 3 full lists. 
     * 
     * Steps:
     * 1. Create 2 lists: less, greater
     * 2. Keep an equalCount variable
     * 3. Loop through:
     *    a. < pivot  :  less list
     *    b. == pivot :  increment count
     *    c. > pivot  :  greater list
     * 4. Final array = less + (count x pivot) + greater
     * 
     * TC: O(n)
     * SC: O(n)
    */

    public int[] pivotArrayAvoidStoringEqualGroups(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int equalCount = 0;

        for (int num : nums) {
            if (num < pivot) less.add(num);
            else if (num == pivot) equalCount++;
            else greater.add(num);
        }

        int[] result = new int[nums.length];
        int index = 0;

        for (int num : less) result[index++] = num;
        while (equalCount-- > 0) result[index++] = pivot;
        for (int num : greater) result[index++] = num;

        return result;
    }


    /**
     * Approach-3: Single array, pointer filling
     * 1. Instead of 3 lists, use a result array and fill it directly
     * 2. Use two passes:
     *    a. First : fill < pivot
     *    b. Second: fill == pivot
     *    c. Third : fill > pivot
     * 3. This saves some memory since we avoid using 3 dynamic lists
     * 
     * Steps:
     * 1. Create a result array
     * 2. First loop : add < pivot
     * 3. Second loop: add == pivot
     * 4. Third loop : add > pivot
    */

    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;

        // First pass: add elements less than pivot
        for (int num : nums)
            if (num < pivot) result[index++] = num;

        // Second pass: add elements equal to pivot
        for (int num : nums)
            if (num == pivot) result[index++] = num;

        // Third pass: add elements greater than pivot
        for (int num : nums)
            if (num > pivot) result[index++] = num;

        return result;
    }
}
