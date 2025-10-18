package _14_prefix_sum_with_conditional_logic;

/**
 * Leetcode-848: Shifting Letters
 * You are given a string s and an integer array shifting of the
 * same length.
 * a. For each shifts[i], you need to shift the first i+1 letters
 *    of the string by shifts[i] positions in the alphabet. 
 * b. Return the final shifted string after applying all the shifts.
 * 
 * Alphabets Shifting:
 * - 'a' shifted by 1 becomes 'b', 'z' shifted by 1 becomes 'a'
 *   (circular shift)
 * - Shifts are cumulative - meaning, each shift affects all prev
 *   characters. 
 * 
 * - Input : s = "abc", shifts = [3, 5, 9]
 * - Output: "rpl"
 * - Explanation:
 *   1. First Shift : "abc" => "dbc" (Shift first 1 character by 3)
 *   2. Second Shift: "dbc" => "igc" (Shift first 2 characters by 5)
 *   3. Third Shift : "igc" => "rpl" (Shift first 3 characters by 9)
 * So, the final output is "rpl". 
*/

public class _03_shifting_letters {
    /**
     * Approach-1: Brute Force
     * 1. Iterate through each position i in the string. 
     * 2. For each position, shift the first i+1 characters by shifts[i].
     * 3. Use modulo(% 26) to handle circular shifts in the alphabets. 
     * 4. Return the final modified string. 
     * 
     * TC: O(N^2) 
     *     - For each position i, you modify the first i+1 characters,
     *       leading to quadratic complexity.
     * SC: O(n)
     *     - For storing the output string. 
    */

    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        int n = s.length();

        /**
         * Iterate over each position:
         * - Shift the first (i + 1) letters
        */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[j] = (char) ((arr[j] - 'a' + shifts[i]) % 26 + 'a');
            }
        }
        return new String(arr);
    }

    /**
     * Approach-2: Better Approach (Prefix Sum)
     * 1. Reverse Accumulate the Shifts:
     *    - Since every shift affects all previous letters, we calculate
     *      the total shift each character will experience. 
     *    - Traverse the shifts array backward and keep a running sum of
     *      the shifts. 
     * 2. Modify Each Character:
     *    - Use the prefix sum to adjust each character. 
     *    - Apply the shift using modulo(% 26) to keep it within the
     *      alphabet range. 
     * 3. Return the Final String:
     *    - Convert the modified character array back to a string. 
     * 
     * TC: O(N) => We calculate prefix sums in one pass and transform
     *             the string in another. 
     * SC: O(N) => Storing Output String
    */

    public String shiftingLettersII(String s, int[] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();

        /**
         * 1. Accumulate shifts in reverse order (prefix sum approach)
         */
        long totalShifts = 0;
        for (int i = n - 1; i >= 0; i--) {
            totalShifts += shifts[i];
            totalShifts %= 26; // Avoid overflow
            arr[i] = (char) ((arr[i] - 'a' + totalShifts) % 26 + 'a');
        }

        return new String(arr);
    }
}
