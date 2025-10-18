package _23_basic_sorting_algorithms;

public class _14_count_sort {
    /**
     * Count Sort: (We have already seen)
     * => Sorting a string
     *    (a) Make frequency array
     *    (b) Iterate on each count
     * 
     * s  s  a  b  c  g  p
     * 
     * 0  1  2  3  4   ...  18  ...  25
     * 1  1  1  0  0   ...  2
     * 
     * (a) ASCII of 's' = 83
     *     => ch - a
     *     => 115 - 97
     *     => 18
     * (b) ASCII of 'a' = 97
     *     => ch - a
     *     => 97 - 97
     *     => 0
     * 
     * Ex: 1  2  1  3  5  4  2  3    [1 <= arr[i] <= 5]
     * => create freq array = count[6]
     * => for(int i = 1; i <= 5; i++) {
     *       while(count[i] > 0) {
     *          print(i);
     *          count[i]--;
     *       }
     *    }
     * 
     * TC: O(N)
     * SC: O()
    */
}
