package _09_basic_array_problems;

public class _22_two_sum {
    /**
     * 2Sum:
     * => arr[] = [2, 6, 5, 8, 11], target = 14
     * 
     * Approach-1:
     * for(int i = 0; i < n; i++) {
     *    for(int j = 0; j < n; j++) {
     *       if(i == j) {
     *          continue;
     *       }
     * 
     *       if(arr[i] + arr[j] == target) {
     *          return true;
     *       }
     *    }
     * }
     * return false;
     * 
     * TC: O(N^2)
     * 
     * 
     * Approach-2: Hashing (ele, idx)
     * HashMap<Integer, Integer> mpp;
     * for (int i = 0; i < n; i++) {
     *    int num = arr[i];
     *    int moreNeeded = target - num;
     *    if (mpp.containsKey(moreNeeded)) {
     *           return "YES";
     *    }
     * 
     *    mpp.put(arr[i], i);
     * }
     * return "NO";
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * 
     * Approach-3: Two Pointers
     * Arrays.sort(arr);
     * int left = 0;
     * int right = arr.length-1;
     * while(left < right) {
     *    int sum += arr[left] + arr[right];
     *    if(sum == target) {
     *       return "YES";
     *    } else if(sum < target) {
     *       left++;
     *    } else {
     *       right--;
     *    }
     * }
     * return "NO";
     * 
     * TC: O(N) + O(NlogN) => O(NlogN)
     * SC: O(1)
     * 
    */

}
