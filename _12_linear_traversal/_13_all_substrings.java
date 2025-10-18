package _12_linear_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Code360: All Substrings
 * Given a string s, generate all possible substrings of s. 
 * A substring is a contiguous sequence of characters within a
 * string.
 * 
 * Input : "abc"
 * Output: ["a", "ab", "abc", "b", "bc", "c"]
*/

public class _13_all_substrings {

    /**
     * Approach-1: Brute Force (Generating All Substrings using Nested Loops)
     * 1. Use two loops:
     *    - Outer loop (i) selects the starting idx of the substring.
     *    - Inner loop (j) selects the ending idx of the substring. 
     * 2. Extract the substring from idx i to j and store it in a list.
     * 3. Return the list of all substrings. 
     * 
     * TC: O(N^2) => Two nested loops for i and j
     *            => Extracting substring takes O(N) in Java, making worst
     *               case complexity O(N^2). 
     * SC: O(N)
     * 
     * Why is this slow?
     * - Substring extraction in Java creates a new string, consuming extra
     *   space.
    */

    public static List<String> allSubstringsI(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }

        return result;
    }


    /**
     * Approach-2: Using String Builder for efficient Substring creation
     * 1. Use nested loops like before
     * 2. Instead of using s.substring(i, j), use a StringBuilder to
     *    append characters dynamically (faster than substring calls). 
     * 3. Store each substring in the result list. 
     * 
     * TC: O(N^2)
     * SC: O(N)
     * 
     * Why is this better?
     * - Avoids repeated substring extractions and uses StringBuilder
     *   (efficient). 
    */

    public static List<String> allSubstringsII(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                result.add(sb.toString());
            }
        }

        return result;
    }
}
