package _21_missing_and_duplicate;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Leetcode-287: Find the Duplicate Number
 * Given an array nums containing n+1 integers where each integer
 * is between 1 and n(inclusive), find the duplicate number.
 * 
 * Input : nums = [3, 1, 3, 4, 2]
 * Output: 3 
 * 
 * Note:
 * - There is only one repeated number, but it can appear multiple
 *   times.
 * - Modify the array if needed? ❌ Not required
 * - Extra space allowed? ❌ Only O(1) extra space allowed
 * - Runtime constraint? ✅ Must run in O(n log n) or O(n)
*/

public class _04_repeating_element_I {
    /**
     * Approach-1: Brute Force (Sorting)
     * 1. Sort the array
     * 2. Traverse and find consecutive duplicate. 
     * 
     * TC: O(N logN)
     * SC: O(1)
     * 
     * Drawback: Modifies the input array
    */

    public int findDuplicateI(int[] nums) {
        Arrays.sort(nums);  

        /**
         * Check adjacent elements & Return first duplicate found
        */
        for (int i = 1; i < nums.length; i++) { 
            if (nums[i] == nums[i - 1]) {
                return nums[i]; 
            }
        }

        return -1; 
    }


    /**
     * Approach-2: HashSet
     * 1. Use a HashSet to store visited elements. 
     * 2. If an element is alreadt in the set, return it. 
     * 
     * TC: O(N) => Single Pass
     * SC: O(N) => Uses extra space for HashSet
     * 
     * Drawback: Uses O(N) extra space. 
    */

    public int findDuplicateII(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        /**
         * If already in the set, return duplicate:
        */
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1; 
    }


    /**
     * Approach-3: Positioning Method(Swapping)
     * 1. Place each number at its correct idx iteratively. 
     * 2. If a number is already present at the target idx, it's the
     *    duplicate. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Drawback: Modifies the input array
    */

    public int findDuplicateIII(int[] nums) {

        /**
         * 1. Save the target in nums variable
         * 2. Place the value at the correct idx
         * 3. Update the value at idx 0
        */
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]]; 
            nums[nums[0]] = nums[0];
            nums[0] = temp; 
        }

        return nums[0];
    }


    /**
     * Approach-4: Floyd's Cycle Detection (Floyd's Tortoise & Hare)
     * 1. This is a cycle detection problem (like Linked List cycle
     *    detection)
     * 2. Treat the array as a linked list where nums[i] is the next
     *    node. 
     * 3. Two Pointers move at different speeds (slow & fast).
     * 4. The meeting point inside the cycle gives the duplicate num. 
     * 
     * TC: O(N) => Fast pointer moves 2x speed, but still O(n)
     * SC: O(1)
     * 
     * No modification of input array
    */

    public int findDuplicateIV(int[] nums) {
        
        /**
         * 1. Detect cycle using slow & fast pointers
        */
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];       // Move 1 step
            fast = nums[nums[fast]]; // Move 2 steps
        } while (slow != fast);
        /**
         * 2. Find entry point of cycle (duplicate)
        */
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        /**
         * 3. Return the duplicate number
        */
        return slow;
    }
}
