package _23_basic_sorting_algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class _13_largest_number {
    /**
     * Frequently Asked Interview Question
     * Q. Given an array of +ve integers, return the largest no.
     *    that can be formed using these integers.
     * => A : [3, 30, 34, 5, 9]
     * 
     * Different o/ps: 3303459
     *                 3343059
     *                 5343039
     *                 9534330 [Largest No.]
     * 
     * Logic:
     * 1. Sort the integers based on their digits and values.
     * 2. Concatenate the sorted integers to form the largest number.
     * 
     * Note: This problem is a classic example of a greedy algorithm, 
     *       where we make the locally optimal choice at each step to 
     *       achieve the globally optimal solution.
     * 
     * PseudoCode:
     * bool comp(String s1, String s2) {
     *    if(s1+s2 > s2+1) {
     *       return true;
     *    } else {
     *       return false;
     *    }
     * }
     * 
     * sort(arr, arr+n, comp);
    */

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};

        // Convert the array of integers to an array of strings
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        // Custom comparator for sorting based on the concatenated result
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Compare the two possible concatenated combinations
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1);  // Descending order
            }
        };

        // Sort the array using the custom comparator
        Arrays.sort(strArr, comp);

        // Handle the case where the largest number is 0 (like [0, 0])
        if (strArr[0].equals("0")) {
            System.out.println("0");
            return;
        }

        // Concatenate the sorted array to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String s : strArr) {
            largestNumber.append(s);
        }

        // Print the result
        System.out.println("Largest Number: " + largestNumber.toString());
    }
}
