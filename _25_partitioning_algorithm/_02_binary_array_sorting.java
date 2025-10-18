package _25_partitioning_algorithm;

public class _02_binary_array_sorting {
    /**
     * GFG: Binary Array Sorting
     * You're given a binary array(only 0s and 1s). Sort the array in
     * ascending order (all 0s first, then all 1s).
     * 
     * Input : [1, 0, 1, 0, 1, 0, 0, 1]
     * Output: [0, 0, 0, 0, 1, 1, 1, 1]
    */

    /**
     * Approach-1: Brute Force (In-Place)
     * 1. Count the number of 0s and 1s
     * 2. Fill the array: 
     *    a. first with 0s
     *    b. then with 1s
     * 
     * Steps:
     * 1. Intialize zeroCount = 0
     * 2. Loop through the array:
     *    a. If arr[i] == 0, increase zeroCount
     * 3. Loop again:
     *    a. First zeroCount elements - set to 0
     *    b. Rest - set to 1
     * 
     * TC: O(2n) = O(n)
     * SC: O(1)
    */

    public static void sortBinaryArrayBruteForce(int[] arr) {
        int zeroCount = 0;

        // Count zeros
        for (int num : arr) {
            if (num == 0) zeroCount++;
        }

        // Fill with 0s and 1s
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < zeroCount ? 0 : 1;
        }
    }


    /**
     * Approach-2: Extra Space
     * 1. Use a temporary array
     * 2. Add all 0s first, then all 1s to it
     * 3. Copy back to original array
     * 
     * Steps:
     * 1. Create a new array of same size
     * 2. First loop  : copy all 0s to temp
     * 3. Second loop : copy all 1s to temp
     * 4. Copy temp back to arr
     * 
     * TC: O(n)
     * SC: O(n)
    */

    public static void sortBinaryArrayWithExtraSpace(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;

        for (int num : arr) {
            if (num == 0) temp[index++] = 0;
        }

        for (int num : arr) {
            if (num == 1) temp[index++] = 1;
        }

        // Copy back to original
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }


    /**
     * Approach-3: Partitioning Algorithm (Lomuto Style)
     * Idea: 
     * 1. pivot = 1
     * 2. Move all 0s to left
     * 
     * Steps:
     * 1. Start with i = -1 (the parition pointer)
     * 2. Loop j = 0 to n-1
     *    a. If arr[j] < 1 (i.e., arr[j] == 0):
     *       - Increase i
     *       - Swap arr[i] and arr[j]
     * 3. Done!
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public static void sortBinaryArrayPartitioning(int[] arr) {
        int i = -1;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 1) {  // i.e., arr[j] == 0
                i++;
                // Swap 0 to left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * Dry Run:
     * Input: [1, 0, 1, 0]
     * i = -1
     * 
     * j = 0 -> arr[0] = 1 -> no swap
     * j = 1 -> arr[1] = 0 -> swap(arr[0], arr[1]) -> [0, 1, 1, 0]
     * j = 2 -> arr[2] = 1 -> no swap
     * j = 3 -> arr[3] = 0 -> swap(arr[1], arr[3]) -> [0, 0, 1, 1]
     * 
     * BOOM! One Pass and sorted!
     */ 
}
