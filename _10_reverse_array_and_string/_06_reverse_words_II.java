package _10_reverse_array_and_string;

/**
 * Leetcode-557: Reverse Words in a String III 
 * Given a string s, reverse the characters of each word in the
 * string while preserving the order of words.
 * - Words are separated by a single space. 
 * - There are no extra spaces in the input.
 * 
 * Input : s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Input : Input: s = "God Ding"
 * Output: "doG gniD"
*/

public class _06_reverse_words_II {
    /**
     * Approach-1: Brute Force (Using Extra Space - Split & Reverse Each Word)
     * 1. Split the string into words using " "
     * 2. Reverse each word
     * 3. Join the words back using a single space.
     * 
     * Steps:
     * 1. Split the string into words using " ". 
     * 2. Reverse each word. 
     * 3. Join the reversed words into a final string. 
     * 
     * TC: O(N) => Splitting + Reversing each word
     * SC: O(N) => Storing words in an array
    */

    public static String reverseWords(String s) {
        String[] words = s.split(" "); 
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim(); // Remove trailing space
    }


    /**
     * Approach-2: In-place String Reversal using Two Pointers
     * 1. Convert the string to a character array for in-place modification. 
     * 2. Reverse each word separately without extra space. 
     * 
     * Steps:
     * 1. Convert the string to a character array (char[])
     * 2. Use two pointers to reverse each word in-place.
     * 3. Convert the character array back to a string. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static String reverseWordsII(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ' || i == n - 1) {
                // Reverse the current word
                int end = (arr[i] == ' ') ? i - 1 : i;
                reverse(arr, start, end);
                start = i + 1; // Move to next word
            }
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
