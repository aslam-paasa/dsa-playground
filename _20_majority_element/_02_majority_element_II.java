package _20_majority_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Majority Element-II  (Check Leetcode-229)
 * Given an integer array nums, find all elements that appear
 * more than n/3 times.
*/

public class _02_majority_element_II {
    /**
     * Approach-1: Brute Force
     * Count occurrence of each element and check if it appears more
     * than n/3 times.
     * 
     * Steps:
     * 1. Take each element one by one.
     * 2. Count how many times it appears in the array. 
     * 3. If its count is greater than n/3, add it to the result list.
     * 4. Ensure no duplicate in the result list. 
     * 
     * TC: O(N^2) => Nested loops for counting
     * SC: O(1)   => Only storing the result list
    */

    public List<Integer> majorityElementI(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3 && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }

        return result;
    }


    /**
     * Approach-2: HashMap
     * Use a HashMap to store frequencies and filter elements appearing
     * more than n/3 times. 
     * 
     * Steps:
     * 1. Use a HashMap<Integer, Integer> to store element frequencies. 
     * 2. Traverse the array and update the count in HashMap. 
     * 3. Traverse the HashMap and collect elements with count > n/3. 
     * 
     * TC: O(N) => Two Passes: One for counting, one for filtering
     * SC: O(N) => Stores element freq in HashMap
    */

    public List<Integer> majorityElementII(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


    /**
     * Boyer-Moore Voting Algorithm:
     * Why Boyer-Moore?
     * - There can be at most two majority elements(because we need
     *   elements appearing more than n/3 times). 
     * - We use two candidates and two counts to track potential majority
     *   elements. 
     * 
     * Steps:
     * 1. Find potential candidates:
     *    - Keep two candidates and two counts
     *    - If we find an element equal to a candidate, increase its count. 
     *    - If we find a new element and one count is 0, assign that element
     *      as a new candidate. 
     *    - Otherwise, decrease both counts. 
     * 2. Verify the candidates:
     *    - Counte the occurrences of both candidates in the array. 
     *    - Add only those appearing more than n/3 times to the result list. 
     * 
     * TC: O(N) => Two passes through the array
     * SC: O(1)
    */

    public List<Integer> majorityElementIII(int[] nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // Step 1: Find potential majority candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Validate candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
