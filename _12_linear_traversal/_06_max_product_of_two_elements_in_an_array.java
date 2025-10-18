package _12_linear_traversal;

import java.util.Arrays;

/**
 * Leetcode-1464: Max Product of Two Elements in an Array
 * Given an integer array nums, find the two largest nums and
 * return:  (max1 - 1) * (max2 - 1), where max1 and max2 are the
 * two largest numbers in nums.
*/

public class _06_max_product_of_two_elements_in_an_array {

    /**
     * Approach-1: Brute Force
     * 1. Generate All Pairs: Use two nested loops to try all possible
     *    paurs (nums[i], nums[j]). 
     * 2. Compute the product: 
     *    - For each pair, compute: (nums[i] - 1) * (nums[j] - 1)
     * 3. Track the max: Keep track of the max product found. 
     * 4. Return the max product. 
     * 
     * TC: O(N^2) => Two nested loops check all pairs
     * SC: O(1) 
     * 
     * Why is this slow?
     * - It checks every possible pair, making it inefficient for
     *   large inputs. 
    */

    public static int maxProductI(int[] nums) {
        int maxProduct = 0;
        
        // Try all pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                maxProduct = Math.max(maxProduct, product);
            }
        }
        
        return maxProduct;
    }


    /**
     * Approach-2: Sorting
     * 1. Sort the array in ascending order. 
     * 2. Get the last two elements in the sorted array:
     *    (max1 = nums[n-1], max2 = nums[n-2])
     * 3. Compute the product: (max1 - 1) * (max2 - 1)
     * 4. Return the product. 
     * 
     * TC: O(N logN) => Sorting the array
     * SC: O(1)
     * 
     * Why is this better?
     * - Instead of checking all pairs, we just sort and pick the
     *   last two elements. 
    */

    public static int maxProductII(int[] nums) {
        Arrays.sort(nums);  
        int n = nums.length;
        
        // Get the last two elements
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }


    /**
     * Approach-3: Single Pass
     * Instead of sorting, we find the two largest numbers in a single
     * pass!
     * 
     * Steps:
     * 1. Initialize two variable:
     *    - max1 = 0 (largest)
     *    - max2 = 0 (second largest)
     * 2. Traverse the array:
     *    - If num > max1, update the max2 = max1 and max1 = num
     *    - Else if num > max2, update max2 = num. 
     * 3. Compute the product: (max1 - 1) * (max2 - 1)
     * 4. Return the product. 
     * 
     * TC: O(N) => Single pass to find the two largest numbers. 
     * SC: O(1)
     * 
     * Why is this the best approach?
     * - It finds the two largest numbers in a single loop, making it
     *   O(N) and optimal. 
    */

    public static int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;
        
        // Single pass to find two largest numbers
        for (int num : nums) {
            if (num > max1) {
                max2 = max1; // Previous max1 becomes second largest
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        
        return (max1 - 1) * (max2 - 1);
    }
}
