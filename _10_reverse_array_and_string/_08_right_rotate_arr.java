package _10_reverse_array_and_string;

/**
 * Leetcode-189: Rotate Array
 * Store rotated elements in a new array and copy them back.
 * 
 * Steps:
 * 1. Create a new array rotatedArray.
 * 2. Put each element in its new position (i + k) % len. 
 * 3. Copy rotatedArray back to nums.
 * 
 * TC: O(N)
 * SC: O(N)
*/

public class _08_right_rotate_arr {

    public static void rotateI(int[] nums, int k) {
        int len = nums.length;
        int[] rotatedArray = new int[len];

        for (int i = 0; i < len; i++) {
            rotatedArray[(i + k) % len] = nums[i];
        }

        // Copy back to original array
        for (int i = 0; i < len; i++) {
            nums[i] = rotatedArray[i];
        }
    }


    /**
     * Approach-2: Using Cyclic Replacement
     * Swap elements directly in cyclic order using a counter. 
     * 
     * Steps:
     * 1. Start swapping in a cycle. 
     * 2. Keep a count of swapped elements to prevent re-swapping.
     * 3. If a cycle in complete, move to the next start index. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static void rotateII(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle k > len
        int count = 0;

        for (int start = 0; count < len; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    /**
     * Approach-3: Reverse Trick - In-place Rotation
     * Reverse the first n elements, then reverse first k elements,
     * then reverse remaining elements. 
     * 
     * Steps:
     * 1. Reverse entire array. 
     * 2. Reverse first k elements.
     * 3. Reverse remaining len - k elements. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateIII(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle cases where k > length

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
}
