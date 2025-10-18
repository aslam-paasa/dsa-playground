package _09_basic_array_problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class _17_intersection_of_two_sorted_arr {
    /**
     * Q. Find intersection of two sorted arrays.
     * => A[] = [1, 2, 2, 3, 3, 4, 5, 6]
     * => B[] = [2, 3, 3, 5, 6, 6, 7]
     * 
     * Intersection: Elements present in both array.
     * inter[] = [2, 3, 3, 5, 6]
     * 
     * Approach-1: 
     * int n1 = A[].length; 
     * int n2 = B[].length;
     * 
     * int visited[n2] = 0;
     * 
     * for(int i = 0; i < n1; i++) {
     *    for(int j = 0; j < n2; j++) {
     *       if(A[i] == B[j] && visited[j] == 0) {
     *          ans.add(A[i]);
     *          visited[j] = 1;
     *          break;
     *       }
     * 
     *       if(B[j] > A[i]) {
     *          break;
     *       }
     *    }
     * }
     * return ans;
     * 
     * TC: O(N1 x N2)
     * SC: O(N2)
     * 
     * 
     * Approach-2: Two Pointer
     *                          i
     * => A[] = [1, 2, 2, 3, 3, 4, 5, 6]
     * => B[] = [2, 3, 3, 5, 6, 6, 7]
     *                    j
     * 
     * PseudoCode:
     * ArrayList<Integer> intersection = new ArrayList<>();
     * int i = 0;
     * int j = 0;
     * 
     * while(i < A.length && j < B.length) {
     *    1. If elements are equal, add intersection
     * 
     *       if(A[i] == B[j]) {
     *          intersection.add(A[i]);
     *          i++;
     *          j++;
     *       }
     * 
     *    2. Move the pointer in A if A[i] is smaller
     * 
     *       else if(A[i] < B[j]) {
     *          i++;
     *       }
     * 
     *    3. Move the pointer in B if B[j] is smaller
     *       else {
     *          j++;
     *       }
     * }
     * return intersection;
     * 
     * TC: O(N1 + N2);
     * SC: O(min(N1, N2))
    */

    // https://leetcode.com/problems/intersection-of-two-arrays/description/
    public static void findIntersection(int[] A, int[] B) {
        HashSet<Integer> intersectArr = new HashSet<Integer>();
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j]) {
                    intersectArr.add(B[j]);
                }
            }
        }
        System.out.println(intersectArr.toString());
    }

    // https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
    public static void intersectionII(int[] A, int[] B) {
        ArrayList<Integer> intersectArr = new ArrayList<Integer>();

        int visited = 0;
        int i = 0;
        int j = 0;

        while(i < A.length && j < B.length) {
            if(A[i] == B[j] && visited == 0) {
                intersectArr.add(B[j]);
                i++;
                j++;
                visited++;
            }

            else if(A[i] < B[j]) {
                i++;
                visited = 0;
            }

            else {
                j++;
                visited = 0;
            }
        }

        System.out.println(intersectArr.toString());
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

        System.out.println("Enter the size of the second array: ");
        int m = scn.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter the elements of the second array: ");
        for(int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        
        intersectionII(arr, arr2);

        scn.close();
    }
}
