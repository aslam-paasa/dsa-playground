package _21_missing_and_duplicate;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Leetcode-268: Missing Number
 * Given an array nums containing n distinct numbers in the range
 * [0, n], return the missing number.
 * 
 * Input : nums = [3, 0, 1]
 * Output: 2
*/

public class _01_missing_element {
    /**
     * Approach-1: Brute Force (Sorting)
     * 1. Sort the array in ascending order.
     * 2. Traverse from 0 to n and check if the number at idx-i 
     *    matches i. 
     * 3. If a mismatch is found, return i as the missing number. 
     *   
     * TC: O(N logN)
     * SC: O(1)
    */

    public int missingNumberI(int[] nums) {
        /**
         * 1. Sort the Array
        */
        Arrays.sort(nums);  

        /**
         * 2. Compare index and element
         * 3. Return missing number
        */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i; 
            }
        }

        /**
         * 4. If all elements are correct, missing number is 'n'
        */
        return nums.length; 
    }


    /**
     * Approach-2: HashSet
     * Stores all elements in a HashSet and check which number is
     * missing. 
     * 
     * TC: O(N) => Traversing + HashSet lookups
     * SC: O(N) => Stores elements in HashSet
    */

    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        /**
         * 1. Add all numbers to HashSet:
        */
        for (int num : nums) { 
            set.add(num);
        }
        
        /**
         * 2. Check missing number
        */
        for (int i = 0; i <= nums.length; i++) { 
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Approach-3: Mathematical Formula
     * 1. The sum of the first n natural number is sum = n * (n+1) / 2
     * 2. Find the actual sum of the given array and subtract it from
     *    the expected sum to get the missing number. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public int missingNumberIII(int[] nums) {
        int n = nums.length;

        /**
         * 1. Compute sum of first n numbers
        */
        int expectedSum = n * (n + 1) / 2; 
        int actualSum = 0;

        /**
         * 2. Compute actual sum of array
        */
        for (int num : nums) { 
            actualSum += num;
        }

        /**
         * 3. Find missing number
        */
        return expectedSum - actualSum;
    }


    /**
     * Approach-4: XOR
     * 1. XOR has a property: a ^ a = 0 and a ^ 0 = a.
     * 2. XOR all the elements in the array and the numbers from 0 to n.
     * 3. The result will be the missing number.
     *
     * TC: O(N)
     * SC: O(1)
    */

    public int missingNumberIV(int[] nums) {

        /**
         * 1. Start with n
        */
        int missing = nums.length; 
        
        /**
         * 2. XOR with both index and element
        */
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i]; 
        }
        
        /**
         * 3. Remaining value is missing number
        */
        return missing;
    }
}
