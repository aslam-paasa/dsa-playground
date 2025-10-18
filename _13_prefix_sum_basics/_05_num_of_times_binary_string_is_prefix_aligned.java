package _13_prefix_sum_basics;

/**
 * Leetcode-1375: Number of Times Binary String is Prefix-Aligned
 * You are given a binary array flips where each value represents
 * a 1-based index in an empty binary string of length n. Each 
 * time you flip, you set that position to 1. 
 * 
 * A binary string is prefix-aligned if all the bits from the
 * beginning to a certain position are 1, and the rest can be 0.
 * 
 * Return the number of times the binary string becomes
 * prefix-aligned after each flip.
 * 
 * - Input : flips = [3, 2, 4, 1, 5]
 * - Output: 2
 * - Explanation:
 *   1. Flip Position: 3
 *      - Binary String => [0, 0, 1, 0, 0] (Not prefix-aligned)
 *   2. Flip Position: 2
 *      - Binary String => [0, 1, 1, 0, 0] (Not prefix-aligned)
 *   3. Flip Position: 4
 *      - Binary String => [0, 1, 1, 1, 0] (Not prefix-aligned)
 *   4. Flip Position: 1
 *      - Binary String => [1, 1, 1, 1, 0] (Prefix-aligned)
 *   5. Flip Position: 5
 *      - Binary String => [1, 1, 1, 1, 1] (Prefix-aligned)
 * So, the output is 2 because the string became prefix-aligned
 * twice. 
*/

public class _05_num_of_times_binary_string_is_prefix_aligned {
    /**
     * Approach-1: Brute Force
     * 1. Create an array arr to simulate to binary string 
     *    (initialize all values as 0). 
     * 2. For each flip in the flips array:
     *    a. Update the corresponding index to 1. 
     *    b. Check if the binary string is prefix-aligned by verifying
     *       all bits from the beginning to the current flip point
     *       are 1. 
     *    c. If it is aligned, increment a count. 
     * 3. Return the count after processing all flips. 
     * 
     * TC: O(n^2)
     *     - Each flip O(n), we check if the array is prefix-aligned.
     * SC: O(n)
     *     - For storing the binary array. 
    */

    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            /**
             * 1. Mark the flip position as 1 (convert to 0-based index)
             */
            arr[flips[i] - 1] = 1;

            /**
             * 2. Check if the binary string is prefix-aligned
             */
            boolean isPrefixAligned = true;
            for (int j = 0; j <= i; j++) {
                if (arr[j] == 0) {
                    isPrefixAligned = false;
                    break;
                }
            }

            if (isPrefixAligned) {
                count++;
            }
        }
        return count;
    }


    /**
     * Approach-2: Better Approach
     * 1. Use two variables:
     *    a. maxPosition to track the farthest position flipped to 1.
     *    b. count to track the number of prefix-aligned. 
     * 2. For each flip in flips:
     *    a. Update maxPosition with the maximum flipped position so far. 
     *    b. If the current flip count equals maxPosition, it means the
     *       prefix is fully aligned. 
     * 3. Return the count of prefix-aligned moments. 
     * 
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public int numTimesAllBlueII(int[] flips) {
        /**
         * 1. Track the farthest flipped position
         * 2. Track prefix-aligned moments
        */
        int maxPosition = 0;
        int count = 0; 

        for (int i = 0; i < flips.length; i++) {
            maxPosition = Math.max(maxPosition, flips[i]);
            
            /**
             * If the max flipped position == current position (1-based index)
             */
            if (maxPosition == i + 1) {
                count++;
            }
        }
        return count;
    }
}
