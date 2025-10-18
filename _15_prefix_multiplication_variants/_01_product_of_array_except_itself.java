package _15_prefix_multiplication_variants;

/**
 * Leetcode-238: Product of Array Except Self
 * Given an integer array nums, return an array answer that 
 * answer[i] is equal to the product of all the elements of nums
 * except nums[i].
 * 
 * Constraint:
 * a. Divison is NOT allowed
 * b. Solve it in O(n) time.
 * 
 * - Input : nums = [1, 2, 3, 4]
 * - Output: [24, 12, 8, 6]
 * - Explanation:
 *   - For nums[0] => 2 x 3 x 4 = 24
 *   - For nums[1] => 1 x 3 x 4 = 12
 *   - For nums[2] => 1 x 2 x 4 = 8
 *   - For nums[3] => 1 x 2 x 3 = 6
*/

public class _01_product_of_array_except_itself {
    /**
     * Approach-1: Brute Force (Multiply Everything Except Itself)
     * 1. Loop through each element in the array
     * 2. For each element, find the product of all other elements.
     * 3. Store the result in the output array.
     * 
     * TC: O(n^2) => For each element, we loop through the entire array
     *               to calculate the product.
     * SC: O(n)   => Output array. 
    */

    public static int[] productExceptSelfI(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        /**
         * Iterate over each element:
         */
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip the current index
                product *= nums[j];
            }
            answer[i] = product;
        }

        return answer;
    }

    /**
     * Approach-2: Better Approach (Prefix and Suffix Arrays)
     * 1. Create two arrays:
     *    a. prefix => Product of elements before the current index. 
     *    b. suffix => Product of elements after the current index. 
     * 2. Compute prefix : From left to right
     * 3. Compute suffix : From right to left
     * 4. Calculate the result : prefix and suffix
     * 
     * TC: O(n) => Three passes: prefix, suffix and final output
     * SC: O(n) => For prefix and suffix arrays
    */

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];

        /**
         * 1. Build prefix array
        */
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        /**
         * 2. Build suffix array
        */
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        /**
         * 3. Multiply prefix and suffix
        */
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }


    /**
     * Approach-3: Optimized Approach (Prefix + Suffix)
     * 1. Use the output array to store the prefix products. 
     * 2. Multiply the suffix in a reverse pass. 
     * 3. Avoid extra space by computing everything in place. 
     * 
     * How it works:
     * 1. First Pass(left to right)  - Store Prefix Product
     * 2. Second Pass(Right to Left) - Multiply suffix product
     * 
     * TC: O(n) => Two passes (left and right)
     * SC: O(1)
    */

    public static int[] productExceptSelfIII(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        /**
         * 1. Fill prefix product in answer array
        */
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        /**
         * 2. Multiply by suffix product
        */
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
