package _21_missing_and_duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode-442: Find All Duplicates in an Array
 * Given an array of integers where 1 <= nums[i] <= n 
 * (where n is the array length), find all elements that appear
 * twice.
 * 
 * Input : nums = [4,3,2,7,8,2,3,1]
 * Output: [2, 3]
 * 
 * Constraints:
 * 1. Elements are in range [1, n]
 * 2. Duplicates appear exactly twice
 * 3. Extra space allowed? ✅ O(1) (Modifying input array is allowed)
 * 4. Runtime constraint?  ✅ O(N)
*/

public class _06_repeating_element_III {
    /**
     * Approach-1: Brute Force (Nested Loops)
     * - Pick each element and check if its appears again later in the 
     *   array.
     * 
     * TC: O(N^2) => Nested Loop for Comparisons
     * SC: O(1)
     * 
     * Drawback : Too slow for large arrays!
    */

    public List<Integer> findDuplicatesI(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && !duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                    break;
                }
            }
        }

        return duplicates;
    }


    /**
     * Approach-2: HashSet
     * 1. Use a HashSet to store visited elements. 
     * 2. If an element is already in the set, it's a duplicate. 
     * 
     * TC: O(N) => Single pass through the array
     * SC: O(N) => Uses extra space for HashSet
     * 
     * Drawback: Extra space O(N) is used. 
    */

    public List<Integer> findDuplicatesII(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        /**
         * If already seen, add to duplicates:
        */
        for (int num : nums) {
            if (set.contains(num)) { 
                duplicates.add(num);
            } else {
                set.add(num);
            }
        }

        return duplicates;
    }

    /**
     * Approach-3: Negative Marking 
     * Since all elements are in the range [1, N], we use idx marking:
     * 1. For each number nums[i], mark its idx position as negative. 
     * 2. If we encounter an already negative number, it's a duplicate.
     * 
     * TC: O(N) => Single Pass through the array
     * SC: O(1) => No extra space used 
     * 
     * Best Approach
    */

    public List<Integer> findDuplicatesIII(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        /**
         * 1. Get the correct index
         * 2. If already negative, it's a duplicate
         * 3. Mark as visited (make negative)
        */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; 

            if (nums[index] < 0) {  
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index]; 
            }
        }

        return duplicates;
    }

    /**
     * Approach-4: Cyclic Sort (Alternate Approach)
     * 1. Place each element its correct idx (nums[i] -> nums[nums[i]])
     * 2. If a number is already at its target idx, it's a duplicate. 
     * 
     * TC: O(N) => Each element swaps at most once
     * SC: O(1) => Modifies array in place
     * 
     * Drawback: Modifies input array!
    */

    public List<Integer> findDuplicatesIV(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            /**
             * If not in place, swap:
            */
            if (nums[i] != nums[correctIndex]) { 
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        /**
         * Now check for duplicates:
        */
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }
}
