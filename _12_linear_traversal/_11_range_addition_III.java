package _12_linear_traversal;

/**
 * Leetcode-598: Range Addition II
 * You have a m x n matrix initialized with all 0s. Given an array
 * of operations ops, where each operation is (a, b), it means:
 * - Increment all elements in the top-left a x b submatrix by 1.
 * - Find the max integer's count in the matrix after performing
 *   all operations.
*/

public class _11_range_addition_III {

    /**
     * Approach-1: Brute Force (Simulating Matrix Updates)
     * 1. Create a 2D matrix of size m x n initialized with 0s.
     * 2. Iterate through ops, and for each operations (a, b), update
     *    the first a rows and b columns by increasing their values.
     * 3. After all operations, count the number of maximum values in
     *    the matrix. 
     * 
     * TC: O(k * m * n) ≈ O(K * m * n)
     *     For k operations, each modifying a large submatrix. 
     * 
     * SC: O(m * n) => For storing the matrix
     * 
     * Why is this slow?
     * - Updating the entire matrix is inefficient for large m, n.
    */

    public static int maxCountI(int m, int n, int[][] ops) {
        int[][] matrix = new int[m][n];

        // Apply each operation
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    matrix[i][j]++;
                }
            }
        }

        // Find the maximum value and count occurrences
        int maxVal = 0, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    count = 1;
                } else if (matrix[i][j] == maxVal) {
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * Approach-2: Better Approach(Tracking Overlapping Regions)
     * 1. The most incremented part of the matrix is the smallest 
     *    submatrix affected by all operations. 
     * 2. Instead of updating a matrix, find the smallest a and b 
     *    from ops. 
     * 3. The result is minRow x minCol since all elements in this
     *    region have the highest value. 
     * 
     * TC: O(k) => Iterate through ops once
     * SC: O(1) => Only two integer variables minRow and minCol
     * 
     * Why is this better?
     * - Avoids matrix updates completely by tracking the smallest
     *   affected region. 
     * - No extra memory usage.
     * - Linear time complexity instead of quadratic. 
    */

    public static int maxCountII(int m, int n, int[][] ops) {
        int minRow = m, minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }
}
