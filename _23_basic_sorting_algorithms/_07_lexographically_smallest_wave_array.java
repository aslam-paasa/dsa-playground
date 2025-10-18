package _23_basic_sorting_algorithms;

public class _07_lexographically_smallest_wave_array {
    /**
     * Q. Given an array, find the lexographically smallest wave array.
     *    => If array B is given,
     *       B[0] >= B[1] <= B[2] >= B[3] <= B[4] >= B[5]  ........
     *       |       |       |       |       |       |
     *     Higher  Lower   Higher  Lower   Higher  Lower   ........
     *   
     *    => wa1 = [4, 6, 2, 8] => 4 >= 6 <= 2 >= 8
     *    => wa2 = [6, 4, 8, 2] => 6 >= 4 <= 8 >= 2
     * 
     * Q. Out of these two array, which one is lexographically smaller?
     * => wa1 = [4, 6, 2, 8]
     * => Sort the array in ascending order:
     *    After sorting, my array will become like this:
     *    a[0] <= a[1] <= a[2] <= a[3] <= a[4] <= a[5] ....
     * => Now swap adjacent pairs, so the result will be:
     *          a[1] first then a[0]
     *          a[3] first then a[2]
     *          a[5] first then a[4]
     *    
     * => Final wave array will be:
     *    [a[1], a[0], a[3], a[2], a[5], a[4], ...] 
     * 
     * PseudoCode:
     * function lexographicallySmallestWaveArray(arr) {
     *    sort(arr);
     *    for(int i = 1; i < arr.length; i += 2) {
     *       if(i < arr.length) {
     *          swap(arr[i], arr[i-1]);
     *       }
     *    }
     *    return arr;
     * }
    */
}
