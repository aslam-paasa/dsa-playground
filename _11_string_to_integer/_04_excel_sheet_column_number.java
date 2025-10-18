package _11_string_to_integer;

/**
 * Template-2: Number to String Conversion
*/

/**
 * Leetcode-171: Excel Sheet Column Number
 * Given a string columnTitle representing a column title as it
 * appears in an Excel sheet, return its corresponding column
 * number.
 * 
 * Ex: Input : "A"
 *     Output: 1
 * 
 * Ex: Input : "AB"
 *     Output: 28
 * 
 * Ex: Input : "ZY"
 *     Output: 701
*/

public class _04_excel_sheet_column_number {

    /**
     * Approach-1: Brute Force (Right-to-Left)
     * 1. Excel column numbers follow a Base-26 System, where:
     *    - 'A'  -> 1,  'B'  -> 2, ..., 'Z' -> 26
     *    - 'AA' -> 27, 'AB' -> 28 ..., etc.
     * 2. We process the string from right-to-left:
     *    - Convert each character to a number (ch - 'A'+1)
     *    - Multiply by the corresponding power of 26. 
     *    - Accumulate the sum. 
     * 3. Return the final sum. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public int titleToNumberI(String columnTitle) {
        int columnNumber = 0;
        int power = 1; // Start from rightmost character
    
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int digit = columnTitle.charAt(i) - 'A' + 1;
            columnNumber += digit * power;
            power *= 26; // Move to next place value
        }
    
        return columnNumber;
    }

    /**
     * Approach-2: Optimied Left-To-Right Processing [Template]
     * 1. Instead of processing from right-to-left, we process from
     *    left-to-right. 
     * 2. This allows us to use a cumulative multiplication strategy:
     *    - Start with columnNumber = 0
     *    - For each character, multiply the existing result by 26 and
     *      add the digit. 
     * 3. This avoids the need for a separate power variable. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Fastest & Cleanest
    */

    public int titleToNumberII(String columnTitle) {
        int columnNumber = 0;
    
        for (int i = 0; i < columnTitle.length(); i++) {
            columnNumber = columnNumber * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
    
        return columnNumber;
    }

    /**
     * Approach-3: Recursive Approach
     * 1. Base Case: If string is empty, return 0.
     * 2. Recursive Relation:
     *    - Extract the first character and convert it to a number. 
     *    - Multiply previous result by 26 and add the new number. 
     *    - Call recursion on the remaining substring. 
     * 
     * TC: O(N)
     * SC: O(N) => Recursive Stack Memory
    */

    public int titleToNumberIII(String columnTitle) {
        if (columnTitle.isEmpty()) return 0;
        
        return titleToNumberIII(columnTitle.substring(0, columnTitle.length() - 1)) * 26 +
               (columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1);
    }

    /**
     * Approach-4: Char Array - Fastest
     * 1. Iterate through the string from left to right.
     * 2. For each character, convert it to a number and accumulate the
     *    result.
     * 3. Return the final result.
     *
     * TC: O(N)
     * SC: O(1)
     * 
     * Why is this better?
     * - No extra StringBuilder allocation.
     * - Fastest execution by directly modifying a char array.
     * - So, fastest & memory efficient.
     * 
     * Note: Approach-2 & Approach-4 is for best performance
     *       Char Array is equally fast, but doesn't provide much
     *       advantage in Java. So, Approach-2 is preferred.
    */
}
