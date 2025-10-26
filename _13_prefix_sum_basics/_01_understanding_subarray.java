package _13_prefix_sum_basics;

public class _01_understanding_subarray {

    /**
     * Understanding Subarray:
    */

    /**
     * Subarray:
     * => Continuous part of an array.
     *    1. Complete array is subarray of itself
     *    2. Single element of array is also subarray
     *    3. Empty subarray is not valid.
     * 
     *       0   1   2   3   4   5   6
     * A : [ 3,  4,  5,  6, -2,  8,  10 ]
     * 
     * (a) 3, 5, 6  => Not Subarray
     * (b) -2,      => Subarray
     * (c) 8, 10    => Subarray
     * (c) 8, 10,-2 => Not Subarray
     * (d) 8, 10, 3 => Not Subarray
     * 
     * => Subarray can be defined by 
     *           start and end
     *       0   1   2    3   4    5   6
     * A : [ 4,  2,  10,  3,  12, -2,  15 ]
     * 
     *           s        e
     *           1        1 = Valid
     *           1        2 = Valid
     *           1        3 = Valid
     *           1        4 = Valid
     *           1        5 = Valid
     *           1        6 = Valid
     *           1        7 = Not valid
     * 
     * => ans = 6 subarrays
     * */

    /**
     * Total number of subarrays:
    */

    /**
     * Q. How do you calculate total number of subarrays?
     * => Total no of subarrays:
     *       Subarray starting at idx- 0 
     *        + Subarray starting at idx-1
     *        + Subarray starting at idx-2
     *        + ......
     *        + ......
     *        + Subarray starting at idx-n-1
     * 
     * s e      s e     s e     ........     s   e
     * 0 0      1 1     2 2     ........     n-1 n-1
     * 0 1      1 2     2 3     ........      
     * 0 2      1 3     2 4     ........      
     * ...      ...     ...     ........      
     * ...      ...     ...     ........      
     * 0 n-1    1 n-1   2 n-1   ........      
     * -----    -----   -----               -----
     *   n       n-1     n-2                  1
     * 
     * Sum of 'n' natural numbers (AP):
     * => n + (n-1) + (n-2) + .... + 1
     * => n(n+1) / 2 
     * => Total no of subarrays in any array = n(n+1) / 2 
     * 
     * 
     * Q. What is the total no of subarrays in this array?
     *          0  1  2   3  4    5  6
     * => A = [ 4, 2, 10, 3, 12, -2, 15]
     * 
     * => Total Idx = 7
     * => Total no of subarray in the array = n(n+1) / 2 
     *                                      = 7(7+1) / 2
     *                                      = 56/2
     *                                      = 28 
     * 
     * Note: We are just counting with TC : O(1)
    */

    /**
     * Q. Print all the values of a subarray?
     * 
     * => void printSubarray(int[] A, int s, int e) {
     *       for(int i = s; i <= e; i++) {
     *          print(A[i])
     *       }
     *    }
     * 
     * TC: O(n)
     * SC: O(1)
     * */ 




    /**
     * Total sum of subarrays:
    */

    /**
     * Q. Find sum of all elements of subarray.
     * 
     * => int sumSubArray(int[] A, int s, int e) {
     *       int sum = 0;
     *       for(int i = s, i <= e, i++) {
     *             sum = sum + A[i];
     *          }
     *       return sum;
     *    }
     * 
     * TC: O(N)
     * SC: O(1)
     *    
     * */



    /**
     * Print all subarray:
    */

    /**
     * Q. Print all subarrays of given array.
     *         0   1   2
     * => A = [10, 20, 30]
     * 
     * => 10
     * => 10 20
     * => 10 20 30
     * 
     * Total no of subarrays = n(n+1) / 2
     *                       = 3(3+1) / 2
     *                       = 6
     * 
     * => 10
     *    10 20
     *    10 20 30
     *    20
     *    20 30
     *    30
     * 
     * Logic to print all subarray:
     * 
     * => for(int s = 0; s < n; s++) {
     *       for(int e = s; e < n; e++) {
     *          printSubarray(A, s, e);
     *       }
     *    }
     * 
     * TC: O(n^3)
     * SC: O(1)
    */



    /**
     * Print sum of each subarray:
    */

    /**
     * Q. Print sum of each subarray.
     * 
     * Approach-1:
     * => for(int s = 0; s < n; s++) {
     *       for(int e = s; e < n; e++) {
     *          int sum = sumSubarray(A, s, e); // already written code
     *          print(sum);
     *       }
     *    }
     * 
     * TC: O(N^3)
     * SC: O(1)
     * 
     * 
     * Approach-2:
     * Q. Can you think of some optimization using prefix sum?
     * => Prefix Sum we were using to calculate sum of any range.
     * => Subarray is also a range.
     * => So, we can calculate sum of a subarray using prefix sum.
     * 
     * Q. Whenever you want to use prefix sum, what is the first step?
     * 1. Build the prefix sum array, means declare it and write the
     *    formula.
     *  
     * => starting point = s, ending point = e.
     * 
     * Q. How we calculate sum of this range [s, e] using prefix sum?
     * Q. Can starting point be "0"?
     * => Yes!. 
     * => if(s == 0) { 
     *       (sum = "s" to "e")
     *       a[0] + a[1] + a[2] + ... + a[e] => prefix sum of "e"
     *    }
     * 
     * 
     *    for(int s = 0; s < n; s++) {
     *       for(int e = s; e < n; e++) {
     *          int sum = ;
     *          if(s == 0) {
     *              sum = pfSum[e]
     *          } else {
     *              sum = pfSum[e] - pfSum[s-1];
     *          }
     *          print(sum);
     *       }
     *    }
     * 
     * TC: O(N^2)
     * SC: O(N)
     * 
     * 
     * Q. Can we optimize it even further?
     * => Yes! But first, let's try to solve a simpler problem. 
     * 
    */


    /**
     * Print sum of subarray starting from specific index:
    */

        /**
     * Approach-3:
     * Q. Print sum of all subarrays starting at index-2.
     *      0  1  2   3  4  5  6
     * A = [7, 3, 2, -1, 6, 8, 2]
     * 
     * => s  e      Sum
     *    2  2   => 2
     *    2  3   => 2 + -1
     *    2  4   => 2 + -1 + 6
     *    2  5   => 2 + -1 + 6 + 8
     *    2  6   => 2 + -1 + 6 + 8 + 2
     * 
     * => Try a simple for-loop:
     * 
     *    int sum = 0;
     *    int s = 2;
     * 
     *    for(e = s; e < n; e++) {
     *       sum = sum + A[e];
     *       print(sum);
     *    } 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Note: This logic is for specific index.
     * 
     * Q. How can we print all subarray sums?
     * => Idea: "s" can take all values between [0, n-1].
     * 
     * => for(int s = 0; s < n; s++) {
     *       int sum = 0;
     *       for(int e = s; e < n; e++) {
     *          sum += a[e];
     *          print(sum);
     *       }
     *    }
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * Note:
     * 1. Initially TC: O(N^3)
     * 2. Prefix Sum: TC: O(N^2), SC: O(N)
     * 3. Carry Forward: TC: O(N^2), SC: (1)
     * 
     *         Prefix Sum            Carry Forward
     * => N^3 -------------> N^2, N ---------------> N^2, 1
    */



    /**
     * Sum of all subarray sum:
    */

    /**
     * Asked by : Google, Facebook
     * 
     * Q. Given an array, find the sum of all subarray sums.
     *         0   1   2
     * => A : [10, 20, 30]
     * 
     * Approach-1:
     * => s  e    Sum
     *    0  0 => 10
     *    0  1 => 30
     *    0  2 => 60
     *    1  1 => 20
     *    1  2 => 50
     *    2  2 => 30
     * 
     * Q. Can we use previous code which prints all subarray sums:
     * => Yes!
     * 
     * => int totalSum = 0
     * => for(int s = 0; s < n; s++) {
     *       int sum = 0;
     *       for(int e = s; e < n; e++) {
     *          sum += a[e];
     *          totalSum += sum;
     *       }
     *    }
     *    return totalSum;
     * 
     * TC: O(N^2)
     * SC: O(1)
     */
    
    
    /** 
     * Approach-2:
     * => s  e    Sum    TotalSum   
     *    0  0 => 10  => 10        => a[0]
     *    0  1 => 30  => 40        => a[0]+a[1]
     *    0  2 => 60  => 100       => a[0]+a[1]+a[2]
     *    1  1 => 20  => 120       => a[1]
     *    1  2 => 50  => 170       => a[1]+a[2]
     *    2  2 => 30  => 200       => a[2]
     * 
     * 1. How many times a[0] occurs?
     * 2. How many times a[1] occurs?
     * 3. How many times a[2] occurs?
     * 
     * => Sum = 3a[0] + 4a[1] + 3a[2]
     * 
     * Note: 
     * (a) a[0] has a number multiplied to it.
     * (b) a[1] has a number multiplied to it.
     * (c) a[2] has a number multiplied to it.
     * 
     * Q. What is this multiplier?
     * => Number of subarrays which contain this number a[i].
     * 
     * Q. How many subarrays can a[2] occur in?
     *         0   1   2   3
     * => A = [10, 20, 30, 40]
     * 
     * => 0,0  0,1  0,2  0,3
     *         1,1  1,2  1,3
     *              2,2  2,3
     *                   3,3
     * 
     * => ans = 6
     * 
     * 
     * Quiz:
     * Q. How many subarrays can a[1] have?
     *     0   1  2   3  4  5
     * => [3, -1, 4, -1, 2, 6]
     * 
     * => 0,0  0,1  0,2  0,3  0,4  0,5
     *         1,1  1,2  1,3  1,4  1,5
     *              2,2  2,3  2,4  2,5
     *                   3,3  3,4  3,5
     *                        4,4  4,5
     *                             5,5
     * => ans = 2
     * 
     * Note:  s   e   
     *        0   1
     *        1   2
     *            3
     *            4
     *            5
     * 
     * Q. How many matchings can we get?
     * => If we have "2" elements at "s" and "5" elements at "e", can
     *    we say "2X5 = 10".
     * 
     * => When my "a[i] = 1":
     *    (a) s = 0, 1
     *    (b) e =    1, 2, 3, 4, 5
     * 
     * => When my "a[i] = 3":
     *    (a) s = 0, 1, 2, 3
     *    (b) e = 3, 4, 5
     * 
     * => a[0], a[1], ......, a[i], ......, a[n-1]
     * 
     *          s<=i     e>=i
     *          0        i
     *          1        i+1
     *          2        i+2
     *          ..       ..
     *          ..       ..
     *          i        n-1
     *          [0, i]   [i, n-1]
     * Formula: b-a+1    n-1-i+1
     *          i-0+1    n-i
     *          i+1      n-i
     * Range: [0 to i+1] [i to n-i] 
     *
     * Note:
     * (a) 's' will always less than equal to 'i'.
     * (b) 'e' will always greater than equal to 'i'.
     * => So, 's' ranges from '0 to i' and e ranges from 'i to n-1'
     * 
     * Q. What is the total number of subarrays if we have a[i]?
     * => a[i] = (no of 's') * (no of 'e')
     *         = (i + 1)     * (n - i)
     * 
     * Q. What is the formula of multiplier?
     * => (i+1) * (n-i); 
     * 
     * Code:
     * => int ans = 0;
     *    for(int i = 0; i < n; i++) {
     *       multiplier = (i+1) * (n-i);
     *       ans += multiplier * a[i];
     *    }
     *    return ans;
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * 
     * Dry Run:
     *      0   1   2
     * A = [10, 20, 30]
     * 
     *          Multiplier          ans = Multiplier * a[i]
     *          (i+1) * (n-i)
     * i = 0 => (0+1) * (3-0) => 3  => 3*10 => 30
     * i = 1 => (1+1) * (3-1) => 4  => 4*20 => 80
     * i = 2 => (2+1) * (3-2) => 3  => 3*30 => 90
     *                Total sum of subarray => 200
     * 
     * Note: This is the most optimized version of calculating sum of
     *       subarray [s, e].
    */

    
}
