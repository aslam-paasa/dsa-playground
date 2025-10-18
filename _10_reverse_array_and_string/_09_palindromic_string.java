package _10_reverse_array_and_string;

/**
 * Leetcode-125: Valid Palindrome
 * A string is a palindrome if it reads the same forward and
 * backward ignoring:
 * - Non-alphanumeric characters (only consider letters and digits)
 * - Case differences (treat uppercase and lowercase the same)
 * Return true if the given string is a palindrome; otherwise return
 * false.
 * 
 * Input : s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Input: s = " "
 * Output: true
 * Explanation: Empty string is a palindrome.
**/

public class _09_palindromic_string {

    /**
     * Approach-1: Brute Force (Extra Space)
     * 1. Remove all non-alphanumeric characters.
     * 2. Convert the string to lowercase.
     * 3. Check if the cleaned string is equal to its reverse.
     * 
     * Steps:
     * 1. Use StringBuilder to filter only letters & digits.
     * 2. Convert to lowecase to ignore case
     * 3. Reverse the string and check if it's the same as the original
    */

    public static boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        /**
         * 1. Filter alphanumeric characters & convert to lowercase
         * 2. Reverse and compare
        */
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        return cleaned.toString().equals(cleaned.reverse().toString());
    }


    /**
     * Approach-2: Two Pointer (In-Place)
     * 1. Use two pointers : left and right to compare characters. 
     * 2. Skip non-alphanumeric characters. 
     * 3. Convert to lowercase while comparing. 
     * 
     * Steps:
     * 1. Initialize two pointers:
     *    - left at the start. 
     *    - right at the end.
     * 2. Move pointers until they find valid alphanumeric characters. 
     * 3. Compare characters:
     *    - If different, return false.
     *    - If same, move both pointers inward. 
     * 4. Continue until pointers cross each other. 
     * 
     * TC: O(N) => Single pass with two pointers
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

}
