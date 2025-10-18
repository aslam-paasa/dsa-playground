package _08_basic_string;

import java.util.Scanner;

/**
 * Template: Two Pointers(Reversing, Palindrome Check)
*/

/**
 * Leetcode-125: Valid Palindrome
 * Given a string s, determine if it is a palindrome, considering
 * only alphanumeric characters(letters and digits) and ignoring
 * cases. 
 * 
 * - Input : s = "A man, a plan, a canal: Panama"
 * - Output: true
 * 
 * - Input : s = "race a car"
 * - Output: false
 *
 * - Input : s = " "
 * - Output: true
*/

public class _02_palindrome_check {
    /**
     * Approach-1: Brute Force (Using Extra String)
     * 1. Clean the String: Remove non-alphanumeric characters and
     *    convert everything to lowercase. 
     * 2. Reverse the cleaned string and compare it with the original
     *    string. 
     * 3. If both are equal, return true(palindrome).
     *    Otherwise, return false.
     * 
     * TC: O(n)
     * SC: O(n)
    */

    public static boolean isPalindrome(String s) {
        /**
         * 1. Clean the string (keep only alphanumeric characters and lowercase it)
        */
        StringBuilder cleaned = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                cleaned.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                cleaned.append((char) (c + 32)); // Convert uppercase to lowercase
            }
        }
        
        /**
         * 2. Check if it's a palindrome(Compare start and end characters)
        */
        String original = cleaned.toString();
        String reversed = cleaned.reverse().toString();
        
        
        /** 
         * 3. Compare the original cleaned string with the reversed version
        */
        return original.equals(reversed);

    }


    /**
     * Approach-2: Two Pointers
     * 1. Use two pointers:
     *    - left starts from the beginning
     *    - right starts from the end
     * 2. Ignore non-alphanumeric characters
     * 3. Compare lowercase characters to both pointers.
     * 4. If characters differ, return false
     * 5. Move both pointers inward until they meet. 
     * 6. If no mismatch occurs, return true.
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public static boolean isPalindromeII(String s) {
        int left = 0, right = s.length() - 1;

        /**
         * 1. Move left pointer to the next valid alphanumeric character
         * 2. Move right pointer to the next valid alphanumeric character
         * 3. Compare characters (ignoring case)
        */
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) left++;

            while (left < right && !isAlphanumeric(s.charAt(right))) right--;

            if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Fn to check if a char is alphanumeric:
    */
    private static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    

    /**
     * Fn to convert uppercase to lowecase maually
    */
    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // Convert uppercase to lowercase
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scn.nextLine();

        System.out.println("Is palindrome using Approach-1: " + isPalindrome(str));
        System.out.println("Is palindrome using Approach-2: " + isPalindromeII(str));
        
        scn.close();
    }
}
