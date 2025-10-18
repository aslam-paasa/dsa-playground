package _26_rearrange_array;

public class _05_rearrange_array_into_zig_zag_fashion {
    /**
     * GFG: Convert array into Zig-Zag fashion
     * Rearrange array elements in zig-zag fashion such that:
     * a[0] < a[1] > a[2] < a[3] > a[4] ...
     * 
     * Basically, alternate lesser and greater values.
     * You don't need to sort the whole array - just rearrange locally at
     * every pair of elements.
     * 
     * Input  : [4, 3, 7, 8, 6, 2, 1]
     * Output : [3, 7, 4, 8, 2, 6, 1]
     * Pattern: a[0] < a[1] > a[2] < a[3] > a[4] ...
    */

    /**
     * Intuition:
     * You don't need to globally sort the array. Instead, go one pair
     * at a time and fix the order based on the position.
     * 
     * Key Rule:
     * a. At even indices - ensure a[i] < a[i+1]
     * b. At odd indices  - ensure a[i] > a[i+1]
     * 
     * If this condition is nto met - swap the two.
    */

    /**
     * Approach-1: Single Pass Swap
     * 1. Loop from i = 0 to n-2
     * 2. If:
     *    a. i % 2 == 0 -> check: arr[i] < arr[i+1]
     *    b. i % 2 != 0 -> check: arr[i] > arr[i+1]
     * 3. If condition not met - swap
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public void zigZag(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    // Swap if not a < b
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    // Swap if not a > b
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
