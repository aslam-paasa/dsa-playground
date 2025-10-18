package _20_majority_element;

import java.util.HashMap;

/**
 * Leetcode-169: Majority Element
 * Given an array nums, find the majority element (appears more
 * than n/2 times).
*/

public class _01_majority_element {
    /**
     * Approach-1: Brute Force
     * Check the count of each element and find the one appearing more
     * than n/2 times.
     * 
     * Steps:
     * 1. Take each element one by one.
     * 2. Count how many times it appears in the array.
     * 3. If its count is greater than n/2, return the element.
     * 
     * TC: O(N^2) => Two nested loops for counting freq
     * SC: O(1)
    */

    public int majorityElementI(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // This will never be reached as the problem guarantees a majority element.
    }


    /**
     * Approach-2: HashMap
     * Use a HashMap to store counts of each element and find the 
     * majority element. 
     * 
     * Steps:
     * 1. Create a HashMap to store the freq of each element. 
     * 2. Traverse the array and update the count of each element in
     *    the HashMap. 
     * 3. If any element's count exceeds n/2, return it. 
     * 
     * TC: O(N) => Traversing the array once.
     * SC: O(N) => Storing counts in HashMap
    */

    public int majorityElementII(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1;
    }


    /**
     * Approach-3: Boyer-Moore Voting Algorithm
     * Since the majority element appears more than n/2 times, it will
     * always be the last remaining candidate. 
     * 
     * Steps:
     * 1. Initialize a candidate = 0 and count = 0
     * 2. Traverse the array:
     *    - If count is 0, update candidate to the current element and 
     *      reset count to 1. 
     *    - Else, if the current element matches the candidate, increment
     *      count. 
     *    - Otherwise, decrement count.
     * 3. The candidate at the end will be the majority element.
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public int majorityElementIII(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }

            else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
