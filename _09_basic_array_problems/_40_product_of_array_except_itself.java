package _09_basic_array_problems;

public class _40_product_of_array_except_itself {
    /**
     * Q. Product of Array except itself [LC-238]
     *           0  1  2  3  4
     * => arr = [2, 5, 3, 4, 6]
     * 
     * Approach-1: Division Operator
     * => product = 2x5x3x4x6
     * => answer = product/2, product/5, product/3, product/4, product/6
     * 
     * Corner Case: Division by 0
     * => arr = [2, 5, 4, 0, 8]
     *           |  |  |  |  |
     *           V  V  V  V  V
     *           0  0  0 120 0
     * 
     * => arr = [2, 0, 4, 0, 3]
     *           |  |  |  |  |
     *           V  V  V  V  V
     *           0  0  0  0  0
     * 
     * Approach-2: Without division operator
     * arr =    [2,  5,  3,  4,   6]
     * pre =  1  2   10  30  120  720
     * suf =    720 360  72  24   6   1
     * 
     * public int[] getPrefix(int[] nums) {
     *    int[] prefix = new int[nums.length];
     * 
     *    for(int idx = 0; idx < nums.length; idx++) {
     *       prefix[idx] = nums[idx] * ((idx > 0) ? prefix[idx-1] : 1);
     *    }
     *    return prefix;
     * }
     * 
     * public int[] getSuffix(int[] nums) {
     *    int n = nums.length;
     *    int[] suffix = new int[n];
     * 
     *    for(int idx = n-1; idx >= 0; idx--) {
     *       suffix[idx] = nums[idx] * ((idx < n-1) ? suffix[idx+1] : 1);
     *    }
     *    suffix;
     * }
     * 
     * 
     * public int productExceptSelf(int[] nums) {
     *    int[] prefix = getPrefix(nums);
     *    int[] suffix = getSuffix(nums);
     * 
     *    int n = nums.length;
     *    int[] answer = new int[n];
     *    for(int idx = 0; idx < 0; idx++) {
     *       int left = (idx > 0) ? prefix[idx-1] : 1;
     *       int right = (idx < n-1) ? suffix[idx+1] : 1;
     *       answer[idx] = left * right;
     *    }
     *    return answer;
     * }
     * 
     * a. if idx == 0
     *    => prefix[idx-1] will be prefix[-1] which doesn't exist.
     * b. idx == n-1
     *    => suffix[idx+1] will be suffix[n] which doesn't exist.
    */
}
