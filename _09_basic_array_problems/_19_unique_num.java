package _09_basic_array_problems;

public class _19_unique_num {
    /**
     * Q. Find the number that appears once, and the others twice.
     * => arr = [1, 1, 2, 3, 3, 4, 4]
     * 
     * Approach-1: Linear Search - O(N)
     * for(int i = 0; i < n; i++) {
     *    int num = arr[i];
     *    int count = 0;
     *    for(int j = 0; j < n; j++) {
     *       if(arr[j] == num) {
     *          count++;
     *       }
     *    }
     *    if(count == 1) {
     *       return num;
     *    }
     * }
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * 
     * Approach-2: Hashing using Array
     * 1. Size of the array
     *    int n = array.length;
     * 
     * 2. Find the max element:
     *    int max = arr[0];
     *    for(int i = 0; i < n; i++) {
     *       max = Math.max(max, arr[i]);
     *    }
     * 
     * 3. Declare hash array of size max+1
     *    And hash the given array
     *    int[] hash = new int[max+1];
     *    for(int i = 0; i < n; i++) {
     *       hash[arr[i]]++;
     *    }
     * 
     * 4. Find the single element and return the ans
     *    for(int i = 0; i < n; i++) {
     *       if(hash[arr[i]] == 1) {
     *          return arr[i];
     *       }
     *    }
     * 
     * 5. Return -1 when no unique element found
     *    return -1;
     * 
     * TC: O(N) + O(N) + O(N) = O(3N)
     * SC: O(max+1) => Depending on the i/p it will vary
     * 
     * Note: But if the input is very big then we cannot hash it.
     *       We have to use HashMap DS with bigger datatypes as key.
     * 
     * Approach-3: Hashing using Map DS
     * int n = arr.length;
     * HashMap<Integer, Integer> hash = new HashMap<>();
     * 
     * 1. Populate the HashMap with counts
     * for(int i = 0; i < n; i++) {
     *    hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
     * }
     * 
     * 2. Find the element that appears once
     * for(int i = 0; i < n; i++) {
     *    if(hash.get(arr[i]) == 1) {
     *       return arr[i];
     *    }
     * }
     * 
     * return -1;
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * 
     * Approach-4: XOR
     * => XOR of all elements, then only unique element will be left.
     * 
     * int XOR = 0;
     * for(int i = 0; i < n; i++) {
     *    XOR = XOR^arr[i];
     * }
     * return XOR;
     * 
     * TC: O(N)
     * SC: O(1)
    */

}
