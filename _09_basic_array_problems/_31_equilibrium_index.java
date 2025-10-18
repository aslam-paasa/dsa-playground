package _09_basic_array_problems;

public class _31_equilibrium_index {
    /**
     * Q. Given an array, return true if there exist equilibrium index.
     * 
     * Equilibrium index:
     * => Index for which :
     *       sum of element on left side = sum of element on right side
     *  
     *         0  1  2  3  4  5  
     * => A: [ 1, 2, 3, 4, 8, 10]
     * 
     * (a) Idx-4
     * => sum on left side = sum on right side
     * => 1+2+3+4          = 10
     * => 10               = 10
     * => return true.
     * 
     * Note: 
     * 1. When we are checking idx-4, it should be excluded.
     * 2. If no elements on the left, take sum of left side = 0.
     * 3. If no elements on the right, take sum of right side = 0.
     * 
    */

    /**
     * Checking for index-i:
     * SL = a0+a1+a2+ .... + ai-1 = ps[i-1]
     * SR = ai+1 + ai+2 + ... + an-1
     * 
     * Formula:
     * => sum[s:e]      = ps[e]   - ps[s-1]
     * => Sum[i+1, n-1] = ps[n-1] - ps[i]
     * 
     * 
     * Edge Case:
     *                if(i == 0) {
     *                   SumL = 0;
     *                }
     *                if(i == n-1) {
     *                   SumR = 0;
     *                }
     * 
     * Step-1: Build PS
     * Step-2: Check any index is equilibrium or not:
     *    for(int i = 1; i <= n-2; i++) {
     *       SumL = ps[i-1];
     *       SumR = ps[n-1] - ps[i];
     * 
     *       if(SumL == SumR) {
     *          return true;
     *       }
     *    }
     * 
     * TC: O(N) + O(N) = O(N)
     *     PS     EQIdx
     * 
     * SC: O(N)
    */
}
