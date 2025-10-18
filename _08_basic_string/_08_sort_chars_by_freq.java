package _08_basic_string;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Template-5: Frequency Count(Anagram, Sorting by Occurrence)
*/

/**
 * Leetcode-451: Sort Characters By Frequency
 * Given a string s, sort it in decreasing order based on the 
 * frequency of the characters.
 * Return the sorted string. 
 * 
 * - Input : s = "tree"
 * - Output: "eert" (or "eetr")
 * - Reason: 'e' appears twice, 'r' and 't' appear once.
 *           'e' is the most frequent, so it comes first. 
 * 
 * - Input : s = "cccaaa"
 * - Output: "aaaccc" (or "cccaaa")
 * - Reason: 'c' and 'a' both appear 3 times. Any order is valid.
 * 
 * Key Insight:
 * - We need to count the frequency of each character and sort them
 *   based on how many times they appear. 
*/

public class _08_sort_chars_by_freq {
    /**
     * Approach-1: Brute Force (Sorting with Frequency Count)
     * 1. Count the frequency of each character. 
     * 2. Sort the characters based on frequency. 
     * 3. Build the result by repeating each character according to its
     *    frequency. 
     * 
     * Steps:
     * 1. Count Frequency: Use a HashMap to store the frequency of each
     *    character.
     * 2. Store in List: Create a list of pairs(character, frequency).
     * 3. Sort the List: Sort the list in descending order of freq. 
     * 4. Built Output : Append each character frequency times to the result.
     * 5. Return the final result string. 
     * 
     * TC: O(n + k x logk)
     *     - Counting: O(n)
     *     - Sorting : O(k x logk) => k = unique characters, max 26 for lowercase
     *     - Building Result: O(n) 
     * SC: O(n) => For storing the map and result.  
    */

    public static String frequencySort(String s) {
        /**
         * 1. Count frequency of each character
         */
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        /**
         * 2. Store (char, frequency) in a list
        */
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(map.entrySet());

        /**
         * 3. Sort list by frequency in descending order
        */
        Collections.sort(freqList, (a, b) -> b.getValue() - a.getValue());

        /**
         * 4. Build the output string
        */
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqList) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            while (freq-- > 0) {
                result.append(ch);  // Repeat char 'freq' times
            }
        }

        /**
         * 5. Return the final string
        */
        return result.toString();
    }


    /**
     * Approach-2: Max Heap (Priority Queue)
     * 1. Count the frequency of each character. 
     * 2. Use a Max-Heap(Priority Queue) to sort characters by freq. 
     * 3. Build the result string by extracting from the heap. 
     * 
     * Steps:
     * 1. Count Frequency: Use a HashMap 
     * 2. Max Heap: Add character-frequency pairs to a PriorityQueue. 
     * 3. Extract & Build: Poll from the heap and append characters. 
     * 4. Return the final result. 
     * 
     * TC: O(n + k x logk) => O(n log k)
     *     - Counting: O(n)
     *     - Heap Operations: O(k x logk)
     *     - Building Result: O(n)
     * SC: O(n) => For storing the map, heap and result.
    */

    public static String frequencySortII(String s) {
        /**
         * 1. Count frequency of characters
        */
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        /**
         * 2. Add (character, frequency) to a max heap
         *    - Sort by frequency (desc)
         */
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue() 
        );
        maxHeap.addAll(map.entrySet());

        /**
         * 3. Build result string from the heap
        */
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(ch);  // Append character 'freq' times
            }
        }

        return result.toString();
    }

    /**
     * Approach-3: Bucket Sort
     * 1. Count the frequency of each character. 
     * 2. Use buckets where index = frequency. 
     * 3. Collect characters in descending frequency order.
     * 
     * Steps:
     * 1. Count Frequency: Use a HashMap
     * 2. Create Buckets : Use an array of StringBuilder where the idx
     *    is the freq. 
     * 3. Collect Result : Traverse the bucket from high to low. 
     * 4. Return the final string. 
     * 
     * TC: O(n) => Counting + Filling Buckets + Collecting Result
     * SC: O(n) => For map, buckets and result.
    */

    public static String frequencySortIII(String s) {
        /**
         * 1. Count frequency of each character
        */
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        /**
         * 2. Create buckets where index = frequency
        */
        int maxFreq = s.length();
        List<Character>[] buckets = new List[maxFreq + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }

        /**
         * 3. Build result from high frequency to low
        */
        StringBuilder result = new StringBuilder();
        for (int i = maxFreq; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char ch : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scn.nextLine();

        System.out.println("Sorted string using Approach-1: " + frequencySort(s));
        System.out.println("Sorted string using Approach-2: " + frequencySortII(s));
        System.out.println("Sorted string using Approach-3: " + frequencySortIII(s));
        
        scn.close();
    }
}
