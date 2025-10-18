package _12_linear_traversal;

/**
 * Leetcode-941: Valid Mountain Array
 * Given an array arr, check if it forms a valid mountain.
 * - A mountain array must satisfy the following conditions:
 *   a. It has at least 3 elements. 
 *   b. It must have one peak arr[i] where:
 *        arr[i-1] < arr[i] > arr[i+1]
 *   c. It must strictly increase before the peak and strictly 
 *      descrease after the peak.
*/

public class _07_valid_mountain_array {

    /**
     * Approach-1: Brute Force
     * 1. Check if the array has at least 3 elements. If not, return
     *    false.
     * 2. Find the peak element(largest element where:
     *    arr[i-1] < arr[i] > arr[i+1])
     * 3. Ensure that all elements before the peak are strictly increasing.
     * 4. Ensure that all elements after the peak are strictly decreasing.
     * 5. If all conditions are met, return true; otherwise false. 
     * 
     * TC: O(N) => We loop through arr twice(once to find the peak and
     *             once to verify conditions)
     * SC: O(1)
     * 
     * Why is this slow?
     * - It performs extra iterations to verify conditions after finding
     *   the peak. 
    */

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int peakIndex = 0;

        /**
         * 1. Find the peak element
        */
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                peakIndex = i;
                break;
            }
        }


        /**
         * 2. If no peak found or peak is at first/last index, return false
        */
        if (peakIndex == 0 || peakIndex == n - 1) return false;


        /**
         * 3. Check increasing sequence before peak
         * 4. Check decreasing sequence after peak
        */
        for (int i = 1; i < peakIndex; i++) {
            if (arr[i] <= arr[i - 1]) return false;
        }

        for (int i = peakIndex + 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) return false;
        }

        return true;
    }


    /**
     * Approach-2: One Pass
     * 1. Check if arr has at least 3 elements.
     * 2. Use a single pass with two pointers to:
     *    - Move up the mountain until arr[i] stops increasing. 
     *    - Move down the mountain until arr[i] stops decreasing. 
     * 3. If we climbed up and then down, and we used the entire array,
     *    return true. 
     * 
     * TC: O(N) => Single Pass to check both increasing and decrasing
     *             sequences. 
     * SC: O(1)
     * 
     * Why is this better?
     * - Instead of finding the peak first and then checking, we do
     *   both in one pass.
    */

    public boolean validMountainArrayII(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        /**
         * 1. Climb up:
        */
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        /**
         * 2. Peak cannot be first or last element
        */
        if (i == 0 || i == n - 1) return false;

        /**
         * 3. Climb down:
        */
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        /**
         * 4. If we reached the end, it's a valid mountain:
        */
        return i == n - 1;
    }
}
