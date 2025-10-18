package _12_linear_traversal;

/**
 * Leetcode-1103: Distribute Candies to People
 * You have 'candies' number of candies and 'numPeople' people 
 * sitting in a row. Distribute the candies in the following way:
 * 1. Give 1 candy to the first person, 2 to the second and so on.
 * 2. If you run out of candies, give the remaining candies to the
 *    next person.
 * 3. Return an array where arr[i] represents the candies received
 *    by the (i+1)th person. 
*/

public class _09_distribute_candies_to_people {

    /**
     * Approach-1: Brute Force
     * 1. Create an array result of size numPeople initialized with 0.
     * 2. Start distributing candies sequentially (1, 2, 3, ...) in a
     *    loop.
     * 3. If candies < currentGive, give all remaining candies.
     * 4. Stop when no candies are left.
     * 
     * TC: O(root(2N)) : The sum of the first k natural numbers is
     *                   k(k+1)/2 ≤ candies, so k ≈ √(2N).
     * SC: O(numPeople) => Stores result in an array
     * 
     * Why is this slow?
     * => Iterates multiple times until all candies are distributed.
    */

    public int[] distributeCandiesI(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 0, give = 1;

        while (candies > 0) {
            result[i % num_people] += Math.min(give, candies);
            candies -= give;
            give++;
            i++;
        }

        return result;
    }


    /**
     * Approach-2: Better
     * TC: O(root(2n)) => Efficient distribution with minimal iterations. 
     * SC: O(numPeople) => Stores result in an array
     * 
     * Why is this better approach?
     * - One loop handles everything efficiently.
    */

    public int[] distributeCandiesII(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 0, give = 1;

        while (candies > 0) {
            result[i % num_people] += Math.min(give, candies);
            candies -= give;
            give++;
            i++;
        }

        return result;
    }

    /**
     * Approach-3: Optimal (Best)
     */

    public int[] distributeCandies(int candies, int num_people) {

        /**
         * 1. Array to store distributed candies
         * 2. Initial num of candies to distribute
         * 3. To track the last person who received candies
         * 4. Count the number of rounds completed
        */
        int[] distribution = new int[num_people]; 
        int candyToGive = 1;
        int lastIndex = 0; 
        int roundCount = 0; 

        /**
         * 5. Continue distributing until all candies are given
         *     a. If enough candies remain, distribute normally.
         *     b. Stop when all candies are distributed.
         *     b. If not enough candies remain, distribute the remaining
         *        candies
         *     c. Increment candy count for the next person
        */
        while (candies > 0) { 
            for (int i = 0; i < num_people; i++) {
                candies -= candyToGive;
                if (candies >= 0) { 
                    distribution[i] += candyToGive;
                    if (candies == 0) { 
                        break;
                    }
                } else { 
                    distribution[i] += candyToGive + candies;
                    lastIndex = i;
                    break;
                }
                candyToGive++; 
            }
            roundCount++;
        }

        /**
         * 6. If some people did not receive candies, ensure they 
         *    remain at 0.
        */
        if (lastIndex != 0 && lastIndex != num_people - 1 && roundCount == 0) {
            for (int i = lastIndex; i < num_people; i++) {
                distribution[i] = 0;
            }
        }
        return distribution;
    }
}
