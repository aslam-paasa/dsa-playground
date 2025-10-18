package _14_prefix_sum_with_conditional_logic;

/**
 * Leetcode-1664: Ways to make a fair array
 * You are given an integer array nums. You can remove exactly one
 * element from the array.
 * 
 * After removing the element, if the sum of elements at even or
 * odd indices becomes equal, it's called a fair array. 
 * 
 * Return the number of ways to make the array fair by removing
 * exactly one element.
 * 
 * - Input : nums = [2, 1, 6, 4]
 * - Output: 1
 * - Explanation:
 *   If we remove nums[1] = 1, the new array is [2, 6, 4]:
 *   a. Even indices sum = 2 + 4 = 6
 *   b. Odd indices sum  = 6
 *      Both sums are equal, so there is 1 way. 
*/

public class _04_balanced_array {
    /**
     * Approach-1: Brute Force (Check all possibilities)
     * 1. Loop through each index i (from 0 to n-1)
     * 2. Remove the element at i
     * 3. Recalculate the sum of even and odd indices for the updated
     *    array. 
     * 4. If even sum == odd sum, increase the count by 1.
     * 5. Return the count after checking all indices. 
     * 
     * TC: O(n^2) => For each idx, calculating even and odd sums
     *               takes O(n)
     * SC: O(1)
    */

    public static int waysToMakeFairI(int[] nums) {
        int n = nums.length;
        int ways = 0;

        /**
         * 1. Check every index by removing it
        */
        for (int i = 0; i < n; i++) {
            int evenSum = 0, oddSum = 0;

            for (int j = 0; j < n; j++) {
                if (j == i) continue; // Skip the current index

                if (j < i) {
                    if (j % 2 == 0) evenSum += nums[j];
                    else oddSum += nums[j];
                } else {
                    if ((j - 1) % 2 == 0) evenSum += nums[j];
                    else oddSum += nums[j];
                }
            }

            /**
             * If evenSum == oddSum, increase the count by 1
            */
            if (evenSum == oddSum) {
                ways++;
            }
        }

        return ways;
    }


    /**
     * Approach-2: Better Approach (Prefix Sums)
     * 1. Calculate:
     *    - Left Even Sum = Even-indexed elements before the current index.
     *    - Left Odd Sum = Odd-indexed elements before the current index.
     *    - Left Odd Sum = Odd-indexed elements before the current index.
     *    - Right Odd Sum = Odd-indexed elements after the current index.
     * 2. For each index i:
     *    - New Even Sum = Left odd sum + Right odd sum.
     *    - New Odd Sum = Left even sum + Right even sum.
     * 3. If new even sum == new odd sum, increase the count.
     * 4. Return the total count. 
     * 
     * TC: O(n) => Two passes through the array(one for prefix sum, one
     *             for checking)
     * SC: O(1)
    */

    public static int waysToMakeFairII(int[] nums) {
        int n = nums.length;

        /**
         * 1. Calculate total even and odd sums
        */
        int totalEvenSum = 0, totalOddSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) totalEvenSum += nums[i];
            else totalOddSum += nums[i];
        }

        int leftEvenSum = 0, leftOddSum = 0;
        int ways = 0;

        /**
         * 2. Traverse the array and check conditions:
         *    a. Right sums after removing current element
         *    b. Check if new even sum == new odd sum
         *    c. Update left sums based on current index
        */
        for (int i = 0; i < n; i++) {

            int rightEvenSum = totalEvenSum - leftEvenSum - (i % 2 == 0 ? nums[i] : 0);
            int rightOddSum = totalOddSum - leftOddSum - (i % 2 == 1 ? nums[i] : 0);

            if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum) {
                ways++;
            }

            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }

        return ways;
    }
}
