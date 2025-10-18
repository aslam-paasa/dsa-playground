package _12_linear_traversal;

/**
 * Leetcode-997: Find the Town Judge
 * In a town of N people (labeled 1 to N), a town judge is defined
 * as:
 * 1. The judge trusts no one.
 * 2. Everyone except the judge trusts the judge.
 * 
 * You are given an array trust[i] = [a, b], meaning a trusts b.
 * Find the town judge or return -1 if no judge exists.
*/

public class _16_celebrity_problem_II {

    /**
     * Approach-1: Brute Force (Check Each Person)
     * 1. Iterate over each person i and assume they are the judge.
     * 2. Check two conditions:
     *    a. i does not trust anyone. 
     *    b. i is trusted by everyone else (N - 1 people). 
     * 3. If a person satisfies both conditions, return their idx.
     * 4. If no town judge is found, return -1. 
     * 
     * TC: O(N^2) => For each person, we check the entire trust array 
     *               twice.
     * SC: O(1)
     * 
     * Why is this slow?
     * - Nested loops make it inefficient for large N.
    */

    public int findJudge(int N, int[][] trust) {
        for (int i = 1; i <= N; i++) {
            boolean isJudge = true;

            /**
             * 1. Judge should not trust anyone:
            */
            for (int[] t : trust) {
                if (t[0] == i) { 
                    isJudge = false; 
                    break;
                }
            }

            /**
             * 2. Trusted by everyone else:
             *    - Count how many trust this person
             *    - Trusted by everyone else
            */
            if (isJudge) {
                int count = 0;
                for (int[] t : trust) {
                    if (t[1] == i) count++;
                }
                if (count == N - 1) return i;
            }
        }

        return -1;
    }


    /**
     * Approach-2: Using In-Degree and Out-Degree Count
     * 1. Maintain two arrays:
     *    - trustCount[i]: How many trust person i.
     *    - trustedByCount[i]: How many people i trusts. 
     * 2. Iterate through trust[] and update both counts. 
     * 3. Find the person with: 
     *    - trustCount[i] == N-1 (trusted by everyone except themselves)
     *    - trustedByCount[i] == 0 (trusts no one).
     * 4. Return that person's idx or -1 if no such person exists. 
     * 
     * TC: O(N) => Single pass through trust array.
     * SC: O(N) => Uses two arrays of size N+1. 
     * 
     * Why is this better?
     * - Uses extra space but reduces nested loops. 
    */

    public int findJudgeII(int N, int[][] trust) {
        int[] trustCount = new int[N + 1];
        int[] trustedByCount = new int[N + 1];

        /**
         * 1. Increase count for person who is trusted
         * 2. Increase count for person who trusts others
        */
        for (int[] t : trust) {
            trustCount[t[1]]++;
            trustedByCount[t[0]]++; 
        }

        for (int i = 1; i <= N; i++) {
            if (trustCount[i] == N - 1 && trustedByCount[i] == 0) {
                return i;
            }
        }

        return -1;
    }


    /**
     * Approach-3: Single Array Counting
     * 1. Use one array trustScore[i]:
     *    - If i trusts someone, decrease trustScore[i] (-1).
     *    - If i is trusted by someone, increase trustScore[i] (+1). 
     * 2. The town judge will have a trust score of n-1. 
     * 3. Iterate through trustScore[] to find the judge. 
     * 
     * TC: O(N) => Single pass through trust and single check for the
     *             judge. 
     * SC: O(N) => Uses one array. 
     * 
     * Why is this the best approach?
     * - Minimizes operations by using a single array. 
     * - Fast and space-efficient with a single loop pass. 
    */

    public int findJudgeIII(int N, int[][] trust) {
        int[] trustScore = new int[N + 1];

        for (int[] t : trust) {
            trustScore[t[0]]--;  // Decrease for trusting someone
            trustScore[t[1]]++;  // Increase for being trusted
        }

        for (int i = 1; i <= N; i++) {
            if (trustScore[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}
