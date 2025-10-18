package _09_basic_array_problems;

public class _21_longest_subarray_with_sum_equal_k {
    /**
     * Longest Subarray with sum == k   [positive]
     * => Continuous part of the array is called subarray.
     * => arr = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], K = 3
     * 
     * (a) [1, 2]    = sum-3, length-2
     * (b) [1, 1, 1] = sum-3, length-3
     * (c) [3]       = sum-3, length-1
     * 
     * Approach-1: Brute Force
     * 1. Generate all subarray
     * => Pattern of generating subarray:
     *    1
     *    1 2
     *    1 2 3
     *    1 2 3 1
     *    ..........
     *    ..........
     *    It is extending and goes on till the last, and each one of
     *    them is a subarray. Every generated contiguous part of the
     *    array is subarray.
     * 
     *           i
     * => arr = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3]
     *           j
     * => Everytime if we keep a point 'i' at arr, and then we take
     *    a pointer 'j', and the 'j' will always starts at 'i'. Then
     *    we can say that the subarray is from: (i-j), and everytime
     *    we will move our 'j', and the generated subarray is from
     *    (i-j), and we will keep on moving till it reaches last,
     *    and till it reaches last, the entire array is a subarray.
     * 
     * Pseudocode:
     * int len = 0;
     * for(int i = 0; i < n; i++) {
     *    for(int j = i; j < n; j++) {
     *       int sum = 0;
     *       for(int k = i; k <= j; k++) {
     *          sum += arr[k];
     *       }
     * 
     *       if(sum == k) {
     *          len = Math.max(len, j-i+1);
     *       }
     *    }
     * }
     * print(len);
     * 
     * TC: O(N^3)
     * SC: O(1)
     * 
     * 
     * Approach-2:
     * int len = 0;
     * for(int i = 0; i < n; i++) {
     *    int sum = 0
     *    for(int j = i; j < n; j++) {
     *       sum += arr[j];
     * 
     *       if(sum == k) {
     *          len = Math.max(len, j-i+1);
     *       }
     *    }
     * }
     * print(len); 
     * 
     * 
     * Approach-3: Hashing + Concept of Prefix Sum
     * We have an array with random nums: [ . . . . . . . . . ]
     * and we are looking for any subarray with sum = k. To achieve
     * this, we can use reverse mathematics with prefix sums.
     * 
     * => arr = [ . . . . . . . . . ]
     *                    |
     *                    V
     *   Suppose we are standing at the certain point in the array, 
     *   and the sum of elements from the start to this point is the
     *   prefixSum.
     * 
     * Example:
     * => Let prefixSum = x, which represents the sum of elements from
     *    the start to the current point.
     *    arr = [ . . . . . . . . . ]
     *           <-------->
     *                x   |
     *                    V
     *    This prefix sum represents the sum of all elements up to the
     *    current point.
     * 
     * => Now, if the subarray with sum = k exists and end at the 
     *    current element, we can say that:
     *    prefixSum - (some previous prefixSum) = k
     * 
     * => Rearranging this, we get:
     *    prefixSum - k = previous prefixSum
     * 
     *    This means that if there exists a previous prefix sum equal
     *    to "prefixSum - k", then the elements between that point
     *    and the current element form a subarray whose sum is exactly
     *    k.
     * 
     *    We can check for this condition by storing prefix sums in a
     *    HashMap and looking for the prefix sum that satisfies this
     *    equation.
     * 
     * arr[] = [1, 3, 4, 1, 1, 1]
     * 
     * HashMap = {9, 5}
     *           {8, 4}
     *           {7, 3}
     *           {6, 2}
     *           {3, 1}
     *           {1, 0}
     * => prefixSum =  9 - 6 = 3
     * => len = idx-5 - idx-2 = 3 => return 3
     * 
     * Summary: 
     * For every element, we calculate the running prefixx sum, and then
     * check if there exists a previous prefix sum such that:
     *    prefixSum - k = previous prefixSum
     * 
     * If found, the subarray between the current index and the previous
     * index forms a subarray with sum k. This process is repeated for
     * all elements.
     *    
     * PseudoCode:
     * HashMap<Long, Integer> preSumMap;
     * long sum = 0;
     * int maxLen = 0;
     * 
     * for(int i = 0; i < n; i++) {
     *    1. calculate prefix sum till i:
     *    sum += arr[i];
     * 
     *    2. if the sum = k, update the maxLen:
     *    if(sum == k) {
     *       maxLen = Math.max(maxLen, i+1);
     *    }
     * 
     *    3. calculate the sum of remaining part i.e. x-k;
     *    long remaining = sum - k;
     * 
     *    4. calculate the length and update maxLen:
     *    if(preSumMap.containsKey(remaining)) {
     *       int len = i - preSumMap.get(remaining);
     *       maxLen = Math.max(maxLen, len);
     *    }
     * 
     *    5. Finally, update the map checking the conditions:
     *    if(!preSumMap.containsKey(sum)) {
     *       preSumMap.put(sum, i);
     *    }
     * }
     * return maxLen;
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * Note: This code is correct only for positive integers.
     * 
     * Approach-4: Two Pointer
     * int n = arr.length;
     * int left = 0;
     * int right = 0;
     * 
     * long sum = arr[0];
     * int maxLen = 0;
     * while(right < n) {
     *    1. If sum > k, reduce the subarray from left until sum becomes
     *       less than equal to k:
     *    while(left <= right && sum > k) {
     *       sum -= arr[left];
     *       left++;
     *    }
     * 
     *    2. If sum = k, update the maxLen i.e. answer
     *    if(sum == k) {
     *       maxLen = Math.max(maxLen, right-left+1);
     *    }
     * 
     *    3. Move forward right pointer:
     *    right++;
     * 
     *    if(right < n) {
     *       sum += arr[right];
     *    }
     * }
     * return maxLen;
     * 
     * TC: O(2N)
     */

}
