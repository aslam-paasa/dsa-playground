package _10_reverse_array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-9: Palindrome Number
 * Convert the number to a string and check if it reads the same
 * forward and backward.
 * 
 * Steps:
 * 1. Convert the integer 'x' to a string.
 * 2. Reverse the string. 
 * 3. Compare the original string with the reversed one.
 * 4. If they are the same, return true, else return false.
 * 
 * TC: O(N) => String reversal takes linear time
 * SC: O(N) => Extra space required for storing the reversed string
*/

public class _10_palindromic_number {

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        /**
         * 1. Convert number to string:
         * 2. Reverse the string
         * 3. Check if original and reversed strings are same
        */

        String str = Integer.toString(x);
        
        String revStr = new StringBuilder(str).reverse().toString();
        
        return str.equals(revStr);
    }

    /**
     * Approach-2: Using Digits
     * Extract digits and store in an array, then compare first and
     * last elements. 
     * 
     * Steps:
     * 1. If x is negative, return false(-ve cannot be palindromes)
     * 2. Extract digits of x one and store them in a list. 
     * 3. Use two pointers(start and end) to compare elements. 
     * 4. If all correspinding elements match, return true, otherwise
     *    return false.
     * 
     * TC: O(N) => Extracting digits and checking palindrome both takes
     *             linear time
     * SC: O(N) => Storing digits requires extra space
    */

    public static boolean isPalindromeII(int x) {
        if (x < 0) return false;

        List<Integer> digits = new ArrayList<>();
        int num = x;

        /**
         * 1. Extract digits and store in list:
        */
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        /**
         * 2. Compare digits from start and end
        */
        int left = 0, right = digits.size() - 1;
        while (left < right) {
            if (!digits.get(left).equals(digits.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    /**
     * Approach-3: Reverse Half of the Number
     * Instead of reversing the full number, reverse only half and
     * compare. 
     * 
     * Steps:
     * 1. If x is negative or end with 0 (but is not 0 itself, return
     *    false).
     * 2. Reverse only half of x by extracting its last digits. 
     * 3. Compare the reversed half with the remaining half. 
     * 4. If they are equal (or almost equal in case of odd digits),
     *    return true, otherwise return false.
     * 
     * TC: O(log N) => We process only half the digits
     * SC: O(1)
    */

    public static boolean isPalindromeIII(int x) {
        /**
         * -ve nums and multiples of 10 (except 0) are not palindromes
        */
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        /**
         * Check if reversed half is equal to the original half
        */
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
