package _09_basic_array_problems;

public class _09_left_rotate_array {
    /**
     * Q. Given with an array, we have to left-rotate the array. [GFG]
     * => arr = [2, 3, 7, 6, 1, 5]
     * => left-rotation means: 
     *    a. every element will shift one element leftwards, and
     *    b. my first element goes to last element:
     *    leftRot = [3, 7, 6, 1, 5, 2]
     * 
     * Approach: Swapping
     * Idea: arr[i] = arr[i+1]
     * 
     * 1. First store arr[0] in temp
     * 2. arr[i-1] = arr[i] for every element from i = 1 to n-1
     * 3. arr[n-1] = temp
     * 
     * PseudoCode:
     * int arr[n];
     * 
     * function rotate(int[] arr) {
     *    int temp = arr[0];
     *    for(int i = 1; i < n; i++) {
     *       arr[i-1] = arr[i];
     *    }
     *    arr[n-1] = temp;
     * }
     * 
     * TC: O(N)
    */

}
