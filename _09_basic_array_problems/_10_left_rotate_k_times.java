package _09_basic_array_problems;

public class _10_left_rotate_k_times {
    /**
     * Q. Rotate the array 'K-times' to the left.
     * 
     * PseudoCode:
     * => If we want to do 3-left rotation, rotate the jth loop idx-0 to k-1.
     *   
     *     for(int j = 0; j < k; j++) {
     *       rotate();
     *     }
     * 
     * => arr         : [3, 2, 1, 7, 6, 5]
     * => 1st rotation: [2, 1, 7, 6, 5, 3]
     * => 2nd rotation: [1, 7, 6, 5, 3, 2]
     * => 3rd rotation: [6, 5, 3, 2, 1, 7]
     * 
     * TC: O(k * N)
    */

    /**
     * Q. Rotate the array 'K = 10^7-times' to the left. (Optimized)
     * => N = 10^5 (length of array)
     * => K = 10^7
     * 
     * Trick: Question is saying 10^7 rotations kro, but humein 'N-times'
     *        i.e. size of array, se jyda rotation krne ki jarurat hi nhi
     *        hai.
     * 
     * Q. Why you don't have to do more than N-rotation?
     * => N = 4
     *    arr         : [4, 7, 10, 12]
     *    1st rotation: [7, 10, 12, 4]
     *    2nd rotation: [10, 12, 4, 7]
     *    3rd rotation: [12, 4, 7, 10]
     *    4th rotation: [4, 7, 10, 12]
     * 
     * After exact 4-rotations, every element return to its original 
     * place. So, can we say we only have to perform "K % N" rotations.
     * 
     * Modified PseudoCode:
     *     int k = k % N;
     *     for(int j = 0; i < k; i++) {
     *       rotate();
     *    }
     * 
     * TC: O(k*N)
    */
}
