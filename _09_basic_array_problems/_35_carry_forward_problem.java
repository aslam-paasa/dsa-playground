package _09_basic_array_problems;

public class _35_carry_forward_problem {
    /**
     * Question asked in: Amazon
     * 
     * Q. Given a string of lowercase characters, return the count of
     *    pairs (i,j) such that
     *    (a) i < j
     *    (b) s[i] = 'a'
     *    (c) s[j] = 'g'
     * Note: s[i] always 'a' & s[j] always 'g'.
     * 
     * Example:
     *       0  1  2  3  4  5
     * => S: a  b  e  g  a  g
     * 
     * (a) Idx : (0, 3)
     * (b) Idx:  (0, 5)
     * (c) Idx:  (4, 5)
     * ans => 3
     * */ 

    /**
     * Code:
     * 
     * ans = 0;
     * for(int i = 0; i < n; i++) {
     *    for(int j = i+1; j < n; j++) {
     *       if(s[i] == 'a' && s[j] == 'g') {
     *          ans++;
     *       }
     *    }
     * }
     * return ans;
     * 
     * TC: O(n^2)
     * SC: O(1)
    */

    /**
     * Observation:
     * => Every 'g' will make a valid pair, will all the 'a' on the
     *    left side.
     * 
     *          0  1  2  3  4  5  6  7
     * Example: a  c  b  a  g  k  a  g
     * count a: 1  1  1  2  2  2  3  3
     * ans    : 0  0  0  0  2  2  2  5
     * 
     * 
     * Code:
     * 
     * ans = 0;
     * count_a = 0;
     * 
     * for(int i = 0; i < n; i++) {
     *    if(s[i] == 'a') {
     *       count_a++;
     *    } else if(s[i] == 'g') {
     *       ans += count_a;
     *    } 
     * }
     * return ans;
     * 
     * TC: O(N)
     * SC: O(1)
     * 
    */
}
