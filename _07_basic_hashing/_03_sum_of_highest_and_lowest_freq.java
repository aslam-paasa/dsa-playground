package _07_basic_hashing;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Sum of highest and lowest frequency:
 * Given an array of n integers, find the sum of the frequencies
 * of the highest occurring number and lowest occurring number.
 * 
 * Input : arr = [1, 2, 2, 3, 3, 3]
 * Output: 4
 * Explanation: The highest freq is 3(element 3), and the lowest
 * frequency is 1(element 1). Their sum is 3 + 1 = 4.
 * 
 * Input : arr = [4, 4, 5, 5, 6]
 * Output: 3
 * Explanation: The highest frequency is 2(elements 4 and 5), and
 * the lowest frequency is 1(element 6)
*/


public class _03_sum_of_highest_and_lowest_freq {
    /**
     * Approach-1: Brute Force
     * 1. Determine the size of the array. 
     *    Initialize two variable: 
     *    a. one to keep track of the highest frequency
     *    b. Another for the lowest frequency
     * 2. Initialize, set the highest frequency to zero(to ensure any
     *    actual frequency found will be higher and update this value).
     *    and the lowest to the size of the array(to ensure any actual
     *    frequency found will be lower and update this value).
     * 3. Create a visited array to avoid counting the same number
     *    multiple times.
     * 4. Loop through each element in the array. For each
     *    element:
     *    a. If the element has already been counted(visited), skip it.
     *    b. Otherwise, count how many times this element appears in 
     *       the array by comparing it with every other element.
     *    c. Update the highest and lowest frequency variables based on
     *       the count of the current element. 
     *    d. Mark all occurrences of this element as visited. 
     * 5. Finally, add the highest and lowest frequencies together and
     *    return the result. 
     * 
     * TC: O(N^2)
     * SC: O(N)
    */

    public static int sumHighestAndLowestFrequency(int[] nums) {
        
        int n = nums.length;
        
        /**
         * Variable to store maximum and minimum frequency
         */
        int maxFreq = 0;
        int minFreq = n;

        boolean[] visited = new boolean[n];
        
        // First loop
        for (int i = 0; i < n; i++) {
            // Skip second loop if already visited
            if (visited[i]) continue;
            
            /**
             * Variable to store frequency of current element
             */
            int freq = 0;
            
            // Second loop
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }
            
            /**
             * Update maximum and minimum frequencies
             */
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
            
        }
        
        // Return the required sum
        return maxFreq + minFreq;
    }


    /**
     * Approach-2: 
     * An optimal approach to solve this question will be use a HashMap,
     * a data structure that stores key-value pairs. 
     * - Key will denote the element in the array. 
     * - Value will store the frequency of the element in the array. 
     * 
     * 1. Take a HashMap to store the key-value pairs. 
     * 2. Start iterating on the array:
     *    a. If the current element is not present in the HashMap, 
     *       insert it with a frequency of 1. 
     *    b. Else, increment the frequency of the current element in
     *       the HashMap. 
     * 3. Once the iterations are over, all the elements with their
     *    frequencies will be stored in the HashMap. Iterate on the
     *    HashMap to find the highest frequenct and the lowest frequency
     *    whose sum can be returned as answer. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static int sumHighestAndLowestFrequencyII(int[] nums) {
        
        int n = nums.length;
        
        /**
         * Variable to store maximum and minimum frequency:
         */
        int maxFreq = 0, minFreq = n; 
        
        /**
         * HashMap: 
        */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        /**
         * Iterating on the array & Updating hashmap
        */ 
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
            
        /**
         * Update maximum and minimum frequencies 
        */ 
        for (int freq : mpp.values()) {
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }
        
        // Return the required sum
        return maxFreq + minFreq;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scn.nextInt();

        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Sum of highest and lowest frequency: " + sumHighestAndLowestFrequency(arr));
        System.out.println("Sum of highest and lowest frequency: " + sumHighestAndLowestFrequencyII(arr));
        scn.close();
    }
}
