package _09_basic_array_problems;

public class _37_sum_of_all_odd_length_subarray {
    /**
     * Sum of all odd length subarray [LC-1588]
     *            0   1   2   3   4
     * => arr = [10, 20, 30, 40, 50]
     * 
     * Move from idx-1 to idx-3:
     *      1   2   3
     * => [20, 30, 40]
     * => length = r-l+1
     * 
     * 1. Count elements b/w left & right including left & right
     *    [10, 11, 12, 13, 14, 15]
     *    count => right-left+1
     * 2. count elements b/w left & right exlcuding both left & right
     *    [11, 12, 13, 14]
     *    count => right-left-1
     * 3. Count elements b/w left & right including either left or right
     *    [left, right] = [10, 11, 12, 13, 14]
     *         or
     *    [left, right] = [11, 12, 13, 14, 15]
     *    count = right -left  
     * 
     * public int sumOddLengthSubarrays(int[] arr) {
     *    int answer = 0;
     * 
     *    for(int left = 0; left < arr.length; left++) {
     *       int sum = 0;
     *       for(int right = 0; right < arr.length; right++) {
     *          sum += arr[right];
     *          if((right-left+1) % 2 == 1) {
     *             answer += sum;
     *          }
     *       }
     *    }
     *    return answer;
     * 
     * Dry Run:
     * => sum = 0
     * => left = 0
     *              right = 0, sum = 10
     *              right = 1, sum = 30    X
     *              right = 2, sum = 60
     *              right = 3, sum = 100   X
     *              right = 4, sum = 150
     * => left = 1
     *              right = 1, sum = 20
     *              right = 2, sum = 50    X
     *              right = 3, sum = 90
     *              right = 4, sum = 140   X
     * 
     * answer = 0 + 10 + 60 + 150 + 20 + 90
     * } 
    */

}
