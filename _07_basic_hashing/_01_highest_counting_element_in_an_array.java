package _07_basic_hashing;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Highest occurring element in the array:
 * Given an array of n integers, find the most frequent element in
 * it i.e., the element that occurs the maximum number of times.
 * If there are multiple elements that appear a maximum number of
 * times, find the smallest of them.
 * 
 * Input : arr = [1, 2, 2, 3, 3, 3]
 * Output: 3
 * 
 * Explanations: The number 3 appears the most (3 times). It is
 * the most frequent element.
 * 
 * Input : arr = [4, 4, 5, 5, 6]
 * Output: 4
 * 
 * Explanation: Both 4 and 5 appear twice, but 4 is smaller. So,
 * 4 is the most frequent element.
*/


public class _01_highest_counting_element_in_an_array {
    /**
     * Approach-1: Brute Force
     * A brute force way to solve this problem will be use two loops:
     * - First loop to iterate on the array, selecting an element.
     * - Second loop to traverse the remaining array to find the
     *   occurrences of the selected element in the first loop.
     * 
     * Maintain a visited array to mark the elements to track of
     * duplicate elements that were already take into account. 
     * 
     * 1. Initialize a visited array of boolean type having size n,
     *    where n is the size of the array with all elements set to
     *    false. Also, declare the following variables:
     *    a. maxFreq : to store the freq of the highest occurring elements.
     *    b. maxEle  : to store the highest occurring elements in the array.
     * 2. In the first loop, start iterating on the elements of the array
     *    selecting one element at a time.
     * 3. In the second loop, iterate on the rest portion of the array
     *    and count the frequency (number of occurrences) of the selected
     *    element. And every time, the same element is found, mark the
     *    corresponding index of the visited array as true. 
     * 4. If the frequency of the current element is found greater than
     *    maxFreq, update maxFreq and maxEle with the new frequency and
     *    new element respectively. 
     * 5. If the frequency of the current element is the same as maxFreq,
     *    store the smaller the maxEle and the current element in maxEle.
     * 6. Before starting the second loop, check if the element is marked
     *    as unvisited. Skip the element if it is visited because its
     *    frequency has already been taken into consideration.
     * 
     * TC: O(N^2)
     * SC: O(N)
    */

    public static int mostFrequentElement(int[] nums) {
        int n = nums.length;
        int maxFreq = 0;
        int maxEle = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            /**
             * Skip second loop if already visited
            */
            if(visited[i]) continue;

            /**
             * Variable to store freq of current element
            */
            int freq = 0;

            for(int j = 1; j < n; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }

            /**
             * Update variables if new element having highest freq is found
            */
            if(freq > maxFreq) {
                maxFreq = freq;
                maxEle = nums[i];
            } else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, nums[i]);
            }
        }
        return maxEle;
    }


    /**
     * Approach-2: Hashing
     * An optimal approach to solve this question will be use a HashMap,
     * a data structure that stores key-value pairs. 
     * - Key will denote the element in the array. 
     * - Value will store the frequency of the element in the array. 
     * 
     * 1. Take a HashMap to store the int key-value pairs. 
     * 2. Start iterating on the array. 
     *    a. If the current element is not present in the HashMap, insert
     *       it with a frequency of 1. 
     *    b. Else, increment the frequency of current element in the 
     *       HashMap. 
     * 3. Once the iterations are over, all the elements with their
     *    frequencies will be stored in the HashMap. Iterate on the
     *    HashMap to find the element with the highest frequency. 
     * 
     * TC: O(N) 
     * SC: O(N)
    */

    public static int mostFrequentElementII(int[] nums) {
        int n = nums.length;
        int maxFreq = 0;
        int maxEle = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value

            if(freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            } else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
        }
        return maxEle;
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

        System.out.println("Most frequent element using Approach-1: " + mostFrequentElement(arr));
        System.out.println("Most frequent element using Approach-2: " + mostFrequentElementII(arr));
        scn.close();
    }
    
}
