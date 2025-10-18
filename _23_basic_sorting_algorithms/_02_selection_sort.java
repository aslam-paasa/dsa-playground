package _23_basic_sorting_algorithms;

public class _02_selection_sort {
    /**
     * Selection Sort:
     * Q. Given an array element, find Kth minimum of the array?
     * => arr = [1, 5, -1, 2, 10, 3], K = 3 (3rd minimum)
     * 
     * Wrong Approach:
     * 1. Find 1st minimum & delete it.
     * 2. Find 2nd minimum & delete it.
     * 3. Find Kth minimum i.e. 3 & return it.
     * Note: Sorting is correct but never delete the data.
     *       When we try to sort data, our first minimum should go to 0th 
     *       idx.
     * 
     * Q. Let's say data is at xth idx, so what should we do to bring it 
     *    to 0th idx?
     * => Swap them - xth place to 0th place
     * => 2nd minimum - Check from 1st idx till 'n-1' & swap them.
     * => 3rd minimum - Check from 2nd idx till 'n-1' & swap them.
     * => 4th minimum - Check from 3rd idx till 'n-1' & swap them.
     * => Kth minimum - Check from kth idx till 'n-1' & swap them.
     * => nth minimum - Check from nth idx till 'n-1' & swap them.
     * => And this process is called Selection Sort.
     *    (Selection Sort is picking minimum one-by-one)
     * 
     * PseudoCode:
     * for(int i = 0; i < n; i++) {          // find ith minimum
     *    int minVal = INTEGER_MAX_VALUE;
     *    int minIndex = -1;
     *    for(int j = i; j < n; j++) {
     *       if(arr[j] < minVal) {
     *          minVal = arr[j];
     *          minIndex = j;
     *       }
     *    }
     *    swap(arr[minIndex], arr[i]);
     * }
     * 
     * 
     * Analysis:
     * 1. Number of swaps       : O(N) swaps
     * 2. Number of comparisons : O(N^2)
     *    (a) 1st iteration = n-comparison
     *    (b) 2nd iteration = n-1 comparison
     *    (c) 3rd iteration = n-2 comparison
     *        ...
     *    (z) nth iteration = 1 comparison
     *    => Total Comparison = n(n+1)/2 => (n^2 + n) / 2 => n^2 
     * 3. Time Complexity       : O(N^2)
     * 4. Space Complexity      : O(1)
     * 5. Stable or Unstable    : Unstable
     *    (a) Before Sorting:
     *        2a  2b  1  4
     *    (b) After Sorting: Swap
     *        1   2b  2a 4
     * 
     * Homework: Modify Selection Sort and make it stable.
    */
}
