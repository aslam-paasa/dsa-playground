package _09_basic_array_problems;

public class _33_special_index {
    /**
     * Question asked in: Amazon, Google, MS, Adobe, DirectI, Codenation
     * 
     * Q. Given an array, count the number of special indexes.
     * => Special Index: After removing
     *    (Sum of all odd indexed elements = Sum of all even indexed elements)
     *     in the result array.
     *    
     *    0 1 2 3 4  5
     * A: 4 3 2 7 6 -2
     * 
     * Q. If I remove idx-0, what is the new uppdated array?
     *               0  1  2  3   4
     * => i = 0, => [3, 2, 7, 6, -2]
     * 
     *               0  1  2  3 
     * => i = 1, => [2, 7, 6, -2]
     * 
     * Note: Whenever we remove something, we will change the index
     *       entirely.
     */ 
    
    
    /** Observation:
     * 1. If I remove "ith" index, all indexes < i remains the same.
     *    (means left side of the index remains the change.)
     * 
     * 2. If I remove "ith" index, all indexes > i ==> even idx element
     *    become odd, and odd element idx elements become even.
     * 
     * 
     * Step-1: Build PSEven & PSOdd
     *           0  1  2  3  4  5
     * => arr = [4, 1, 5, 3, 7, 10]
     * => re  = idx-2
     *           
     *           0  1  | 2  3  4
     * => arr = [4, 1, | 3, 7, 10]
     *          <----> | <------->
     * 
     * (a) Every idx < i remains the same.
     * (b) Every idx > 1, Odd became even and even became odd.
     * 
     * 
     * Q. What is the sum of even idx to the left of "i"?
     * => idx[0] = 4
     * Q. What is the sum of even idx to the right of "i"?
     * => idx[2] + idx[4] = 3 + 10 => 13
     * 
     * Q. What is the sum of all the odd indexes of the original array to the right?
     * => idx[3] + idx[5] = 3 + 10 => 13
     * 
     * After removing:
     * Sum of even idx of the elements = Sum of odd idx of the original array to the right
     * => idx[2] + idx[4] = 13         = idx[3] + idx[5] = 13
     * 
     * 
     * Formula:
     * If removing "i":
     *    Sum of even to the left = PSEven[i-1] (unchanged)
     * 
     *    Sum of even to the right = Sum of all odd idx elements to the
     *                               right in the original array
     *                             = PSOdd[i+1 : n-1]
     *                             = PSOdd[n-1] - PSOdd[i]
     * 
     *    Sum of odd to the left  = PSOdd[i-1]
     *    Sum of odd to the right = Sum of all even idx elements to the
     *                              right in the original array
     *                            = PSEven[n-1] - PSEven[i]
     * 
     * Total Sum of Even = PSEven[i-1] + PSOdd[n-1] - PSOdd[i]
     * Total Sum of Odd  = PSOdd[i-1] + PSEven[n-1] - PSEven[i] 
     * 
     * */ 

    /**
     * Code:
     * int count = 0;
     * 
     * => Build PSEven & PSOdd
     * for(int i = 0; i < N; i++) {
     *    SE = PSEven[i-1] + PSOdd[n-1] - PSOdd[i];
     *    SO = PSOdd[i-1] + PSEven[n-1] - PSEven[i];
     * 
     *    if(SE == SO) {
     *       count++;
     *    }
     * 
     *    // handle i = 0 separately
     * }
     * 
     * return count;
     * 
     * TC: O(N) 
     * SC: O(N)
    */
}
