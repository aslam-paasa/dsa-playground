package _12_linear_traversal;

import java.util.HashMap;

/**
 * Leetcode-1512: Number of Good Pairs
 * Given an array nums, count the number of good pairs where
 * (i, j) is a good pair if:
 * - nums[i] == nums[j]
 * - i < j
*/

public class _10_number_of_good_pairs {

    /**
     * Approach-1: Brute Force
     * 1. Initialize count = 0
     * 2. Use two nested loops to compare every pair (i, j)
     * 3. If nums[i] == nums[j], and i < j, increase the count.
     * 4. Return count after checking all pairs.
     * 
     * TC: O(N^2) => Two nested loops iterating through times.
     * SC: O(1)   => Only an integer variable count is used. 
     * 
     * Why is this slow?
     * - If checks all possible pairs, making it inefficient for large
     *   inputs.
    */

    public int numIdenticalPairsI(int[] nums) {
        int count = 0;

        // Check all pairs (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * Approach-2: HashMap/Frequency Count
     * 1. Count occurrences of each number using a HashMap. 
     * 2. If a number appears f times, the number of good pairs is
     *    f * (f - 1) / 2 (formula for selecting 2 out of f).
     * 3. Sum up all pairs and return the result. 
     * 
     * TC: O(N) => Single Pass to count frequency and calculate pairs.
     * SC: O(N) => HashMap stores count for each unique number.
     * 
     * Why is this better?
     * - Instead of checking all pairs, it only counts occurrences,
     *   reducing complexity. 
    */

    public int numIdenticalPairsII(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                count += freqMap.get(num); // Add existing occurrences as pairs
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }


    /**
     * Approach-3: Array as Frequency Count for Small Constraints
     * If nums[i] is a small range (like 0 < nums[i] <= 100), we can
     * use an array instead of HashMap. 
     * 
     * Steps:
     * 1. Create an array freq[101], initialized to 0 (for constraints
     *    0 <= nums[i] <= 100).
     * 2. Iterate through nums and update freq[num].
     * 3. Apply the formula: f * (f - 1) / 2 to calculate good pairs. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Why is this the best approach?
     * - Even faster than HashMap, since array access is O(1). 
    */

    public int numIdenticalPairsIII(int[] nums) {
        int[] freq = new int[101]; 
        int count = 0;

        /**
         * 1. Add existing occurrences as pairs
         * 2. Increment frequency
        */
        for (int num : nums) {
            count += freq[num];
            freq[num]++;
        }

        return count;
    }
}
