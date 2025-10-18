package _25_partitioning_algorithm;

import java.util.ArrayList;
import java.util.List;

public class _04_dual_pivot_partitioning {
    /**
     * GFG: Three way partitioning
     * You are given:
     * a. An array arr[]
     * b. Two integers 'a' and 'b'
     * 
     * Task: Rearrange the array so that:
     * a. All elements < a come first
     * b. All elements in [a, b] come next
     * c. All elements > b come last
     * 
     * Input : arr = [1, 4, 3, 2, 5], a = 2, b = 3
     * Output: [1, 2, 3, 4, 5]
     * 
     * Note: This is DNF with a custom pivot range [a, b]
    */

    /**
     * Approach-1: Brute Force
     * 1. Create three ArrayLists:
     *    a. left for elements < a
     *    b. middle for elements in a <= x <= b
     *    c. right for elements > b
     * 2. Loop through the original array:
     *    a. Add each element to the correct list
     * 3. Overwrite arr[] by combining the three lists
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space (Not In-Place)
     */

     public static void threeWayPartitionBruteForce(int[] arr, int a, int b) {
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < a) left.add(num);
            else if (num <= b) middle.add(num);
            else right.add(num);
        }

        int index = 0;
        for (int num : left) arr[index++] = num;
        for (int num : middle) arr[index++] = num;
        for (int num : right) arr[index++] = num;
    }


    /**
     * Approach-2: Count + Fill
     * 1. Count how many elements go into each other
     * 2. Create a temp array to store the result
     * 3. Fill values in order based on range
     * 4. Copy back to arr[]
     * 
     * TC: O(n)
     * SC: O(n) - Extra Space (Not In-Place)
     * 
     * Steps:
     * 1. Create temp array of same size
     * 2. First loop  - fill elements < a
     * 3. Second loop - fill elements [a, b]
     * 4. Third loop  - fill elements > b
     * 5. Copy temp back to arr[]
    */

    public static void threeWayPartitionCountAndFill(int[] arr, int a, int b) {
        int[] temp = new int[arr.length];
        int idx = 0;

        for (int num : arr) if (num < a) temp[idx++] = num;
        for (int num : arr) if (num >= a && num <= b) temp[idx++] = num;
        for (int num : arr) if (num > b) temp[idx++] = num;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }


    /**
     * Approach-3: Dutch National Flag Algorithm (In-Place Partitioning)
     * Use 3-pointers: low, mid, high to divide the array in 3 parts:
     * 1. < a at beginning
     * 2. [a, b] in middle
     * 3. > b at end
     * 
     * Steps:
     * 1. Initialize: low = 0, mid = 0, high = n-1
     * 2. While mid <= high:
     *    a. If arr[mid] < a:
     *       - swap(arr[low], arr[mid])
     *       - low++, mid++
     *    b. If arr[mid] > b:
     *       - swap(arr[mid], arr[high])
     *       - high--
     *    c. If arr[mid] in [a, b]:
     *       - mid++
     * 3. Done!
     * 
     * TC: O(n)
     * SC: O(1) - In-Place
    */

    public static void threeWayPartition(int[] arr, int a, int b) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < a) {
                swap(arr, low++, mid++);
            } else if (arr[mid] > b) {
                swap(arr, mid, high--);
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
