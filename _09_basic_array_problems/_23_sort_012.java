package _09_basic_array_problems;

public class _23_sort_012 {
    /**
     * Q. Sort an array of 0-1-2:
     * => arr = [0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1]
     * 
     * Approach-1: Sorting
     * TC: O(NlogN)
     * SC: O(1)
     * 
     * 
     * Approach-2: 
     * => int count0 = 0;
     *    int count1 = 1;
     *    int count2 = 2;
     * 
     * => int newArr[n];
     * => for(int i = 0; i < n; i++) {
     *       if(arr[i] == 0) {
     *          count0++;
     *       } else if(arr[i] == 1) {
     *          count1++;
     *       } else {
     *          count2++;
     *       }
     *    }
     * 
     * => for(int i = 0; i < count0; i++) {
     *       newArr[i] = 0;
     *    }
     * 
     * => for(int i = count0; i < count0+count1; i++) {
     *       newArr[i] = 1;
     *    }
     * 
     * => for(int i = count0+count1; i < n; i++) {
     *       newArr[i] = 2;
     *    }
     * 
     * TC: O(2N)
     * SC: O(N)
     * 
     * 
     * Approach-3: Dutch National Flag
     * => The algorithm revolves around 3 rules:
     *    (a) Everything from 0 to low-1   = 0 [extreme left]
     *    (b) Everything from low to mid-1 = 1
     *    (c) Everything from high+1 to n-1   = 2 [extreme right]
     * 
     *          low
     * => arr = [0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1]
     *          mid                              high
     * 
     * PseudoCode:
     * int low = 0;
     * int mid = 0;
     * int high = n-1;
     * 
     * while(mid <= high) {
     *    if(arr[mid] == 0) {
     *       swap(arr[low], arr[mid]);
     *       low++;
     *       mid++;
     *    } else if(arr[mid] == 1) {
     *       mid++;
     *    } else {
     *       swap(arr[mid], arr[high]);
     *       high--;
     *    }
     * }
     * 
     * TC: O(N)
     * SC: O(1)
    */

}
