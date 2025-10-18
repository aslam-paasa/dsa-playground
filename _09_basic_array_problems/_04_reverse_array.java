package _09_basic_array_problems;

public class _04_reverse_array {
    /**
     * Q. Reverse the array:
     *           0  1  2  3  4  5
     * => arr = [3, 2, 1, 6, 7, 8]
     * => rev = [8, 7, 6, 1, 2, 3]
     * 
     * Approach-1: Using extra array
     * => int n = arr.length;
     *    int x[n];
     *    int j = 0;
     * 
     *    for(int i = n-1; i >= 0; i--) {
     *       x[j] = arr[i];
     *       j++;
     *    }
     * TC: O(N)
     * SC: O(N)
     * 
     * Approach-2: In-place - Swapping
     * => Swap array elements n/2 times.
     * => n-i-1
     * 
     * 1. Input the array
     * 2. i=0 -> i < n/2
     *       arr[i] = arr[n-i-1];
     * 
     *    for(int i = 0; i < n/2; i++) {
     *       swap(arr[i], arr[n-i-1]);
     *    }
     * 3. print the array again
     * 
     * TC: O(N)
     * SC: O(1)
    */
}
