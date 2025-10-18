package _23_basic_sorting_algorithms;

public class _08_max_modulo_pair {
    /**
     * Motive: Sorting should be used carefully
     * */ 

    /**
     * Q. Given N array elements, max value of (arr[i] % arr[j])
     *    where i != j. 
     * Ex: arr = [3, 5, 4, 10]
     *     (a) 3 % 5  = 3 (Value will be between 0 to 5)
     *     (b) 4 % 10 = 4 (Value will be between 0 to 10)
     *     (c) 5 % 10 = 5 (Value will be between 0 to 10) => max
     *     (d) 10 % 4 = 2 (Value can be between 0 to 3)
     * 
     * Ex: arr = [6, 9, 3, 11]
     *     (a) 9 % 11 = 9 (max) 
     * 
     * Approach-1: Nested Loop
     * - Check for every pair (i, j) and get max
     * - TC: O(N^2)
     * 
     * Approach-2: Find second largest % largest element
     *  (a) Sort & take arr[n] & arr[n-1]
     *  (b) Run bubble sort only 2 times - 2 max
     *      - In selection sort, we use to pick min everytime.
     *      - In Insertion Sort, we try to fix a position.
     *      - In Bubble Sort, we use to get max everytime.
     *     So, we can run the bubble sort two times and we will the
     *     largest & second largest element.
     * 
     * Catch: Both these approach only works with unique elements.
     * arr = [4, 5, 8, 7, 8]
     * Q. Will both of our approach work?
     * => largest element: 8
     * => Second largest element: 8
     * => 8 % 8 = 0 
     * 
     *  (c) Run a loop - find max first
     *      Run the loop 2nd time - then check first max != current max
     * 
     * TC: O(N^2)
    */
}
