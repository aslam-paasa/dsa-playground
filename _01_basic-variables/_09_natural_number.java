package _01_getting_started;

/** 
 * Sum of 'n' Natural Number: (Solve without loop)
 *  => n = 5 -> 1+2+3+4+5 = 15
 *  => n = 1000 -> 1+2+3+...+1000 
 * 
 * This is nothing but AP, having common difference of '1'
 * - Formula-1 : Sn = n/2(a+l) where:
 *               > a = firstTerm, 
 *               > l = last term
 * 
 * - Formula-2 : Sn = n/2(2a+(n-1)d), where:
 *               > a = firstTerm, 
 *               > l = last term, 
 *               > d = common difference (diff b/w adjacent elements)
 * 
 * Note: When the difference between adjacent elements is same, then we call
 *       that sequence as Arithmetic Progression(AP).
 */

public class _09_natural_number {
    public static void main(String[] args) {
        int n = 15;
        System.out.println((n*(n+1))/2); // 120
    }
}
