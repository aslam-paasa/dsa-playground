package _09_basic_array_problems;

public class _29_leaders_in_an_array {
    /**
     * Q. Leaders in an Array:
     * => Everything on the right should be smaller
     * => arr = [10, 22, 12, 3, 0, 6]
     *    (a) 22: Leader (On right, everything is smaller than 22)
     *    (b) 12: Leader (On right, everything is smaller than 12)
     *    (c)  3: Not Leader
     *    (d)  0: Not Leader
     *    (e)  6: Leader
     * Note: Last Element will always be a leader because there is 
     *       nothing on the right.
     * 
     * Approach-1: Brute Force
     * for(int i = 0; i < n; i++) {
     *    leader = true;
     *    for(int j = i+1; j < n; j++) {
     *       if(arr[j] > arr[i]) {
     *          leader = false;
     *          break;
     *       }
     *    }
     * }
     * if(leader == true) {
     *    ans.add(arr[i]);
     * }
     * 
     * TC: O(N^2)
     * SC: O(N)
     * 
     * 
     * Approach-2:
     * => arr[i] > max of its left side, then arr[i] is greater than
     *    every element on its right side.(leader)
     * 
     * PseudoCode:
     * int max = INTEGER_MIN_VALUE;
     * 
    */

}
