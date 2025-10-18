package _10_reverse_array_and_string;

/**
 * Leetcode-680: Valid Palindrome II
 * Given a string s, return true if it can be a palindrome after
 * at most one deletion.
**/

public class _11_palindromic_after_deletion {
    /**
     * Approach-1: Brute Force (Try Removing Each Char & Check)
     * 1. Remove each char one by one and check if the remaining string
     *    is a palindrome.
     * 2. If at least one of the modified strings is a palindrome return
     *    true.
     * 
     * Steps:
     * 1. If s is already a palindrome, return true.
     * 2. Try removing each char from s, one at a time.
     * 3. Check if the modified string is a palindrome.
     * 3. If any modified string is a palindrome, return true;
     *    otherwise, return false.
     * 
     * TC: O(N^2) => Checking palindrome for each removal takes O(N),
     *               and we do this for N chars.
     * SC: O(N)   => Creating a new substring each time takes extra space.
    */

    public boolean isPalindromeII(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (isPalindromeII(s)) return true;

        for (int i = 0; i < s.length(); i++) {
            String modified = s.substring(0, i) + s.substring(i + 1);
            if (isPalindromeII(modified)) return true;
        }
        
        return false;
    }


    /**
     * Approach-2: Two pointers with Skipping One Character
     * 1. Use the two-pointer technique to compare chars from both ends. 
     * 2. If a mismatch is found, skip either the left or the right char
     *    and check if the remaining string is a palindrome.
     * 
     * Steps:
     * 1. Use two pointers (left and right) to compare chars. 
     * 2. If they don't match:
     *    a. Try skipping the left char and check if it forms a palindrome. 
     *    b. Try skipping the right char and check if it forms a palindrome. 
     * 3. If either case results in a palindrome, return true; otherwise,
     *    return false.
     * 
     * TC: O(N) => We only check at most two palindromes.
     * SC: O(1)
    */

    public boolean isPalindromeII(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindromeII(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try removing left or right character
                return isPalindromeII(s, left + 1, right) || isPalindromeII(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Approach-3: Inline Check without Extra Function Calls
     * Same as the previous approach but optimized to reduce fn calls
     * for better efficiently. 
     * 
     * Steps:
     * 1. Use two pointers (left and right).
     * 2. If s[left] != s[right], move left or righ forward and check
     *    if either remaining substring is a palindrome directly inside
     *    the loop. 
     * 3. If we find a valid palindrome, return true; otherwise,
     *    return false.
     * 
     * TC: O(N) => We only traverse at most one additional time. 
     * SC: O(1)
    */

    public static boolean validPalindromeIII(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Check both possibilities without function call
                int l1 = left + 1, r1 = right;
                int l2 = left, r2 = right - 1;

                while (l1 < r1 && s.charAt(l1) == s.charAt(r1)) {
                    l1++;
                    r1--;
                }
                if (l1 >= r1) return true;

                while (l2 < r2 && s.charAt(l2) == s.charAt(r2)) {
                    l2++;
                    r2--;
                }
                return l2 >= r2;
            }
            left++;
            right--;
        }

        return true;
    }
}
