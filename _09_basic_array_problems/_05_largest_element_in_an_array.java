package _09_basic_array_problems;

public class _05_largest_element_in_an_array {
    /**
     * Q. Find the largest element in an array.
     * => arr = [3, 2, 1, 5, 2]
     * 
     * Approach-1: Sort and return the last element (n-1)
     * TC: O(NlogN)
     * SC: O(1)
     * 
     * Approach-2: largest = arr[0], then iterate-compare-update-return
     * int largest = arr[0];
     * for(int i = 0; i < n; i++) {
     *    if(arr[i] > largest) {
     *       largest = arr[i];
     *    }
     * }
     * print(largest);
     * 
     * TC: O(N)
     * SC: O(1)
    */
}
