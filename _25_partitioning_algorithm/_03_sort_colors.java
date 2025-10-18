package _25_partitioning_algorithm;

import java.util.Arrays;

public class _03_sort_colors {
    /**
     * Leetcode: 75. Sort Colors
     * Given an array nums with only 3 types of integers: 0, 1, 2.
     * Sort them in-place so all 0s come first, then 1s, then 2s.
     * 
     * Input : [2, 0, 2, 1, 1, 0]
     * Output: [0, 0, 1, 1, 2, 2]
     * 
     * Note: From this problem, we will learn:
     * a. How to group values using partitioning
     * b. Why paritioning helps even when not sorting all elements
     * c. Foundation of more advanced problems (3-way quicksort, etc.)
    */

    /**
     * Approach-1: Brute Force (Built-In Sort)
     * TC: O(nlogn)
     * SC: O(1)
    */

    public void sortColorsBruteForce(int[] nums) {
        Arrays.sort(nums);
    }


    /**
     * Approach-2: Counting Sort (2 Pass)
     * 1. Count the number of 0s, 1s, 2s
     * 2. Then overwrite array in order
     * 
     * Steps:
     * 1. Count number of 0s, 1s, 2s
     * 2. Overwrite array:
     *    a. First with 0s
     *    b. Then 1s
     *    c. Then 2s
     * 
     * TC: O(2n) = O(n)
     * SC: O(1)
    */

    public void sortColorsCountingSort(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int num : nums) {
            if (num == 0) zero++;
            else if (num == 1) one++;
            else two++;
        }

        int i = 0;
        while (zero-- > 0) nums[i++] = 0;
        while (one-- > 0) nums[i++] = 1;
        while (two-- > 0) nums[i++] = 2;
    }


    /**
     * Approach-3: Dutch National Flag Algorithm (3-way Partitioning or Three Pointer)
     * 1. Use 3 pointers:
     *    a. low  - boundary for 0s
     *    b. mid  - current idx
     *    c. high - boundary for 2s
     * 2. Partition array into:
     *    a. 0      -> low-1 = all 0s
     *    b. low    -> mid-1 = all 1s
     *    c. mid    -> high  = unknown
     *    d. high+1 -> end   = all 2s
     * 
     * Steps:
     * 1. Initialize: low = 0, mid = 0, high = n-1
     * 2. While mid <= high:
     *    a. If nums[mid] == 0:
     *       - swap(nums[low], nums[mid])
     *       - low++, mid++
     *    b. If nums[mid] == 1:
     *       - mid++
     *    c. If nums[mid] == 2:
     *       - swap(nums[mid], nums[high])
     *       - high--
     * 3. Done!
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public void sortColorsDutchNationalFlag(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
