package _09_basic_array_problems;

public class _32_prefix_sum_problem {
    /**
     * Direct Question asked in: DirectI, Flipkart
     * 
     * Q. Given an array & Q queries
     * => s, e, O => return sum of all odd indexed element in [s, e]
     * => s, e, E => return sum of all even indexed element in [s, e]
     * 
     *      0  1  2   3  4  5  6  7
     * A: [ 2, 3, 1, -1, 0, 8, 5, 4 ]
     * 
     * Q: 2
     *       s   e  O/E
     *       3   6  O
     *       1   5  E
     * 
     * Odd index:
     * => a[3] + a[5]
     * => 7
     * 
     * Even index:
     * => a[2] + a[4]
     * => 1
     * 
     * PSEven = sum of all even idx elements till now
     * PSOdd  = sum of all odd idx elements till now
     * 
     * 
     * Example:
     *     0  1  2  3  4  5
     * A: [2, 3, 1, 6, 4, 5]
     * 
     * (a) PSEven = 2  2  3  3  7  7 [take even idx, ignore odd idx]
     * (b) PSOdd  = 0  3  3  9  9 14 [take odd idx, ignore even idx]
     * 
     * Formula:
     * Sum of even idx elements in range [s, e] = PSEven[e] - PSEven[s-1]
     * Sum of odd idx elements in range [s, e]  = PSOdd[e] - PS[s-1]
     * 
     * 
     * Step-1: Build PS Even O(N)
     * Step-2: Build PS Odd  O(N)
     * Step-3: Answer queries based on Odd/Even O(Q)
     * 
     * TC: O(N + Q)
     * SC: O(N)
     * */ 
}
