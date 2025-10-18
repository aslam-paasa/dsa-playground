package _25_partitioning_algorithm;

public class _01_partitioning_platform {
    /**
     * Partitioning Algorithm:
     * If we master this algorithm, we'll unlock:
     * 1. Quick Sort
     * 2. Quick Select
     * 3. Kth largest/smallest element
     * 4. Dutch National Flag Problem
     * 5. Solving many problems in O(n) instead of O(nlogn)
     */

    /**
     * What is a Partitioning Algorithm?
     * - Imagine this:
     *   You're given an unsorted array and a pivot element.
     *   Your goal is to rearrange the array so that:
     *   a. All elements less than pivot are on the left
     *   b. All elements equal to pivot are in the middle
     *   c. All elements greater than pivot are on the right
     *   
     * This process of reordering the array around a pivot is called
     * partitioning.
     */

    /**
     * Real-Life Analogy:
     * Think of sorting balls by color into three sections:
     * a. Red balls on the left
     * b. Green balls in the middle
     * c. Blue balls on the right
     * 
     * You're not really sorting them completely - you're just grouping
     * them using pivot logic (aka partitioning)!
     */

    /**
     * Why is it so important?
     * - Partitioning is the heart of:
     *   a. Quick Sort - Uses partitioning to sort an array by choosing a pivot
     *   b. Quick Select - Uses partitioning to find kth smallest/largest element in O(n)
     *   c. Dutch National Flag: Handles 0s, 1s, 2s type of problems
     *   d. Many Leetcode/GFG Problems around K-elements or partitioned zones.
     */

    /**
     * Basic Partitioning Example:
     * Input: [9, 3, 4, 2, 8, 5, 1], pivot = 5
     * Output: [3, 4, 2, 1, 5, 9, 8]
     * 
     * a. Element < 5 -> moved to left
     * b. 5 -> stays in center
     * c. Element > 5 -> moved to right
     * 
     * This result doesn't have to be fully sorted. Just partitioned.
     */

    /**
     * How does it work internally?
     * - We use two pointers:
     * 
     * int pivot = arr[end];
     * int i = start - 1;
     * 
     * for(int j = start; j < end; j++) {
     *    if(arr[j] < pivot) {
     *       i++;
     *       swap(arr[i], arr[j]);
     *    }
     * }
     * 
     * swap(arr[i + 1], arr[end]);
     * return i + 1; <== position of pivot
     * 
     * a. Moves smaller elements to the left
     * b. Puts pivot at the right place
     * c. Very common in QuickSort/QuickSelect
     */

    /**
     * Approach-1: Lomuto Parition Scheme
     * Intuition:
     * 1. Select the last element as pivot
     * 2. Everything < pivot goes to the front (left)
     * 3. Swap elements while scanning
     * 
     * Steps:
     * 1. Choose pivot = arr[end]
     * 2. Maintain index: i = start - 1
     * 3. Loop: j = start to end-1
     *    - If arr[j] < pivot:
     *      a. increase i
     *      b. swap(arr[i], arr[j])
     * 4. Finally, place pivot in the middle:
     *    a. swap(arr[i+1], arr[end])
     *    b. return i+1 (pivot position)
     * 
     * TC: O(n)
     * SC: O(1)
     * 
     * Simple and stable but not optimal when elements are repeated.
     */

     public static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1; // new pivot index
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Approach-2: Hoare's Partition Scheme
     * Intuition:
     * 1. Select the first pointer as pivot
     * 2. Use 2-pointers from both ends moving toward each other
     * 3. Swap when needed
     * 
     * Steps:
     * 1. Choose pivot = arr[low]
     * 2. Start i = low-1, j = high+1
     * 3. Repeat:
     *    a. Move i to right until arr[i] >= pivot
     *    b. Move j to left until arr[j] <= pivot
     *    c. If i >= j, break
     *    d. Else, swap arr[i] and arr[j]
     * 4. Return j (pivot position)
     * 
     * TC: O(n)
     * SC: O(1)
     * 
     * More efficient then Lomuto in some cases but tricky to implement.
     */

    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            swap(arr, i, j);
        }
    }


    /**
     * Approach-3: Dutch National Flag Algorithm
     * Intuition: Used when the array contains lots of duplicates of pivot. 
     * 
     * Steps:
     * - You maintain 3 regions:
     *   a. Low : elements < pivot
     *   b. Mid : elements == pivot
     *   c. High: elements > pivot
     * - Pointers: low, mid, high
    */

    public static void threeWayPartition(int[] arr, int pivot) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < pivot) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == pivot) {
                mid++;
            } else {
                swap(arr, mid, high--);
            }
        }
    }


    /**
     * Approach-4: Partition in QuickSort
     * QuickSort works by:
     * 1. Choosing a pivot
     * 2. Partitioning the array around it
     * 3. Recursively sorting left and right parts
     * You can plug in Lomuto or Hoare as the partitioning method
    */

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = lomutoPartition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    /**
     * Approach-5: Partition in QuickSelect (Kth smallest/largest)
     * QuickSelect is like QuickSort but only focuses on one side
     * (the side that contains the answer).
     * 1. Choose a pivot
     * 2. Partition
     * 3. If pivotIndex == k -> found
     * 4. If k < pivotIndex  -> search left
     * 5. Else -> search right
    */

    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pi = lomutoPartition(arr, low, high);

            if (pi == k) return arr[pi];
            else if (k < pi) return quickSelect(arr, low, pi - 1, k);
            else return quickSelect(arr, pi + 1, high, k);
        }
        return -1;
    }

    /**
     * When to use which approach?
     * -  Problem Type       :   Best Parition               :  TC  & SC
     * 1. Sorting Completely :   QuickSort (Lomuto/Hoare)    : O(nlogn) & O(logn)
     * 2. Kth element        :   QuickSelect (Lomuto)        : O(nlogn) & O(logn)
     * 3. Grouping Elements  :   Dutch National Flag (3-way) : O(n) & O(1)
     * 4. Stable+Simple      :   Lomuto                      : O(n) & O(1)
     * 5. More efficient     :   Hoare (but tricky)          : O(n) & O(1)
    */
}
