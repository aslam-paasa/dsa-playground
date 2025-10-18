package _14_prefix_sum_with_conditional_logic;

/**
 * GFG: Value of polynomial
 * Given an array coeff[] of size n representing coefficients of a
 * polynomial in increasing order i.e., 
 * 
 *   P(x) = coeff[0] + 
 *          coeff[1]*x + 
 *          coeff[2]*x^2 + 
 *          ... + 
 *          coeff[n-1]*x^(n-1)
 * 
 * and an integer x, find the value of the polynomial at x. 
 * 
 * Key Formula: P(x) = a0 + a1.x + a2.x^2 + ... + an-1.x^n-1
*/

public class _02_value_of_polynomials {
    /**
     * Approach-1: Brute Force (Naive Power Calculation)
     * - For every term a_i * x^i manually using a loop.
     * 
     * TC: O(N^2)
     * SC: O(1)
    */

    public int valueOfPolynomialBrute(int[] coeff, int x) {
        int result = 0;
        int n = coeff.length;
    
        for (int i = 0; i < n; i++) {
            int power = 1;
            for (int j = 0; j < i; j++) {
                power *= x;
            }
            result += coeff[i] * power;
        }
    
        return result;
    }

    
    /**
     * Approach-2: Math.Pow()
     * - Use a build-in Math.pow(x, i) to calculate each power efficiently. 
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Note: Math.pow() internally may take O(log i) due to exponentiation
     *       by squaring, so technically slightly more than O(N). 
    */

    public int valueOfPolynomialBetter(int[] coeff, int x) {
        int result = 0;
        int n = coeff.length;
    
        for (int i = 0; i < n; i++) {
            result += coeff[i] * Math.pow(x, i);
        }
    
        return result;
    }


    /**
     * Approach-3: Optimized (Using Horner's Rule)
     * Horner's Rule rewrite the polynomial to reduce computation:
     * => P(x) = ((an-1).x + an-2)x + an-3) + ... + a0)
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Note: Fastest and most efficient - no power calculations.
    */

    public int valueOfPolynomialOptimized(int[] coeff, int x) {
        int n = coeff.length;
        int result = coeff[n - 1];
    
        for (int i = n - 2; i >= 0; i--) {
            result = result * x + coeff[i];
        }
    
        return result;
    }
}
