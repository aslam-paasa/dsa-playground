package _11_string_to_integer;

/**
 * Template-1: String to Number Conversion
*/

/**
 * Leetcode-65: Valid Number
 * Valid Number is a tricky problem that requires checking whether
 * a given string represents a valid decimal number. We need to
 * consider various edge cases like signs (+, -), decimal points(.),
 * and scientific notation(e or E).
 * 
 * You are given a String s. Your task is to determine if it is a
 * valid number:
 * 
 * - Valid Inputs Examples:
 *   1. "0"     - Valid
 *   2. "2.5"   - Valid
 *   3. "-3.14" - Valid
 *   4. "1e10"  - Valid
 *   5. "+6e-1" - Valid
 *   6. "46.e3" - Valid
 * 
 * - Invalid Inputs Examples:
 *   1. "abc"      - Invalid
 *   2. "1a"       - Invalid
 *   3. "1.2.3"    - Invalid
 *   4. "e3"       - Invalid
 *   6. "--6"      - Invalid
 *   7. "-+3"      - Invalid
 *   8. "992e2.5"  - Invalid
 *
*/

public class _02_valid_number {

    /**
     * Approach-1: State Machine(Finite State Automata)
     * 1. Define States for different conditions:
     *    - Start
     *    - Sign (+, -)
     *    - Number before decimal
     *    - Decimal
     *    - Number after decimal
     *    - Exponent (e or E)
     *    - Number after exponent
     * 2. Translation between states based on input characters. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public boolean isNumberI(String s) {
        int state = 0;
        boolean seenDigit = false;
    
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
    
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } 
            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } 
            else if (ch == '.') {
                if (state == 2 || state == 4) return false;
                state = 2;
            } 
            else if (ch == 'e' || ch == 'E') {
                if (!seenDigit || state == 4) return false;
                seenDigit = false;
                state = 4;
            } 
            else {
                return false;
            }
        }
    
        return seenDigit;
    }

    /**
     * Approach-2: State Machine (Iterative)  [Template]
     * 1. Read the string character by character. 
     * 2. Maintain flags for:
     *    - Sign (+, -)
     *    - Decimal Point (.)
     *    - Exponent (e, E)
     * 3. Follow strict rules:
     *    - A number can have at most one sign(+, or -)
     *    - A number can have at most one decimal (.)
     *    - If there is e or E, it must be followed by a valid integer. 
     *    - No invalid symbols. 
     * 
     * TC: O(N)
     * SC: O(1)
    */

    public boolean isNumberII(String s) {
        boolean seenDigit = false, seenDot = false, seenExp = false;
        int n = s.length();
    
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
    
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } 
            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } 
            else if (ch == '.') {
                if (seenDot || seenExp) return false; // Can't have more than one '.'
                seenDot = true;
            } 
            else if (ch == 'e' || ch == 'E') {
                if (seenExp || !seenDigit) return false; // Can't have more than one 'e'
                seenExp = true;
                seenDigit = false; // Need digits after 'e'
            } 
            else {
                return false; // Invalid character
            }
        }
        
        return seenDigit; // Must have seen at least one digit
    }
}
