package _11_string_to_integer;

/**
 * Template-2: Number to String Conversion
*/

/**
 * Leetcode-168: Excel Sheet Column Title
 * Given an integer columnNumber, return its corresponding Excel
 * column title as it appears in an Excel sheet. 
 * 
 * Input : 1
 * Output: "A"
 * 
 * Input : 28
 * Output: "AB"
 * 
 * Input : 701
 * Output: "ZY"
*/

public class _03_excel_sheet_column_title {
    
    /**
     * Approach-1: Brute Force (Repeated Division)
     * 1. Understand the Excel Column Mapping:
     *    - It's 1-based indexing, but we must convert it to 0-based
     *      (0 -> 'A', 25 -> 'Z')
     * 2. Loop until columnNumber becomes 0:
     *    - Reduce columnNumber by 1 to handle 0-based indexing.
     *    - Compute columnNumber % 26 to get the last character.
     *    - Convert to to a character: 'A' + (columnNumber % 26)
     *    - Divide columnNumber by 26 to move to the next digit.
     * 3. Reverse the Result Since we process from Least to Most
     *    Significant Digit. 
     * 
     * TC: O(log N) => Since we divide columnNumber by 26 each time
     * CS: O(1)    
     * 
     * Issue: Inefficient due to string concatenation inside the loop.
    */

    public String convertToTitleI(int columnNumber) {
        String result = "";

        while (columnNumber > 0) {
            columnNumber--; // Convert to 0-based indexing
            char lastChar = (char) ('A' + (columnNumber % 26));
            result = lastChar + result; // Add to the front
            columnNumber /= 26;
        }

        return result;
    }


    /**
     * Approach-2: Recursive Approach
     * 1. Excel column numbers work like Base-26, but with letters
     *    (A-Z) instead of (0-25)
     * 2. Convert columnNumber to its equivalent Excel title using
     *    recursion.
     * 
     * Steps:
     * 1. If columnNumber is <= 26, return the corresponding letter.
     * 2. If columnNumber > 26, break it down into:
     *    a. The last letter: (columnNumber - 1) % 26 
     *       [0-based idx for 'A' to 'Z']
     *    b. The remaining part: (columnNumber - 1) / 26 
     * 3. Recursively call the fn for the remaining part.
     * 
     * TC: O(log26 N) => Number of digits in Base-26
     * SC: O(log26 N) => Recursive Stack Memory
     * 
     * Downside: Uses Recursion, which may cause stack overflow for
     *           large inputs.
    */

    public String convertToTitleII(int columnNumber) {

        if (columnNumber == 0) return "";

        /**
         * Convert to 0-based:
        */
        columnNumber--;

        return convertToTitleII(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }


    /**
     * Approach-2: Using StringBuilder - Iterative [Common Template]
     * 1. Instead of recursion, use an iterative approach with
     *    StringBuilder
     * 2. Keep dividing by 26 and extracting the remainder. 
     * 
     * Steps:
     * 1. Initialize an empty StringBuilder for the result.  
     * 2. Loop while columnNumber > 0:
     *    - Reduce columnNumber by 1 (to handle 0-based indexing).
     *    - Extract the last letter using (columnNumber % 26) + 'A'
     *    - Update columnNumber by dividing it by 26. 
     * 3. Since we build the result in reverse order, reverse the
     *    StringBuilder before returning. 
     * 
     * TC: O(log26 N) => Number of digits in Base-26
     * SC: O(log26 N) => Stores the result in StringBuilder
     * 
     * Why is this better?
     * - Avoid recursion(no stack overflow risk)
     * - Efficient string manipulation using StringBuilder
     * 
     * Note: This problem follows for Number -> String Conversion
     *       [Base-26 Encoding]
    */

    public String convertToTitleIII(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Convert to 0-based
            char ch = (char) ('A' + (columnNumber % 26));
            result.append(ch);
            columnNumber /= 26;
        }
        
        return result.reverse().toString();
    }


    /**
     * Approach-3: Char Array - Fastest
     * - Instead of StringBuilder, use a char array and build the result
     *   from the back. 
     * 
     * Steps:
     * 1. Determine the max possible length of the result (log26 N).
     * 2. Use a char array to store letters in reverse order. 
     * 3. Convert columnNumber using:
     *    - (columnNumber - 1) % 26 to get the character.
     *    - Update columnNumber /= 26
     * 4. Return the substring of the filled portion. 
     * 
     * TC: O(log26 N) => Iterates log-base-26 times.
     * SC: O(1)
     * 
     * Why is this optional?
     * - No extra StringBuilder allocation.
     * - Fastest execution by directly modifying a char array.
     * - So, fastest & memory efficient.
    */

    public String convertToTitleIV(int columnNumber) {
        char[] result = new char[10]; // Enough space for max Excel title length
        int index = 9; // Start filling from the last index

        while (columnNumber > 0) {
            columnNumber--; // Convert to 0-based
            result[index--] = (char) ('A' + (columnNumber % 26));
            columnNumber /= 26;
        }

        return new String(result, index + 1, 9 - index);
    }
}
