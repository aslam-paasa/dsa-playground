package _12_linear_traversal;

/**
 * Leetcode-1266: Minimum Time Visiting All Points
 * - You are given an array points where points[i] = [xi, yi]
 *   represents a point on a 2D plane. 
 * - You must visit all the points in order and return the minimum
 *   time required to travel.
 * 
 * Movement Rules:
 * - In one second, you can:
 *   a. Move horizontally (left/right) by 1 unit.
 *   b. Move vertically (up/down) by 1 unit.
 *   c. Move diagonally (↖ ↗ ↘ ↙) by 1 unit.
 * - The minimum time between two points (x1, y1) and (x2, y2) is
 *   max(|x2 - x1|, |y2 - y1|). 
*/

public class _12_min_time_visiting_all_pointers {

    /**
     * Approach-1: Brute Force (Simulating Step-by-Step Movement)
     * 1. Initialize totalTime = 0
     * 2. Start from the first point and move step by step to the next
     *    point.
     * 3. Prefer diagonal moves if both x and y need to charge.
     * 4. If only one coordinate remains different, move horizontally
     *    or vertically. 
     * 5. Repeat this process for all consecutive points.
     * 
     * TC: O(N * d) => Moves one step at a tome (d is the distance b/w
     *                 points)
     * SC: O(1)     => Only uses an integer variable totalTime.
     * 
     * Why is this slow?
     * - Simulates each movement, making it inefficient for large
     *   distances.
    */

    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];

            int x2 = points[i][0]; 
            int y2 = points[i][1];

            /**
             * Move diagonally first, then adjust x or y if needed:
             * 1. Move right
             * 2. Move left
             * 3. Move up
             * 4. Move down
             * 5. Each move takes 1 second
            */
            while (x1 != x2 || y1 != y2) {
                if (x1 < x2) x1++; 
                else if (x1 > x2) x1--;

                if (y1 < y2) y1++;
                else if (y1 > y2) y1--;

                totalTime++;
            }
        }
        return totalTime;
    }

    /**
     * Approach-2: Optimized Approach (Using Distance Formula directly)
     * 1. Instead of simulating movement, compute the direct minimum
     *    time between two points using:
     *    => time=max(∣x2 − x1∣ , ∣y2 − y1∣)
     * 2. This formula works because:
     *    - A diagonal move covers both x and y simultaneously. 
     *    - The remaining distance (if any) is just horizontal or 
     *      vertical moves. 
     * 3. Iterate through all consecutive points and sum up the times.
     * 
     * TC: O(N) => We visit each point once and calculate distance in
     *             constant time.
     * SC: O(1) => Use only a few integer variables.
     * 
     * Why is this best approach?
     * - Direct formula eliminates unnecessary step-by-step movement.
     * - Runs in linear time O(N) 
    */

    public int minTimeToVisitAllPointsII(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0], y1 = points[i - 1][1];
            int x2 = points[i][0], y2 = points[i][1];

            /**
             * Direct formula to calculate minimum time:
            */
            totalTime += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        }

        return totalTime;
    }
}
