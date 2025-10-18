package _09_basic_array_problems;

public class _20_max_consecutive_ones {
    /**
     * Q. Maximum Consecutive Ones.
     * => arr = [1, 1, 0, 1, 1, 1, 0, 1, 1]
     *                   <-------->
     *                       |
     *                       V
     * => Maximum Consecutive Ones are '3'.
     * 
     * Approach-1: 
     * int max = 0
     * int count = 0;
     * for(int i = 0; i < arr.size(); i++) {
     *    if(arr[i] == 1) {
     *       count++;
     *       max = Math.max(max, count);
     *    } else {
     *       count = 0;
     *    }
     * }
     * return max;
     * 
     * TC: O()
     * SC: O()
    */

    public static void maxConsecutiveOnes(int[] arr) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
           if(arr[i] == 1) {
              count++;
              max = Math.max(max, count);
           } else {
              count = 0;
           }
        }
       System.out.println(max); 
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        maxConsecutiveOnes(arr);
    }

}
