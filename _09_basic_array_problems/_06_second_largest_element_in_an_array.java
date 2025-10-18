package _09_basic_array_problems;

public class _06_second_largest_element_in_an_array {
    /**
     * Q. Find the 2nd largest element in an array.
     * => arr = [1, 2, 4, 7, 7, 5]
     * 
     * 1. Approach-1: Sorting
     * => arr = [1, 2, 4, 7, 7, 5]
     *    | Sorting
     *    V
     *    arr = [1, 2, 4, 5, 7, 7]
     *    (a) largest (n-1)     = 7
     *    (b) 2nd largest (n-2) = 5 (not 7)
     * 
     * => We have to start from n-2th idx and check - Is it equivalent
     *    to largest? If yes!, its not largest. Move to n-3 and check.
     * 
     *    Arrays.sort(arr);
     *    int largest = arr[n-1];
     *    int secondLargest = -1;
     *    for(int i = n-2; i >= 0; i--) {
     *       if(arr[i] != largest) {
     *          secondLarge = arr[i];
     *          break;
     *       }
     *    }
     * 
     * TC: O(NlogN) 
     * 
     * 
     * Approach-2:
     * => int max1;  (current largest)
     *    int max2;  (2nd largest)
     * 
     * 1. First int = max1
     *    2nd int = max2
     * 2. Case-1: next element > max1
     *            => max1 = next element
     *            => max2 = prevMax, max1
     *    Case-2: next element > max2
     *            => max2 = next element
     *    Case-3: Neither greater than max1 nor greater than max2
     * 
     *      +----------------------------+
     * arr  |   | 3 | 2 | 6 | 9 | 7 | 10 |
     *      +----------------------------+
     * max1 | X | 3 | 3 | 6 | 9 | 9 | 10 |
     * max2 | X | X | 2 | 3 | 6 | 7 |  9 |
     *      +----------------------------+
     * Note: For Kth largest, we will use different approach because
     *       we can't make that many cases for K.
     * 
     * PseudoCode:
     * int arr[n];
     * int max1 = arr[0];
     * int max2 = arr[0];
     * 
     * for(int i = 1; i < n; i++) {
     *    if(arr[i] > max1) {       
     *       max2 = max1;        (Update max2)
     *       max1 = arr[i];      (Update max1)
     *    } else if(arr[i] > max2) {
     *       max2 = arr[i];      (Update max2)
     *    }
     * }
     * print(max2);
    */
}
