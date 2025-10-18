package _09_basic_array_problems;

public class _11_rotate_array_directly {
    /**
     * Q. Rotate the array left/right directly 
     *    (without jumping one step per iteration): O(N)
     * 
     * => Phle hm ek ek kr k ek rotation complete krte th, fir doosra
     *    rotation similarly. Ab hum directly final destination find kr
     *    lenge Kth rotation k baad.
     * => Find 'ith' element ka final destination after kth rotation.
     * 
     * => Example:
     *    arr = [2, 3, 6, 1, 5]
     *    After 1-left rotation : [3, 6, 1, 5, 2]
     * 
     * Approaches:
     * 1. Find Final desitination of any ith element
     * 2. Find what element will come at ith position
     * 
     * Approach-1: Final destination of any ith element after K rotations.
     * 1. Find the final destination of ith element.
     * => After K-left-rotation, what will be the final position of
     *    ith element?
     * => If I am at ith position and I have to move k-times left, can
     *    we say I will be at "i-kth" position.
     * 
     * 2. Handle cyclic rotation:
     * Q. Is my "i-kth" position always positive?
     * => No! But since rotation is cyclic, we use modular arithmetic to 
     *    handle this.
     *    (a) Left rotation formula: (i - k + n) % n
     *    (b) Right rotation formula: (i + k) % n
     *    Using modulus (K % n) ensures positions remain in range.
     * 
     * => Now pick the ith element and place it at its new calculated 
     *    position in a new array.
     * 
     * PseudoCode:
     * function leftRotate(int[] x, int k) {
     *    int n = x.length;
     *    int[] ans[n];
     *    
     *    k = k % n; // adjust k
     * 
     *    for(int i = 0; i < n; i++) {
     *       ans[(i+n-k)%n] = x[i];
     *    }
     *    return ans;
     * }
     * 
     * Approach-2: What element will come at ith position?
     * => In each left rotation, every element shifts by 1 position to 
     *    the left.
     * => For K-rotations, we don't need to rotate step by step. 
     *    Instead, we calculate the position directly after K-rotations.
     * 
     * Example:
     * => arr = [2, 3, 6, 1, 5]
     * => For K = 3, we need to calculate final position of each element.
     *    (a) i = 0, (0+3)%5 = 3, so arr[3] will come at index 0 after 3 
     *        rotations.
     *    (b) Similarly for other elements.
     * 
     * Final formula: 
     * => At ith position, (i + k) % n element will come.
     * 
     * PseudoCode:
     * for(int i = 0; i < n; i++) {
     *    System.out.println(arr[(i+k)%n]);
     * } 
     * 
     * TC: O(N)
    */
}
