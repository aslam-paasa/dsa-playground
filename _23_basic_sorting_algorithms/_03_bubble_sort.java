package _23_basic_sorting_algorithms;

public class _03_bubble_sort {
    /**
     * Scenario: Swap b/w adjacent elements
     * In school morning prayer, we used to stand height wise. Similarly,
     * we can only switch/swap between adjacent elements.
     * Ex: height = [9, 3, 8, 6, 7, -2, 11, 4, 5]
     * 
     * By swapping only adjacent elements, can we move any element to any
     * particular place? Yes! And by doing this we will sort our school
     * assembly line height wise.
     *  
     * So, we will only swap when our arr[j] is greater:
     *              arr[j] > arr[j+1] 
     * 
     *           0  1  2  3  4   5  6   7  8
     * height = [9, 3, 8, 6, 7, -2, 11, 4, 5]
     *        = [3, 8, 6, 7, -2, 9, 4, 5, 11]  (Round-1: swap till n-1)
     *        = [3, 6, 7, -2, 8, 4, 5, 9, 11]  (Round-2: swap till n-2)
     *        = [3, 6, -2, 7, 4, 5, 8, 9, 11]  (Round-3: swap till n-3)
     *        = [3, -2, 6, 4, 5, 7, 8, 9, 11]  (Round-4: swap till n-4)
     *        = [-2, 3, 4, 5, 6, 7, 8, 9, 11]  (Round-5: swap till 4)
     *        = [-2, 3, 4, 5, 6, 7, 8, 9, 11]  (Round-6: swap till 3)
     *        = [-2, 3, 4, 5, 6, 7, 8, 9, 11]  (Round-7: swap till 2)
     *        = [-2, 3, 4, 5, 6, 7, 8, 9, 11]  (Round-8: swap till 1)
     *        = [-2, 3, 4, 5, 6, 7, 8, 9, 11]  (Round-9: swap till 0)
     * 
     * This sorting is called Bubble Sort.
     * 
     * Q. arr = [2, 4, 9, 10, 13, 17, 19]
     *    In the first iteration of already sorted bubble sort array, how 
     *    many swaps will be possible?
     * => 0-Swaps in first iteration.
     * => We will stop at the 1st iteration if the number of swaps is 0.
     *    (Best Case - Already Sorted)
     * 
     * 
     * PseudoCode:
     * for(int i = 0; i < n; i++) {
     *    int count = 0;
     *    for(int j = 0; j < n-i-1; j++) {
     *       if(arr[j] > arr[j+1]) {
     *          swap(arr[j], arr[j+1]);
     *          count++;
     *       }
     *    }
     *    if(count == 0) {
     *       break;
     *    }
     * }
     * 
     * Analysis:
     * 1. Number of swaps       : O(N^2) swaps
     * 2. Number of comparisons : O(N^2)
     *    (a) 1st iteration = n-comparison
     *    (b) 2nd iteration = n-1 comparison
     *    (c) 3rd iteration = n-2 comparison
     *        ...
     *    (z) nth iteration = 1 comparison
     *    => Total Comparison = n(n+1)/2 => (n^2 + n) / 2 => n^2 
     * 3. Time Complexity       : O(N^2)
     * 4. Space Complexity      : O(1)
     * 5. Stable or Unstable    : Stable
     *    => My duplicate element will never jump.
     *    => arr[j] > arr[j+1]
     * 
     * Note: If the Bubble Sort is sorted then it will stop the iteration.
     *       But if Selection Sort is sorted, still it will run till the
     *       end. So, Bubble Sort is better then Selection Sort.
    */
}
