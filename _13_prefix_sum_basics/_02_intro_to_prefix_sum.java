package _13_prefix_sum_basics;

import java.util.Arrays;

/**
 * Introduction to Prefix Sum:
 * - Imagine keeping track of how much money you spend on takeout meals each
 *   day over a period of days.
 * 
 *   spendings = [ 10,  15,  20,  10,  5]
 *                 Mon  Tue  Wed  Thu  Fri
 * 
 * - Let's say you want to know the total spent on takeout food up until a
 *   particular day. For example, you might like to know that the total you've
 *   spent up until Wednesday is 45 (10 + 15 + 20).
 * - This is information which a prefix sum array can store.
 * 
 * - For an array of integers, a prefix sum array maintains the running sum 
 *   of values up to each index of the array.
 * 
 *   spending =  [ 10,  15,  20,  10,  5 ]
 *                 Mon  Tue  Wed  Thu  Fri
 *   prefixSum = [ 10,  25,  45,  55,  60]
 * 
 * - To obtain the prefix sum at each index, we just add the current number
 *   from the input array of the prefix sum from the previous index.
 * 
 * TC: O(N)
 * SC: O(N)
*/

public class _02_intro_to_prefix_sum {
  public static int[] prefixSum(int[] nums) {
    
    /**
     * a. Start by adding the first number to the prefix sums array
    */
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];

    /**
     * b. For all remaining indexes, add nums[i] to the cumulative sum for the prev idx
    */
    for (int i = 1; i < nums.length; i++) {
        prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    /**
     * c. Return the prefix sum array
    */
    return prefixSum;
  }  

  public static void main(String[] args) {
    int[] nums = { 10, 15, 20, 10, 5 };
    int[] prefixSum = prefixSum(nums);
    System.out.println("Prefix Sum Array: " + Arrays.toString(prefixSum));
  }
}


/**
 * Applications of Prefix Sum:
 * 1. Prefix Sum are commonly used to efficiently determine the sum of arrays.
 * 2. Another variant: prefix products, which populates an array with a
 *    running product instead of a running sum.
*/

/**
 * Chapter Outline:
 * > Prefix Sums
 *   a. Subarray Sums:
 *      - Sum b/w ranges
 *      - K-Sum Subarrays
 *   b. Product Sums
 *      - Product array without current element
*/