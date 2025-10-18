package _09_basic_array_problems;

public class _18_missing_num {
    /**
     * Q. Find missing number in an array.
     * => arr = [1, 2, 4, 5], N = 5
     * 
     * Approach-1: Linear Search
     * for(int i = 1; i <= N; i++) {
     *    int flag = 0;
     *    for(int j = 0; j < n-1; j++) {
     *       if(arr[j]) == i) {
     *          flag = 1;
     *          break;
     *       }
     *    }
     * 
     *    if(flag == 0) {
     *       return i;
     *    } 
     * }
     * 
     * TC: O(N^2)
     * SC: O(1) 
     * 
     * Approach-2: Hashing
     * => Declare hashArr of size-6. And if we declare the hashArr of
     *    size-6, then we will get the 5th idx.
     *    hashArr = [0, 1, 1, 0, 1, 1]
     * => Traverse from idx-0 and check which is not marked.
     * 
     * hashArr[n+1] = [0];                   => arr = [1, 2, 4, 5] hashArr[arr[i]] => hashArr[1]
     * for(int i = 0; i < n; i++) {             hashArr[1] = 1; 
     *    hashArr[arr[i]] = 1;                  hashArr[2] = 1;
     * }                                        hashArr[4] = 1;
     *                                          hashArr[5] = 1;
     *                                          hashArr[3] = 0;
     * for(int i = 1 to i < n; i++) {
     *    if(hashArr[i] == 0) {
     *       return i;
     *    }
     * }
     * 
     * TC: O(N) + O(N) => O(N)
     * SC: O(N)
     * 
     * Note: This problem has two optimal solution:
     * (a) Sum - O()
     * (b) XOR - O()
     *
     * Approach-4: XOR
     * => Sum num of XOR is always zero => a^a = 0
     *                                  => 2^2 = 0
     *                                  => 5^5 = 0
     *                                  => 2^2^2^2 = 0
     *                                     
     * => Zero XOR with any num is number itself => 2^2^2 = 2
     *                                           => 5^5^5^5^5 = 5
     * 
     * => If we try to do XOR, each of them will be XOR, and only missing
     *    num will be available.
     * 
     * XOR1: 1^2^3^4^5
     * XOR2: 1^2^4^5
     * 
     * XOR1^XOR2 = (1^1)^(2^2)^(3)^(4^4)^(5^5)
     *           = 0^3
     *           = 3
     * 
     * PseudoCode:
     * int XOR1 = 0; 
     * int XOR2 = 0;
     * 
     * 1. XOR of all numbers from 1 to N 
     * => for(int i = 1; i <= N; i++) {
     *       XOR1 = XOR1^i;               // 1^2^3^4^5
     *    }
     * 
     * 2. XOR of all elements in the array
     * => for(int = 0; i < arr.length; i++) {
     *       XOR2 = XOR2^arr[i];          // 0^1^2^3^5
     *    }
     * 
     * 3. Missing Number
     * => return XOR1^XOR2;              // (0^4) = 4
     * 
     * TC: O(2N)
     * SC: O(1)
     * 
     * PseudoCode: Optimized XOR
     * int XOR1 = 0; 
     * int XOR2 = 0;
     * 
     * 1. XOR of all elements in the array and XOR of indices + 1
     * => for(int = 0; i < arr.length; i++) {
     *       XOR2 = XOR2^arr[i];  // XOR of array elements
     *       XOR1 = XOR1^(i+1);   // XOR of indices + 1
     *    }
     * 
     * 2. Missing Number
     * => return XOR1^XOR2;     * 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * 
     * Approach-4: Sum
     * => Sum of N-natural num = n(n+1)/2
     *                         = 5(5+1)/2
     *                         = 30/2
     *                         = 15
     * => Sum of arr = 1+2+4+5 = 12
     * 
     * Missing Num = Sum of N-natural num - Sum of arr
     *             = 15 - 12
     *             = 3
     * 
     * PseudoCode:
     * int sum = n(n+1)/2;
     * int sumOfArr = 0;
     * for(int i = 0; i < n; i++) {
     *    sumOfArr += arr[i];
     * }
     * return (sum - sumOfArr);
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * 
    */

    // https://leetcode.com/problems/missing-number/description/

    public static void missingNum(int[] nums) {
        int[] missingArr = new int[nums.length+1];
        // Arrays.fill(missingArr, 0);

        for(int i = 0; i < nums.length; i++) {
            missingArr[nums[i]] = 1;
        }

        for(int i = 0; i < missingArr.length; i++) {
            if(missingArr[i] == 0) {
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }

}
