package _09_basic_array_problems;

public class _26_rearrange_arr_elements_by_sign {
    /**
     * Q. Rearrange Array Elements by Sign:
     * => arr = [3, 1, -2, -5, 2, -4]
     *                  |
     *                  V
     *           0   1  2   3  4   5
     * => arr = [3, -2, 1, -5, 2, -4]
     * 
     * Note: 
     * 1. 'N' will always be even number. 
     * 2. Here, 'N' is even: 
     *    (a) 3 positive nums   
     *    (b) 3 negative nums
     * 3. These num can be in any order, and our task is to rearrange
     *    them by their sign. (Even: +ve, Odd: -ve)
     * 
     * Approach-1: Brute Force
     * 1. Initialize positive & Negative arr to store nums
     * int positive[n/2];
     * int negative[n/2];
     * 
     * int posIdx = 0;
     * int negIdx = 0;
     * 
     * 2. Traverse and store positive and negative nums
     * for(int i = 0; i < n; i++) {
     *    if(arr[i] > 0) {
     *       positive[posIdx++] = arr[i];
     *    } else {
     *       negative[negIdx++] = arr[i];
     *    }
     * }
     * 
     * 3. Rearrange the array by alternating positive and negative nums
     * for(int i = 0; i < n/2; i++) {
     *    arr[2*i] = positive[i];
     *    arr[2*i + 1] = negative[i];
     * }
     * 
     * TC: O(N) + O(N)     => O(2N)
     * SC: O(N/2) + O(N/2) => O(N)
     * 
     * 
     * Approach-2:
     * int ans[n];
     * 
     * int posIdx = 0;
     * int negIdx = 1;
     * 
     * 1. Traverse and store positive and negative nums in ans
     * for(int i = 0; i < n; i++) {
     *    if(arr[i] < 0) {
     *       ans[negIdx] = arr[i];
     *       negIdx += 2;
     *    } else {
     *       ans[posIdx] = arr[i];
     *       posIdx += 2;
     *    }
     * }
     * return ans;
     * 
     * 
     * TC: O(N)
     * SC: O(N)  
     * 
     * 
     * Approach-3: Two Pointer
     * int i = 0;
     * int j = 1;
     * int n = arr.length;
     * 
     * while(i < n && j < n) {
     * 
     *    1. If the element at i is +ve, and j is -ve, move both pointers
     *    if(arr[i] > 0 && arr[j] < 0) {
     *       i += 2;
     *       j += 2;
     *    }
     * 
     *    2. If arr[i] is -ve(wrong position), and arr[j] is positive(wrong position), swap them
     *    else if(arr[i] < 0 && arr[j] > 0) {
     *       swap(arr, i, j);
     *       i += 2;
     *       j += 2;
     *    }
     * 
     *    3. If arr[i] is positive, move i to next even idx
     *    else if(arr[i] > 0) {
     *       i += 2;
     *    }
     * 
     *    4. If arr[j] is negative, move j to next odd idx
     *    else {
     *       j += 2;
     *    }
     * }
     * 
     * TC: O(N)
     * SC: O(1)
    */

    /**
     * 2nd variety: If count of +ve != count of -ve:
     * 1. Case-1: +ve > -ve
     * 2. Case-2: +ve < -ve
     * 
    */
}
