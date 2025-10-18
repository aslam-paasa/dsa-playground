package _12_linear_traversal;

/**
 * GFG: The Celebrity Problem
 * A party has N people. A celebrity is someone who:
 * 1. Knows no one at the party.
 * 2. Is known by everyone else at the party.
 * 
 * Find the celebrity(if one exists) using a matrix M[][], where:
 * - M[i][j] == 1 → Person i knows person j.
 * - M[i][j] == 0 → Person i does not know person j.
 * 
 * If a celebrity exists, return their idx; otherwise, return -1.
*/

public class _15_celebrity_problem {

    /**
     * Approach-1: Brute Force (Check each person)
     * 1. Iterate over each person i, and assume they are celebrity.
     * 2. Check two conditions:
     *    - They should not know anyone (M[i][j] == 0 for all j). 
     *    - Everyone else show know them (M[j][i] == 1 for all j ≠ i).
     * 3. If a person satisfies both conditions, return their idx.
     * 4. If no celebrity is found, return -1. 
     * 
     * TC: O(N^2) => Checking each person against all others.
     * SC: O(1)
     * 
     * Why is this slow?
     * - Nested loops make it inefficient for large N.
    */

    public int findCelebrityI(int n, int[][] M) {
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (M[i][j] == 1 || M[j][i] == 0) { 
                        isCelebrity = false;
                        break;
                    }
                }
            }

            if (isCelebrity) return i;
        }

        return -1;
    }


    /**
     * Approach-2: Using In-Degree and Out-Degree Count
     * 1. Maintain two arrays:
     *    - inDegree[i]  => Count of people who know i. 
     *    - outDegree[i] => Count of people i knows. 
     * 2. Iterate through M[i][j] and update the in-degree and out-degree
     *    counts. 
     * 3. Find the person with inDegree[i] == N-1 and outDegree[i] == 0.
     * 4. Return that person's idx, or -1 if no such person exists. 
     * 
     * TC: O(N^2) => Still iterates over all N x N elements.
     * SC: O(N)   => Extra space for in-degree and out-degree arrays.
     * 
     * Why is this better?
     * - Uses extra space for speed up celebrity verification but still
     *   inefficient. 
    */

    public int findCelebrityII(int n, int[][] M) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Approach-3: Two Pointer Elimination
     * 1. Start with two pointers: left = 0 & right = N - 1
     * 2. Use elimination:
     *    - If M[left][right] == 1, left cannot be the celebrity:
     *      = Move left forward
     *    - Otherwise, right cannot be the celebrity:
     *      = Move right forward
     * 3. At the end, only one person remains, assume them as candidate. 
     * 4. Verify if they are true celebrity by checking:
     *    - M[candidate][j] == 0 for all j (they know no one).
     *    - M[j][candidate] == 1 for all j ≠ candidate(everyone knows them)
     * 5. Return the candidate's idx or -f if verification fails. 
     * 
     * TC: O(N) => Find celebrity in one pass and verifies another pass. 
     * SC: O(1)
     * 
     * Why is this the best approach?
     * - Elminates unnecessary checks by reducing the problem to a single
     *   pass solution. 
     * - Does not use extra space like the in-degree/out-degree method. 
    */

    public int findCelebrityIII(int n, int[][] M) {
        int candidate = 0;
        
        /**
         * 1. Find potential celebrity using elimination
         *    - Candidate knows i, so candidate cannot be a celebrity
        */
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) { 
                candidate = i;
            }
        }

        /**
         * 2. Verify if the candidate is a real celebrity
         *    - Candidate is not a celebrity
        */
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) { 
                    return -1;
                }
            }
        }

        return candidate;
    }
}
