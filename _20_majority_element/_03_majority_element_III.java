package _20_majority_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GFG: More than n/k occurrences
 * Given an array of size n, find all elements that appears more
 * than n/k times.
*/

public class _03_majority_element_III {
    /**
     * Approach-1: Brute Force
     * Count occurrences of each element and check if it appears more
     * than n/k times.
     * 
     * Steps:
     * 1. Take each element one by one.
     * 2. Count how many times it appears in the array. 
     * 3. If its count is greater than n/k, add it to the result list. 
     * 4. Ensure no duplicates in the result list.
     * 
     * TC: O(N^2) => Nested loops for counting
     * SC: O(1)   => Only stores the result list
    */

    public List<Integer> moreThanNByKI(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / k && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }

        return result;
    }


    /**
     * Approach-2: HashMap
     * Use a HashMap<Integer, Integer> to store element frequencies. 
     * 
     * Steps:
     * 1. Use a HashMap<Integer, Integer> to store element frequencies.
     * 2. Traverse the array and update the count in HashMap. 
     * 3. Traverse the HashMap and collect elements with count > n/k.
     * 
     * TC: O(N) => Two Passes: One for counting, one for filtering 
     * SC: O(N) => Stores element frequencies in HashMap
    */

    public List<Integer> moreThanNByKII(int[] nums, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


    /**
     * Approach-3: Boyer-Moore Voting Algorithm
     * Why Boyer-Moore?
     * - There can be at most k-1 majority elements(because we need
     *   elements appearing more than n/k times). 
     * - We use k-1 candidates and k-1 counts to track potential majority
     *   elements. 
     *
     * Steps:
     * 1. Find potential candidates:
     *    - Keep k-1 candidates and k-1 counts
     *    - If we find an element equal to a candidate, increase its count. 
     *    - If we find a new element and one count is 0, assign that element
     *      as a new candidate. 
     *    - Otherwise, decrease both counts. 
     * 2. Verify the candidates:
     *    - Counte the occurrences of both candidates in the array.
     *    - Add only those appearing more than n/k times to the result list. 
     *
     * TC: O(N) => Two passes through the array
     * SC: O(k) => Uses (k-1) extra variables
    */

    public List<Integer> moreThanNByK(int[] nums, int k) {
        int n = nums.length;
        if (k < 2) return new ArrayList<>(); // Edge case: invalid k

        // Step 1: Find (k-1) potential majority candidates
        HashMap<Integer, Integer> candidates = new HashMap<>();

        for (int num : nums) {
            if (candidates.containsKey(num)) {
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k - 1) {
                candidates.put(num, 1);
            } else {
                // Reduce count of all candidates
                List<Integer> toRemove = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : candidates.entrySet()) {
                    candidates.put(entry.getKey(), entry.getValue() - 1);
                    if (entry.getValue() - 1 == 0) {
                        toRemove.add(entry.getKey());
                    }
                }
                for (int key : toRemove) {
                    candidates.remove(key);
                }
            }
        }

        // Step 2: Validate the candidates
        HashMap<Integer, Integer> actualCounts = new HashMap<>();
        for (int num : nums) {
            if (candidates.containsKey(num)) {
                actualCounts.put(num, actualCounts.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : actualCounts.entrySet()) {
            if (entry.getValue() > n / k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
