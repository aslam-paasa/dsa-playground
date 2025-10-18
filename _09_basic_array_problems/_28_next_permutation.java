package _09_basic_array_problems;

public class _28_next_permutation {
    /**
     * Q. Next Permutation:
     * => arr = [3, 1, 2]
     * => We will be given array of integers, we have to find the next
     *    permutation of the array.
     * 
     * Q. What is Permutation?
     * => [3, 1, 2] 
     * => There are 3 integers, and these 3 integers can be rearranged
     *    themselves.
     * 
     * Q. How many possible rearrangements are possible?
     * => n! => 1+2+3 = 6
     * => 1. 1  2  3
     *    2. 1  3  2
     *    3. 2  1  3
     *    4. 2  3  1
     *    5. 3  1  2
     *    6. 3  2  1
     * => So, permutation means all the possible ways have to be 
     *    written in sorted order:
     *    123  <  132  <  213  <  231  <  312  <  321
     * => Our array is [3, 1, 2], so we have to return [3, 2, 1].
     * 
     * Note: What if our array is [3, 2, 1] and no permutation is
     *       after this. In such scenario, we will fall back to the
     *       first possible rearrangement in the sorted order, and
     *       the ans will be [1, 2, 3].
     * 
     * Approach-1: Brute Force (Dont' write this code bcoz of TC)
     * 1. Generate all permutation in sorted order
     * 2. Linear Search
     * 3. Find next index permutation as ans
     *    And it doesn't exist, then first permutation is ans.
     * 
     * Q. How to generate all possible permutation?
     * => Using Recursion
     * 
     * TC: Permutation is of N!, and each factorial is of N-size then
     *     N!*N = Very high.
     * 
     * Approach-2:
     * => Matching or Searching perfix-by-prefix.
     * 1. Longer prefix match
     * 
     * => Incomplete
    */

}
