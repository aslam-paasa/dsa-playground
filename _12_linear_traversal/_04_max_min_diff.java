package _12_linear_traversal;

import java.util.Arrays;

public class _04_max_min_diff {
    /**
     * InterviewBit: Max Min
     * Given an array A[] of size-n, find the minimum and maximum
     * element in the array and return their difference (max - min).
     * 
     * Input: A[] = {1, 3, 7, 2, 5} 
     * Output: 6  => (max = 7, min = 1, result = 7 - 1 = 6)
     * 
     * Input: A[] = {4, 4, 4, 4} 
     * Output: 0  => (max = min = 4, result = 4 - 4 = 0)
    */

    /**
     * Approach-1: Brute Force (Sorting)
     * 1. Sort the array in ascending order
     * 2. The first element is min
     * 3. The last element is max
     * 4. Return max - min 
     * 
     * Steps:
     * 1. Sort the array in ascending order. 
     * 2. The first element (A[0]) is the minimum
     * 3. The last element (A[n-1]) is the maximum
     * 4. Return A[n-1] - A[0]
     * 
     * TC: O(n logn)
     * SC: O(1)
     * 
     * Why this works?
     * - Sorting helps find min & max easily
     * - But sorting is unnecessary when we only need min & max.
    */

    public static int maxMinDifference(int A[]) {
        Arrays.sort(A); 
        return A[A.length - 1] - A[0]; 
    }


    /**
     * Approach-2: Single Pass
     * 1. One scan to find min and max directly. 
     * 2. Iterate through the array once, updating min and max. 
     * 
     * Steps:
     * 1. Initialize: min = Integer.MAX_VALUE,
     *                max = Integer.MIN_VALUE 
     * 2. Traverse the array:
     *    - If A[i] < min, update min = A[i].
     *    - If A[i] > max, update max = A[i].
     * 3. Return (max - min)
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Why this is better?
     * - Faster than sorting O(N) Vs O(N logN)
     * - No extra space used. 
    */

    public static int maxMinDifferenceII(int A[]) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : A) {
            min = Math.min(min, num); // Update min
            max = Math.max(max, num); // Update max
        }

        return max - min; // Difference
    }


    /**
     * Approach-3: Optimized Pairwise Approach[Efficient for large arrays]
     * 1. Instead of scanning on element at a time, compare elements in
     *    pairs to reduce comparisons. 
     * 2. Pairs reduce comparisons from ~2n to ~1.5n.
     * 
     * Steps:
     * 1. Initialize min and max based on the first element (or first two
     *    elements)
     * 2. Traverse the array in pairs:
     *    - Compare both element in a pair. 
     *    - Update min and max accordingly. 
     * 3. Return max - min. 
    */

    public static int maxMinDifferenceIII(int A[]) {
        if (A.length == 0) return 0;

        int min, max, i;

        // Initialize min and max
        if (A.length % 2 == 0) {
            min = Math.min(A[0], A[1]);
            max = Math.max(A[0], A[1]);
            i = 2;
        } else {
            min = max = A[0];
            i = 1;
        }

        // Compare elements in pairs
        while (i < A.length - 1) {
            if (A[i] < A[i + 1]) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i + 1]);
            } else {
                min = Math.min(min, A[i + 1]);
                max = Math.max(max, A[i]);
            }
            i += 2;
        }

        return max - min;
    }
}
