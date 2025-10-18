package _14_prefix_sum_with_conditional_logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * GFG: Leaders in an Array
 * Given an array arr[] of size n, an element is called a leader
 * if it is greater than or equal to all the elements on the right
 * side.
 * 
 * Find all the leaders in the array. The righmost element is always
 * a leader. 
 * 
 * - Input : arr[] = [16, 17, 4, 3, 5, 2]
 * - Output: {17, 5, 2}
 * - Explanation:
 *   - 2 is the leader because it's the last element
 *   - 5 is greater than everything to its right
 *   - 17 is greater than 4, 3, 5, 2.
*/

public class _05_array_leaders {
    /**
     * Approach-1: Brute Force(Check each element)
     * 1. Loop through each element from left to right
     * 2. For each element, check all elements to its right.
     * 3. If the current element is greater than or equal to all the
     *    elements on its right, it is a leader. 
     * 4. Store and print all such leaders. 
     * 
     * TC: O(n^2) => For each element, we check the entire right subarray
     * SC: O(1)
    */

    public static List<Integer> findLeadersI(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;

            /**
             * Check all elements to the right:
            */
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break; // No need to check further
                }
            }

            if (isLeader) {
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }


    /**
     * Approach-2: Better Approach(Maximum Array)
     * 1. Create an auxiliary array rightMax[] to store the maximum
     *    element to the right of each index. 
     * 2. Traverse the array and compare each element with the rightMax. 
     * 3. If the current element is greater, it is a leader. 
     * 
     * TC: O(n) => Two passes: 
     *             - one to calculate rightMax, 
     *             - another to find leaders. 
     * 
     * SC: O(n) => For the rightMax array. 
     *  
    */

    public static List<Integer> findLeadersII(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int[] rightMax = new int[n];

        /**
         * 1. Fill rightMax array
        */
        rightMax[n - 1] = arr[n - 1]; // Last element is always a leader
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i + 1], rightMax[i + 1]);
        }

        /**
         * 2. Compare each element with rightMax
        */
        for (int i = 0; i < n; i++) {
            if (arr[i] >= rightMax[i]) {
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }


    /**
     * Approach-3: Right-to-Left Traversal
     * 1. Start from the rightmost element(always a leader)
     * 2. Keep track of the maximum encountered so far(maxFromRight)
     * 3. As you move left, if you find an element greater than
     *    maxFromRight, it's a leader and update maxFromRight. 
     * 4. Reverse the leader list before returning. 
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public static List<Integer> findLeadersIII(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        
        /**
         * 1. Rightmost element is always a leader
        */
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        
        /**
         * 2. Traverse from right to left
        */
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i]; // Update max
            }
        }

        /**
         * 3. Reverse the list to maintain the order
        */
        Collections.reverse(leaders);
        return leaders;
    }
}
