package _09_basic_array_problems;

public class _30_prefix_sum {
    /**
     * What is Searching?
     * => Searching is the process of finding some information in a
     *    container depending on some conditions.
     * => Searching is predominant in CP problems.
     * 
     * Important searching algorithms:
     * a. Prefix Sums
     * b. Frequency Arrays
     * c. Binary Search
     * */ 

     public static int[] prefixSumI(int[] arr) {
        int[] prefixSumArr = new int[arr.length];

        prefixSumArr[0] = arr[0]; 
        for(int i = 1; i < arr.length; i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + arr[i];
        }

        return prefixSumArr;
    }


    /**
     * Prefix Sum:
     * => A prefix sum stores the sum of the prefix of an array at
     *    each index. Takes O(N) time complexity to compute:
     * 
     *    prefix[k] = sum of array from 0 to k
     * 
     * 
     * Ex: arr = [1, 3, 4, 7, 9]
     *                               PrefixSum
     * (a) Prefix-1: 1              => 1
     * (b) Prefix-2: 1, 3           => 4
     * (c) Prefix-3: 1, 3, 4        => 8
     * (d) Prefix-4: 1, 3, 4, 7     => 15
     * (e) Prefix-5: 1, 3, 4,, 7, 9 => 24
     *   
     * [1, 4, 8, 15, 25]
     * 
     * Brute Force:
     * int prefix[n];
     * for(int i = 0; i < n; i++) {
     *    for(int j = 0; j <= i; j++) {
     *       prefix[i] += a[j];
     *       print(prefix[i]);
     *    }
     * }
     * 
     * TC: O(N^2) => Slow
     * 
     * Better Approach:
     * int prefix[n];
     * prefix[0] = arr[0];
     * for(int i = 1; i < n; i++) {
     *    prefix[i] = prefix[i-1] + arr[i];
     *    print(prefix[i];)
     * }
     * 
     * TC: O(N)
    */

    /**
     * Range Sum Queries:
     * => Prefix sums can be used to answer queries such as:
     *    "Sum of elements of array from [S, E]" in O(1) TC.
     * 
     * Q. Given an array size N & Q queries of format start "s" & end "e".
     *    Return the sum of elements from indexes "s" to "e" for each query.
     * 
     *             0  1  2  3  4  5  6   7  8  9
     * => arr = [ -3, 6, 2, 4, 5, 2, 8, -9, 3, 1 ]
     * 
     * => Q = 3,
     * => means we have 3 questions:
     *           s = 1 & e = 3 
     *           => sum from [1, 3] = 6 + 2 + 4 => 12
     *              Means what will the sum from "1" & "3".
     * 
     *           s = 2 & e = 7
     *           => sum from [2, 7] = 2 + 4 + 5 + 2 + 8 - 9 => 12
     *              Means what will the sum from "2" & "7".
     * 
     *           s = 0 & e = 2
     *           => sum from [0, 2] = -3 + 6 + 2 = 5
     *              Means what will the sum from "0" & "2".
     *          
     * for(int i = 0; i < q; i++) {
     *    scan(s, e)
     *    int sum = 0; 
     * 
     *    for(j = s; i <= e; j++) {
     *       sum += arr[j];
     *    }
     *    print(sum);
     * }
     * 
     * TC: O(N * Q)
     * 
     * Note: This is the problem we can solve using Prefix Sum.
     * */ 

    /**
     * Prefix Sum:
     * => Best example of prefix sum is Cricket. We must have seen the
     *    scoreboard.
     * 
     * Example: 
     * Score of the last 10 overs in ODI.
     * over     41   42   43   44   45   46   47   48   49   50
     * runs = [ 288, 312, 330, 349, 360, 383, 394, 406, 436, 439]
     * 
     * => Runs score in the last 5 overs:
     *    No of runs scored in overs [46, 50]
     *   (a) Run scored at 50th over  -  Runs at the end of 45th over
     *    => 439                      -  360
     *    => 79
     * 
     * => Runs score in the 49th over
     *    (a) Runs at 49th over - Runs at 48th over
     *     => 436               - 406
     *     => 30 
     * 
     * => Runs scored in overs [42, 45]
     *    (a) Runs scored at 45th over - Runs scored at 41st over
     *     => 360                      - 288
     *     => 72
     * 
     * Note: The score board of Cricket is "Prefix Sum". Because it tell
     *       us sum of all the values which is all the scored in the over
     *       till that point. [Sum of all the values till that point]
    */

    /**
     * Prefix Sum is sum of all values till that point. And Cricket Score
     * board is best example.
     * => score = 3  6  2  1
     *    sum   = 3  9 11  12 [This is how cricket scoreboard is shown]
     * => Till each over we are telling what is the total score, not telling
     *    you what is the actual score in that over. So, this total score
     *    is known as Prefix Sum.
     * 
     * 
     *             0   1   2   3   4   5   6    7   8   9
     * => arr = [ -3,  6,  2,  4,  5,  2,  8,  -9,  3,  1 ]
     *    ps  =   -3   3   5   9  14  16  24   15  18  19
     * 
     * => ps[i] => Total sum of all values till idx-i.
     *    ps[0] => arr[0]
     * 
     *    ps[1] => arr[0]+arr[1]
     *             ps[0]
     * 
     *    ps[2] => arr[0]+arr[1]+arr[2]
     *             <---ps[1]--->
     * 
     *    ps[3] => ps[2] + arr[3]
     *    ps[4] => ps[3] + arr[4]
     * 
     * => ps[i] = ps[i-1] + arr[i] (formula)
     * Note: But we don't use this formula for ps[0].
    */

    /**
     * Build Prefix Sum:
     * int ps[n];   (same size as arr[])
     * ps[0] = arr[0];   
     * 
     * for(int i = 1; i < n; i++) {
     *    ps[i] = ps[i-1] + arr[i]
     * }
     * 
     * TC: O(n)
     * SC: O(n) => (ps array)
     */ 
    
    /** 
     * Q. What is the sum of all elements with indexes in the range
     *    [s,e] (both inclusive)?
     * 
     * Sum from "s" to "e":
     * => as + as+1 + as+2 + ... + ae
     *   +(a0 + a1 + a2 + ... + as+1) 
     *   -(a0 + a1 + a2 + ... + as+1)
     * 
     * => a0 + a1 + .... + as-1 + as + as+1 + ... + ae
     * => ps[e] - ps[s-1]
     * 
     * +--------------------------+
     * |  |  |  |  |  |  |  |  |  |
     * +--------------------------+
     *          s              e
     * <------->+<------------>=<->
     *      I   +       II     = III 
     *  ps[s-1]     sum[s:e]   = ps[e]
     *  sum[s:e] = ps[e] - ps[s-1]
     *  
     * 
     * # Answer Q-Queries:
     * 1. Build Prefix Sum O(N)
     * 2. For each query, answer using the formula O(Q)
     * 
     * Total TC: O(N+Q)
     * Total SC: O(N)
     * 
     * Note: TC reduced from "N*Q" to "N+Q", but SC increased to O(N).
     *       And Prefix Sum is the most important and most optimized
     *       for calculating sum.
    */
}
