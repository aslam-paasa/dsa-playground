package _09_basic_array_problems;

public class _25_max_subarray_sum {
    /**
     * Q. Kadane's Algorithm - Maximum Subarray Sum
     * => arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
     *    ans = 7
     * 
     * Approach-1: Brute Force 
     * 1. Generate all subarrays
     *    -2
     *    -2 -3
     *    -2 -3 4
     *    -2 -3 4 -1
     *    -2 -3 4 -1 -2
     *    -2 -3 4 -1 -2 1
     *    -2 -3 4 -1 -2 1 5
     *    -2 -3 4 -1 -2 1 5 -3
     *    -3
     *    -3 4
     *    -3 4 -1
     *     .........
     *     ...........
     *     .............
     * 
     * PseudoCode:
     * int max = INTEGER_MIN_VALUE;
     * for(int i = 0; i < n; i++) {
     *    for(int j = i; j < n; j++) {
     *       int sum = 0;
     *       for(int k = i; k < j; k++) {
     *          sum += arr[k];
     *          max = Math.max(sum, max);
     *       }
     *    }
     * } 
     * 
     * TC: O(N^3)
     * SC: O(1)
     * 
     * 
     * Approach-2: 
     * int max = INTEGER_MIN_VALUE;
     * for(int i = 0; i < n; i++) {
     *    int sum = 0;
     *    for(int j = i; j < n; j++) {
     *       sum += arr[j];
     *       max = Math.max(sum, max);
     *    }
     * }
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * 
     * Approach-3: Kadane's Algorithm
     * Basic Logic:
     * 1. +ve + +ve = +ve
     * 2. +ve + -ve = +ve (where +ve is greater)
     * 3. +ve + -ve = -ve (where -ve is greater) => Not favourable
     * => Note: Final negative value lene se accha hai aap 0 le lo.
     * 
     * => Kadane's algorithm kehta hai ki hm ek ek kr k single loop chalae
     *    jae, aur currentSum & maxSum nikaalte jae.
     * => But humne jo logic upar discuss kiya wo kehta hai ki agar currentSum
     *    m agar chije negative ho gyi to currentSum ko 0 kr do. 
     * => CurrentSum m elements ko tbtk add krte jaenge jbtk final output
     *    humara positive rehta hai, jiss point pe final output humaara
     *    negative ho gya to waha pe hm uss currentSum ko 0 bna denge.
     * 
     * Example:
     * arr:  [-2, -3, 4, -1, -2, 1, 5, -3]
     * CS : 0  0   0  4   3   1  2  7   4
     * MS :Inf 0   0  4   4   4  4  7   7   
     * 
     * MaxSubarraySum = 7 => [4,-1,-2,1,5,-3]
     * 
     * Note: Aisa case jaha pe saare numbers -ve hnge waha ye 0 dega
     *       Uske liye humein special case likhna padega:
     *       => [-1,-2,-3,-4]
     *       => Ek loop lga k check kr lenge agar saare negative h to
     *       => Fir isne se smallest negative print kr denge
     * 
     * PseudoCode:
     * int maxSum = Integer.MIN_VALUE;
     * int currentSum = 0;
     * 
     * for(int i = 0; i < arr.length; i++) {
     *     
     *     if(currentSum < 0) {
     *         currentSum = 0;
     *     }
     * 
     *     currentSum = currentSum + arr[i];
     *     maxSum = Math.max(currentSum, maxSum);
     * }
     * System.out.println("Our max subarray sum : " + maxSum);
     * 
     * TC: O(N)
     * SC: O(1)
    */

}
