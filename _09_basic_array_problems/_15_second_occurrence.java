package _09_basic_array_problems;

import java.util.Scanner;

public class _15_second_occurrence {
    public static int findSecondOccur(int arr[], int target) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                count++;
            }

            if(count == 2) {
                System.out.println("Second Occurrence found at: " + i);
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
        
        findSecondOccur(arr, target);

        scn.close();
    }
}
