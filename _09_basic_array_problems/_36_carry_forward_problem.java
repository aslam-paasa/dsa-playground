package _09_basic_array_problems;

public class _36_carry_forward_problem {
    /**
     * Q. Given an array, return the length of smallest subarray which
     *    contains both MAX & MIN of the array.
     * => Subarray: Conitnuous part of the array.
     *      0  1  2  3  4  5  6  7  8  9
     * A  : 1  2  3  1  3  4  6  4  6  3
     * max: 6
     * min: 1
     * 
     * Min length which contain 6 & 1: idx-(3,6)  [smallest subarray]
     * ans = 4 [length of smallest subarray]
     * 
     * 
     * Example:
     *       0  1  2  3  4  5  6  7  8  9  10
     * A   : 2  2  6  4  5  1  5  2  6  4  1
     * max : 6
     * min : 1
     * 
     * Min length which contain 6 & 1: idx-(8, 10)
     * ans = 3 [length of smallest subarray]
    */

    /**
     * Observation:
     * 1. In the ans subarray, MAX & MIN have to be on the corner.
     * 2. In the answer subarray, there will be only one MAX & one MIN.
     * 
     * Solution:
     * => Solns can only be of two types:
     *    (a) Min someother element followed by Max
     *    (b) Max someother element followed by Min.
     * => For every MIN, find the closest MAX on the right side.
     *    MIN . . . . . MAX
     *    MAX . . . . . MIN
     * => For every MAX, find the closest MIN on the right side.
     * 
    */

    /**
     * Code:
     * ans = INTEGER_MAX_VALUE;
     * 
     * => find MAX:
     *    Write finding MAX Code here
     * 
     * => find MIN:
     *    Write finding MIN Code here
     * 
     * for(int i = 0; i < n; i++) {
     *    if(A[i] == MAX) {
     *       for(int j = i+1; j < n; j++) {
     *          if(A[j] == MIN) {
     *             ans = min(ans, j-i+1);
     *             break;
     *          }
     *       }
     *    } else if(A[i] == MAX) {
     *       for(int j = i+1; j < n; j++) {
     *          if(A[j] == MIN) {
     *             ans = min(ans, j-i+1);
     *          }
     *       }
     *    }
     * }
     * 
     * Note: 
     * 1. For each MAX, I want the index of the latest MIN.
     *     min . . . . max
     * 2. For each MIN, I want the index of the latest MAX.
     *     max . . . . min
     * 
     *           0  1  2  3  4  5
     * Example:  6  4  1  2  5  6
     * lat_min:  infin 2  2  2  2
     * lat_max:  0  0  0  0  0  5
     * 
     * => For each iteration, if MAX is found :
     *    ans = min(ans, i - lat_min + 1);
     * 
     * => For each iteration, if MIN is found:
     *    ans = min(ans, i - lat_max + 1);
     * 
     * Remember:
     * 1. "j-i+1" is the length of the subarray.
     * 2. Similar to "ag" question.
     * 
     * TC: O(N^2)
     * SC: O(1)
    */

    /**
     * Step-1: find MAX & MIN
     * Step-2: lat_max = INT_MIN
     *         lat_min = INT_MIN
     * Step-3: For each i
     *           if
    */
}
