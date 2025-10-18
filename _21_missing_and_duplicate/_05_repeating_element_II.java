package _21_missing_and_duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * GFG: Array Duplicates
 * Given an array of size N containing integer from 0 to N-1, find
 * all duplicate numbers present in the array. 
 * 
 * Input : arr = [0, 3, 1, 2, 3, 4, 5, 2]
 * Output: [2, 3]
 * 
 * Constraints:
 * - Numbers are within [0, N-1]
 * - Duplicates may appear multiple times
 * - Extra space allowed? ✅ O(1) [In-place modification is allowed]
 * - Runtime Constraint?  ✅ O(N)
*/

public class _05_repeating_element_II {
    /**
     * Approach-1: Brute Force (Nested Loops)
     * 1. Pick each element one by one. 
     * 2. Compare it with all the next elements to check for duplicates.
     * 
     * TC: O(N^2) (Nested loop for comparisons)
     * SC: O(1) (No extra data structures, only result storage)
     * 
     * Drawback: Too slow for large arrays!
    */

    public List<Integer> findDuplicatesI(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) { 
            for (int j = i + 1; j < nums.length; j++) { 
                if (nums[i] == nums[j] && !duplicates.contains(nums[i])) { 
                    duplicates.add(nums[i]);
                    break; // Move to the next unique element
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
     * TC: O(N) (Single pass through the array)
     * SC: O(N) (Uses extra space for HashSet)
     *
     * Drawback: Uses O(N) extra space.
    */

    public List<Integer> findDuplicatesII(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        /**
         * If already seen, add to duplicates
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
     * Since all elements are in the range [0, N-1], we use idx marking:
     * 1. For each number nums[i], mark its idx position as negative. 
     * 2. If we encounter an already negative number, it's a duplicate. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Best Approach
    */

    public List<Integer> findDuplicatesIII(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        /**
         * 1. Get the actual value
         * 2. If already negative, it's a duplicate
         * 3. Mark as visited (make negative)
        */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]); 

            if (nums[index] < 0) {
                duplicates.add(index);
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
     * TC: O(N)
     * SC: O(1)
    */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];

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
            if (nums[i] != i) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }
}
