package _09_basic_array_problems;

public class _39_min_value_to_get_positive_step_by_step_sum {
    /**
     * Minimum Value to Get Positive Step by Step Sum: [LC-1413]
     * => arr = [-3, 2, -3, 4, 2, -5, -10, 15]
     *        14 11 13  10 14 16  11   1   16
     * 
     * public int minStartValue(int[] nums) {
     *    int sum = 1;
     *    int starting = 1;
     * 
     *    for(int val: nums) {
     *       sum += val;
     *       if(sum <= 0) {
     *          starting += (1 - sum);
     *          sum = 1;
     *       }
     *    }
     *    return starting;
     * }
    */ 
}
