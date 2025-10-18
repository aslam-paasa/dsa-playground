package _13_prefix_sum_basics;

/**
 * Leetcode-1732: Find the Highest Altitude
 * You are given an integer array gain where gain[i] represents
 * the net gain in altitude between the ith and (i-1)th points.
 * The starting altitude is 0. Return the highest altitude reached.
 * 
 * - Input : gain = [-5, 1, 5, 0, -7]
 * - Output: 1
 * - Explanation:
 *   - Starting altitude   = 0
 *   - After first change  =  0 + (-5) = -5
 *   - After second change = -5 +   1  = -4
 *   - After third change  = -4 +   5  = 1 (highest)
 *   - After fourth change =  1 +   0  = 1
 *   - After fifth change  =  1 + (-7) = -6
 * 
 * - Highest altitude = 1
*/

public class _03_find_the_highest_altitude {

    /**
     * Approach-1: Brute Force (Cumulative Sum Calculation)
     * 1. Start from altitude = 0
     * 2. Create an array altitudes of size gain.length + 1
     * 3. First position of altitude will be 0(initial altitude)
     * 4. Traverse through gain and calculate each altitude using:
     *    altitudes[i] = altitudes[i - 1] + gain[i - 1]
     * 5. Find the maximum value from the altitudes array. 
     * 6. Return the maximum altitude. 
     * 
     * TC: O(n) => One loop to calculate altitudes and another loop 
     *             to find the maximum
     * SC: O(n) => Extra array altitudes of size n+1
    */

    public static int largestAltitudeI(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0; // Starting point

        /**
         * 1. Altitude calculate karo
        */
        for (int i = 1; i <= n; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
        }

        /**
         * 2. Maximum altitude find karo
        */
        int maxAltitude = Integer.MIN_VALUE;
        for (int alt : altitudes) {
            maxAltitude = Math.max(maxAltitude, alt);
        }

        return maxAltitude;
    }


    /**
     * Approach-2: Better Approach(Calculate on the fly)
     * 1. Initialize two variables:
     *    - currentAltitude = 0 (for the current position)
     *    - maxAltitude = 0 (to track the highest altitude)
     * 2. Traverse through gain array:
     *    - Add gain[i] to currentAltitude
     *    - Update maxAltitude using Math.max()
     * 3. Return maxAltitude
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public static int largestAltitudeII(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        /**
         * Gain array ko traverse karke max altitude calculate karo:
        */
        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}
