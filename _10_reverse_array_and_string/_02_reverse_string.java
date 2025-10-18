package _10_reverse_array_and_string;

/**
 * Leetcode-344: Reverse String
 * You are given a character array s, reverse the array in place
 * without using extra space.
 * 
 * Input : s = ['h','e','l','l','o']  
 * Output: ['o','l','l','e','h']
*/

public class _02_reverse_string {
    /**
     * Approach-1: Brute Force (Using Extra Array)
     * Create a new array and store the reversed elements.
     * 
     * Steps:
     * 1. Initialize the new array.
     * 2. Copy elements from end to start.
     * 3. Copy back the reversed array into s. 
     * 
     * TC: O(N)
     * SC: O(N)
    */

    public static void reverseStringI(char[] s) {
        int len = s.length;
        char[] temp = new char[len];

        for (int i = 0; i < len; i++) {
            temp[i] = s[len - 1 - i];
        }

        // Copy back to original array
        for (int i = 0; i < len; i++) {
            s[i] = temp[i];
        }
    }


    /**
     * Approach-2: Two Pointer [In-place]
     * Use two pointers, one at the start and one at the end, and swap
     * characters until they meet in the middle. 
     * 
     * Steps:
     * 1. Initialize two pointers:
     *    - left = 0
     *    - right = s.length - 1
     * 2. Swap s[left] and s[right].
     * 3. Move pointers closer (left++, right--) and repeat.
     *
     * TC: O(N)
     * SC: O(1)
    */

    public static void reverseStringII(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }


    /**
     * Approach-3: Recursion
     * Use recursion to swap characters at left and right indices.
     *
     * Steps:
     * 1. Base Case : If left >= right, stop recursion.
     * 2. Swap s[left] and s[right].
     * 3. Recursively call reverseStringIII() with left+1 and right-1.
     *
     * TC: O(N)
     * SC: O(N)
    */

    public static void reverseStringIII(char[] s, int left, int right) {
        if (left >= right) return;

        // Swap characters
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverseStringIII(s, left + 1, right - 1);
    }

}
