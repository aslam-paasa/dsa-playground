package _09_basic_array_problems;

public class _38_suffix_sum {
    /**
     * Suffix: 
     * => Suffix is subarray with ending index as the last index.
     * => Suffix[i] = arr[i] + suffix[i+1]
     * 
     * Approach-1: 
     * public int[] runningSum(int[] nums) {
     *    int[] prefix = new int[nums.length];
     * 
     *    for(int idx = 0; idx < nums.length; idx++) {
     *       prefix[idx] = nums[idx] + ((idx > 0) ? prefix[idx-1] : 0);
     *    }
     *    return prefix;
     * }
     * 
     * Approach-2:
     * public int[] runningSum(int[] nums) {
     *    int n = nums.length;
     *    int[] suffix = new int[n];
     * 
     *    for(int idx = n-1; idx >= 0; idx--) {
     *       suffix[idx] = nums[idx] + ((idx < n-1) ? suffix[idx+1] : 0);
     *    }
     *    return suffix;
     * }
     * 
     * Approach-3:
     * public int[] runningSum(int[] nums) {
     *    int n = nums.length;
     *    int[] suffix = new int[n];
     *    suffix[n-1] = nums[n-1];
     * 
     *    for(int idx = n-2; idx >= 0; idx--) {
     *       suffix[idx] = nums[idx] + suffix[idx+1];
     *    }
     *    return suffix;
     * }
    */
}
