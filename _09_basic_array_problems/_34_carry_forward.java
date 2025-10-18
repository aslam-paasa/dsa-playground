package _09_basic_array_problems;

public class _34_carry_forward {
    /**
     * Carry Forward:
     * => Related to previous session, but not continuous.
     * => It is a technique, which we instinctively know how carry
     *    forwarding works.
     * => Example of Carry Forward, Prefix Sum.
     * 
     * Prefix Sum:
     * => PS[i] = PS[i-1] + Arr[i]
     * => This formula suggest prev PS[i-1] to calculate the next value
     *    PS[i].
     * => Using this formula, we can say, we are forwarding the sum.
     *    (PS[i-1] is getting added to Arr[i] or we can say this is
     *     carrying forwarding the previous sum).
     * */ 

    /**
     * Q. Given an array, Build leftMax array.
     *    leftMax[i] = max value in the given array from idx-0 to i.
     * 
     *           0  1  2  3  4  5  6   7
     * A:       -3, 6, 2, 4, 5, 2, 8, -9
     * leftMax: -3  6  6  6  6  6  8   8
     * 
     * 
     * leftMax[0] = a[0]
     * leftMax[1] = max(a[0], a[1])
     * leftMax[2] = max(leftMax[1], arr[2])
     * ...
     * ...
     * leftMax[i] = max(leftMax[i-1], arr[i])
    */

    /**
     * Code:
     * 
     * int[] leftMax = new int[n];
     * 
     * leftMax[0] = a[0]
     * for(int i = 1; i < n; i++) {
     *    leftMax[i] = max(leftMax[i-1], a[i])
     * }
     * 
     * TC: O(n)
     * SC: O(n)
     * 
     * Note: It is very much related to Prefix Sum, but not same.
    */

    /**
     * 1. Build rightMax array:
     * => rightMax[i] = Maximum of all values from idx[i, n-1]
     * 
     *            0  1  2  3  4  5   7
     * A:        -3, 6, 2, 4, 5, 2, -9
     * rightMax:  6  6  5  5  5  2  -9
     *            <----------------------
     * 
     * rightMax[n-1] = A[n-1]
     * rightMax[n-2] = max(A[n-1], A[n-2])
     *               = max(rightMax[n-1], A[n-2])
     * rightMax[n-3] = max(rightMax[n-2], A[n-3])
     * ...
     * ...
     * rightMax[i] = max(rightMax[i+1], A[i])
    */

    /**
     * Code:
     * 
     * int[] rightMax = new int[n];
     * 
     * rightMax[n-1] = A[n-1]
     * for(int i = n-2; i >= 0; i--) {
     *    rightMax[i] = max(rightMax[i+1], A[i])
     * }
     * 
     * TC: O(n)
     * SC: O(n)
    */

}
