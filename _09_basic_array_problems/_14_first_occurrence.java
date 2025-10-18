package _09_basic_array_problems;

import java.util.Scanner;

public class _14_first_occurrence {
    /**
     * Q. Linear Search - Find 1st occurrence.
     * => arr = [6, 7, 8, 4, 1], num = 10
     * 
     * PseudoCode:
     * => for(int i = 0; i < n; i++) {
     *       if(arr[i] == num) {
     *          return i;
     *       }
     *    }
     *    return -1;
    */

    public static int findFirstOccur(int arr[], int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
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

        System.out.println("Enter the target number to find: ");
        int target = scn.nextInt();
        
        int result = findFirstOccur(arr, target);
        if(result != -1) {
            System.out.println("First occurrence found at index: " + result);
        } else {
            System.out.println("Element not found in array");
        }

        scn.close();
    }
}
