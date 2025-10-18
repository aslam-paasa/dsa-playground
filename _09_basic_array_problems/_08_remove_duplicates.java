package _09_basic_array_problems;

import java.util.HashSet;
import java.util.Scanner;

public class _08_remove_duplicates {
    /**
     * Q. Remove duplicates from sorted array.
     * => arr = [1, 1, 2, 2, 2, 3, 3]
     * 
     * Approach-1: Unique Elements (HashSet)
     * HashSet<Integer> set;
     * for(int i = 0; i < n; i++) {
     *    set.insert(arr[i]);       <= NlogN
     * }
     * 
     * int idx = 0;
     * for(it : set) {
     *    arr[idx] = it;            <= N
     *    idx++;
     * }
     * return idx;
     * 
     * TC: O(NlogN)
     * SC: O(N)
     * 
     * Approach-2: Since the array is sorted, we don't need HashSet.
     * 
     * int idx = 0;
     * for(int i = 1; i < n; i++) {
     *    if(arr[i] != arr[i-1]) {
     *       arr[idx++] = arr[i]
     *    }
     * }
     * return i+1;
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static void removeDuplicatesI(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(!set.contains(arr[i])) {
                set.add(arr[i]);
                arr[idx++] = arr[i];
            }
        }
        
        for(int i = 0; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void removeDuplicatesII(int[] arr, int n) {
        if(arr == null || n == 0) {
            return;
        }

        int idx = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] != arr[i-1]) {
                arr[idx++] = arr[i];
            }
        }

        for(int i = 0; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        removeDuplicatesI(arr, n);
        System.out.println("Array after removing duplicates: ");
        removeDuplicatesII(arr, n);
        System.out.println();
        scn.close();
    }
}
