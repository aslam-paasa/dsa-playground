package _12_linear_traversal;


/**
 * GFG: Max and Min of an Array using Min Num of Comparisons
 * Given an array A[] and size n, find the min and max element
 * using the min num of comparisons.
 * 
 * Input : A[] = {1, 3, 7, 2, 5}
 * Output: min = 1. max = 7
 * 
 * Input : A[] = {4, 4, 4, 4}
 * Output: min = 4, max = 4
*/

public class _03_max_min {

    /**
     * Approach-1: Brute Force (Linear Search)
     * 1. Scan the array and find the min and max separately. 
     * 2. This takes 2(n-1) comparisons in the worst case.
     * 
     * Steps:
     * 1. Initialize min = A[0] and max = A[0]
     * 2. Traverse the array: 
     *    - If A[i] < min, update min = A[i]
     *    - If A[i] > max, update max = A[i]
     * 3. Return min and max
     * 
     * TC: O(N)
     * SC: O(1) => Only min and max var are used.
     * 
     * Why is this not optimal?
     * - It performs 2 comparisons per element i.e. 2(n-1)
     *   (one for min, one for max).
    */

    public static void findMinMaxI(int A[]) {
        int min = A[0], max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) min = A[i];  // Update min
            if (A[i] > max) max = A[i];  // Update max
        }

        System.out.println("Min: " + min + ", Max: " + max);
    }


    /**
     * Approach-2: Pairwise Comparison
     * 1. Instead of checking each element separately, compare pairs
     *    of elements.
     * 2. This reduces comparisons from 2(n-1) to ~1.5n. 
     * 
     * Steps: 
     * 1. If n is even, initialize min and max using the first two
     *    elements. 
     * 2. If n is odd, initialize min and max using first element and
     *    start checking from idx-1. 
     * 3. Traverse the array in pairs: 
     *    - Compare two elements at a time. 
     *    - Update min and max accordingly. 
     * 4. Return min and max. 
     * 
     * TC: O(N)
     * SC: O(1) => Only min, max and i var are used.
     *
     * Comparisons:
     * - 3n/2 - 2 comparisons for even    [~1.5n comparisons]
     * - 3(n-1)/2 - 2 comparisons for odd [~1.5n comparisons]
     *
     * Why is this better?
     * - Reduces the number of comparisons by ~25%
     * - Works best for large arrays. 
    */

    public static void findMinMaxII(int A[]) {
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

        System.out.println("Min: " + min + ", Max: " + max);
    }


    /**
     * Approach-3: Divide and Conquer
     * 1. Divide the array into two halves recursively. 
     * 2. Find min and max in each half. 
     * 3. Combine results by comparing min and max from both halves. 
     * 4. Reduces comparisons to ~1.5n.
     * 
     * Steps:
     * 1. Base Case: If n == 1, return min = max = A[0]. 
     * 2. Recursive Case: 
     *    - Divide the array into two halves. 
     *    - Recursively find min1, max1 in left halves. 
     *    - Recursively find min2, max2 in right halves. 
     *    - Combine: min = min(min1, min2)
     *               max = max(max1, max2)
     * 
     * TC: O(N)    => Recursion still process all elements
     * SC: O(logN) => Due to recursive fn calls
     * 
     * Comparisons: ≈1.5n (Same as pairwise approach).
     * 
     * Why is this useful?
     * - Parallelizable → Can be used in multi-threading scenarios. 
     * - Good for large data sets where recursion is beneficial. 
    */

    public static void findMinMaxIII(int A[], int low, int high, int[] minMax) {
        // Base Case: Only one element
        if (low == high) {
            minMax[0] = Math.min(minMax[0], A[low]);
            minMax[1] = Math.max(minMax[1], A[low]);
            return;
        }

        // Base Case: Two elements
        if (high == low + 1) {
            minMax[0] = Math.min(minMax[0], Math.min(A[low], A[high]));
            minMax[1] = Math.max(minMax[1], Math.max(A[low], A[high]));
            return;
        }

        // Recursive Case: Split into two halves
        int mid = (low + high) / 2;
        findMinMaxIII(A, low, mid, minMax);
        findMinMaxIII(A, mid + 1, high, minMax);
    }
}
