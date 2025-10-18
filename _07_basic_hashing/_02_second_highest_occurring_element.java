package _07_basic_hashing;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Second Highest Occurring Element:
 * Given an array of n integers, find the second most frequent
 * element in it. If there are multiple elements that appear a
 * maximum number of times, find the smallest of them. If second
 * most frequent element does not exist return -1. 
 * 
 * Input : arr = [1, 2, 2, 3, 3, 3]
 * Output: 2
 * Explanation: The number 2 appears the second most (2 times)
 * and number 3 appears the most(3 times).
 * 
 * Input : arr = [4, 4, 5, 5, 6, 7]
 * Output: 6
 * Explanation: Both 6 and 7 appear second most times, but 6 is
 * smaller. 
*/


public class _02_second_highest_occurring_element {
    /**
     * Approach-1: Brute Force
     * 1. Create variables to store the highest and second highest freq.
     *    Also, create variables to store the corresponding elements.
     *    Use a visited array of boolean type to mark elements that have
     *    already been counted to avoid recounting them. 
     * 2. Loop through each element in the array. For each element, if
     *    it hasn't been counted yet, proceed to count its occurrences.
     *    For each element, count how many times it appears in the array.
     *    Mark these elements as counted. 
     * 3. Compare the frequency of the current element with the highest
     *    and second highest frequencies. Update the highest and second
     *    highest frequencies and their corresponding elements as needed.
     * 4. If two elements have the same frequency, choose the smaller one.
     *    After processing all elements, return the element with the
     *    second highest frequency. 
     * 
     * TC: O(N^2)
     * SC: O(N)
    */

    public static int secondMostFrequentElementI(int[] nums) {
        
        int n = nums.length;
        
        /** 
         * Variable to store maximum frequency and second Max frequency
        */
        int maxFreq = 0;
        int secMaxFreq = 0;
        
        /**
         * Variable to store elements with most and second most frequency
         */
        int maxEle = -1, secEle = -1;
        
        /**
         * Visited array:
        */
        boolean[] visited = new boolean[n];
        
        // First loop
        for(int i = 0; i < n; i++) {
            /**
             * Skip second loop if already visited:
            */
            if(visited[i]) continue;
            
            /**
             * Variable to store frequency of current element
             */
            int freq = 0;
            
            // Second loop
            for(int j = i; j < n; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }
            
            /** 
             * Update variables if new element having highest frequency
             * or second highest frequency is found 
            */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = nums[i];
            } 
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, nums[i]);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = nums[i];
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, nums[i]);
            }
        }
        return secEle;
    }


    /**
     * Approach-2: Hashing
     * An optimal approach to solve this question will be use a HashMap,
     * a data structure that stores key-value pairs. 
     * - Key will denote the element in the array. 
     * - Value will store the frequency of the element in the array. 
     * 
     * 1. Initialize variable to keep track of the highest and second
     *    highest frequencies, as well as the corresponding elements. 
     * 2. Create a hashmap to store the frequency of each element in
     *    the array. 
     * 3. Iterate through the array and update the frequency of each
     *    element in the hashmap. 
     * 4. Iterate through the hashmap to determine the element with the
     *    highest frequency and the element with the second highest
     *    frequency. 
     * 5. Return the element with the second highest frequency.
     *
     * TC: O(N)
     * SC: O(N)
    */

    public static int secondMostFrequentElement(int[] nums) {
        
        int n = nums.length;
        
        /**
         * Variable to store maximum frequency and second maximum frequency
         */
        int maxFreq = 0, secMaxFreq = 0; 
        
        /**
         * Variable to store element with maximum frequency and second
         * highest frequency
         */
        int maxEle = -1, secEle = -1;
        
        // HashMap
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Iterating on the array
        for (int i = 0; i < n; i++) {
            // Updating hashmap 
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
            
        // Iterate on the map
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value
            
            /** 
             * Update variables if new element having highest frequency
             * or second highest frequency is found 
            */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            } 
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }
        
        // Return the result
        return secEle;
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
        System.out.println("Second most frequent element using Approach-1: " + secondMostFrequentElementI(arr));
        System.out.println("Second most frequent element using Approach-2: " + secondMostFrequentElement(arr));
        scn.close();
    }
}
