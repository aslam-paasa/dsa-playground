package _26_rearrange_array;

import java.util.PriorityQueue;
import java.util.Arrays;

public class _07_wiggle_sort_II {
    /**
     * Leetcode-324: Wiggle Sort II
     * Rearrange the array such that:
     * a. nums[0] < nums[1] > nums[2] < nums[3] ...
     * b. Odd indices are greater than their even indices
     * c. No two adjacent elements are equal in final positions
     *    (not if all are same)
     * 
     * Input : [1, 5, 1, 1, 6, 4]
     * Output: [1, 6, 1, 5, 1, 4]
     * 
     * Note: Do it in O(n) time and O(1) space
    */

    /**
     * Approach-1: Brute Force
     * 1. Sort the array
     * 2. Create a new array
     * 3. Fill alternatively: small, large, small, large
     * 
     * Steps:
     * 1. Sort the array
     * 2. Fill smaller half at even indices
     * 3. Fill larger half at odd indices
     * 4. Return result
     * 
     * TC: O(n log n)
     * SC: O(n) - Extra Space
     * 
     * Note: This is a variant of partitioning:
    */

    public void wiggleSortBruteForce(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;
        int j = n - 1;

        // Fill odd positions first with large elements
        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[j--];
        }

        // Then fill even positions with remaining small elements
        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[j--];
        }
    }


    /**
     * Approach-2: Sort + Interleave from ends
     * 1. Sort the array
     * 2. Split into two halves
     * 3. Interleave:
     *    a. Max of first half -> even index
     *    b. Max of second half -> odd index
    */



    /**
     * Approach-3: In-place Approach
     * 1. QuickSelect to find median in O(n)
     * 2. Index mapping (virtual index trick)
     * 3. 3-way partitioning (DNF) using the median
     * 
     * Steps:
     * 1. Find the median of array using QuickSelect
     * 2. Virtual indexing to simulate new order (avoid overwrite):
     *    - Use (1 + 2 * i) % (n | 1) to remap index
     * 3. 3-way partition:
     *    a. Element > median  : left
     *    b. Element == median : middle
     *    c. Element < median  : right
    */

    public void wiggleSortInPlace(int[] nums) {
        int n = nums.length;

        // 1. Find median using QuickSelect
        int median = findKthLargest(nums.clone(), (n + 1) / 2);

        // 2. 3-way partition with virtual indexing
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            int mapped = mappedIndex(i, n);
            int leftMapped = mappedIndex(left, n);
            int rightMapped = mappedIndex(right, n);

            if (nums[mapped] > median) {
                swap(nums, leftMapped, mapped);
                left++;
                i++;
            } else if (nums[mapped] < median) {
                swap(nums, mapped, rightMapped);
                right--;
            } else {
                i++;
            }
        }
    }

    private int mappedIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
