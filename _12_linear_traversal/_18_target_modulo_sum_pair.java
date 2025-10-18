package _12_linear_traversal;

/**
 * Leetcode-1010: Pairs of Songs with Total Duration Divisible by 60
 * You are given an array time[], where time[i] represents the duration
 * of a song in seconds. Find the number of pairs (i, j) where:
 * - i < j (pair order matters).
 * - (time[i] + time[j]) % 60 == 0 (sum is divisible by 60).
 * 
 * Return the total number of such pairs
*/

public class _18_target_modulo_sum_pair {

    /**
     * Approach-1: Brute Force (Check Every Pair)
     * 1. Use two loops to check all (i, j) pairs where i < j. 
     * 2. If (time[i] + time[j]) % 60 == 0, count that pair.
     * 3. Return the total count.
     * 
     * TC: O(N^2) => Nested Loops checking every pair.
     * SC: O(1)
     * 
     * Why is this slow?
     * - Quadratic time complexity is too slow for large inputs.
    */

    public int numPairsDivisibleBy60I(int[] time) {
        int count = 0;
        int n = time.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * Approach-2: Frequency Array
     * 1. Create an array remainder[60] to store the counts of 
     *    remainders (time[i] % 60)
     * 2. For each song t:
     *    - Find its remainder : r = t % 60
     *    - Find its complement remainder (60 - r) % 60
     *    - Add the count of the complement remainder to the total count. 
     *    - Store the current remainder in the frequency array. 
     * 3. Return the total count. 
     * 
     * TC: O(N)  => Single pass through time array
     * SC: O(60) => O(1) => Fixed array of size 60
     * 
     * Why is this better?
     * - Only one loop instead of nested loops. 
     * - Uses a small fixed array instead of extra data structures. 
    */

    public int numPairsDivisibleBy60II(int[] time) {
        int[] remainder = new int[60];
        int count = 0;

        /**
         * 1. Handles case when r = 0
         * 2. Add pairs count
         * 3. Store remainder count
        */
        for (int t : time) {
            int r = t % 60;
            int complement = (60 - r) % 60;
            count += remainder[complement];
            remainder[r]++; // 
        }

        return count;
    }
}
