package _11_string_to_integer;

/**
 * Template-1: String to Number Conversion
*/

/**
 * Leetcode-8: String to Integer (atoi)
 * Implement the myAtoi(string s) fn, which converts a string to a
 * 32-bit signed integer(int).
 * 
 * Rule To Follow:
 * 1. Ignore leading whitespaces.
 * 2. Handle optional '+' or '-' signs.
 * 3. Read digits until a non-digit character is encountered. 
 * 4. If out of 32-bit integer range ([-2³¹, 2³¹ - 1]), return
 *    the closest limit.
 * 4. If no valid conversion, return 0.
*/

public class _01_string_to_integer_conversion {

    /**
     * Approach-1: Brute Force 
     * Using Char Checking & String Operations [Template]
     * 1. Extract valid characters and then convert them into an integer.
     * 2. Use a loop to check and process the string.
     * 
     * Steps:
     * 1. Trim leading spaces.
     * 2. Check for a sign (+ or -) and store it.
     * 3. Extract digits and store them in a string.
     * 4. Convert the string to an integer.
     * 5. Clamp the value if it exceeds Integer.MIN_VALUE or 
     *    Integer.MAX_VALUE
     * 
     * TC: O(N) => We process each char once
     * SC: O(N) => We store digits in a string
    */

    public int myAtoiI(String s) {

        /**
         * Remove leading spaces:
        */
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, index = 0;

        /**
         * Check sign:
        */
        if (s.charAt(0) == '-' || s.charAt(0) == '+') { 
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        /**
         * Extract digits:
        */
        String numStr = "";
        while (index < s.length() && Character.isDigit(s.charAt(index))) { 
            numStr += s.charAt(index);
            index++;
        }

        /**
         * No valid number found:
        */
        if (numStr.isEmpty()) return 0; 

        /**
         * Convert to integer:
        */
        long num = Long.parseLong(numStr) * sign; 


        /**
         * Clamp the value within 32-bit integer range:
        */
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) num;
    }


    /**
     * Approach-2: Using Long for Early Overflow Detection
     * 1. Instead of storing digits in a string, contruct the number
     *    on the fly. 
     * 2. Use long to detect overflow early and stop processing if
     *    needed. 
     * 
     * Steps:
     * 1. Trim spaces
     * 2. Check sign (+ or -)
     * 3. Extract digits & convert them directly to long.
     * 4. Stop if overflow occurs before full processing. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public static int myAtoiII(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, index = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        long num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index) - '0'); // Convert char to number
            
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Clamp overflow
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        return (int) (sign * num);
    }
}
