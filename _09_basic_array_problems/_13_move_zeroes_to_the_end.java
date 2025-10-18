package _09_basic_array_problems;

public class _13_move_zeroes_to_the_end {
    /**
     * Q. Move Zeroes to the end.
     * => arr = [1, 0, 2, 3, 2, 0, 0, 4, 5, 1]
     * 
     * Approach-1:
     * 1. Copy non-zero elements to temp
     * => int temp[n];
     *    for(int i = 0; i < n; i++) {
     *       if(arr[i] != 0) {
     *          temp[index++] = arr[i];
     *       }
     *    }
     * 
     * 2. Copy elements from temp back to arr
     * => for(int i = 0; i < index; i++) {
     *       arr[i] = temp[i];
     *    }
     * 
     * 3. Fill the remaining positions in arr with zeroes
     * => for(int = index; i < n; i++) {
     *       arr[i] = 0;
     *    }
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * Approach-2: Two Pointer
     * 
     * 1. Pointer j to track the 1st 0's position
     * => int j = -1;
     * 
     * 2. Find the first occurrence of 0 and initialize j
     * => for(int i = 0; i < n; i++) {
     *       if(arr[i] == 0) {
     *          j = i;
     *          break;
     *       }
     *    }
     * 
     * 3. Traverse the array and swap non-zero elements with zero at j
     * => for(int i = j+1; i < n; i++) {
     *       if(arr[i] != 0) {
     *          swap(arr[i], arr[j]);
     *          j++;
     *       }
     *    }
     * 
     * TC: O(X) + O(N-X) => O(N)
     * SC: O(1)
    */
}
