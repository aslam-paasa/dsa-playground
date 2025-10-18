package _08_basic_string;

import java.util.Scanner;

/**
 * Template: Two Pointers(Reversing, Palindrome Check)
*/

/**
 * Leetcode-344
 * You are given an array of characters s, reverse the array in-place
 * (without using extra space).
 * 
 * - Input : s = ["h", "e", "l", "l", "o"]
 * - Output: ["o", "l", "l", "e", "h"]
 * 
 * - Input : s = ["a", "b", "c", "d"]
 * - Output: ["d", "c", "b", "a"]
*/

public class _01_reverse_string {

    /**
     * Approach-1: Brute Force (Extra Array)
     * 1. Create a new array of the same size. 
     * 2. Copy elements from the original array to the new array in
     *    reverse order. 
     * 3. Copy the reversed array back to the original array. 
     * 
     * TC: O(n)
     * SC: O(n)
    */

    public static void reverseStringI(char[] s) {
        /**
         * 1. Create a new array to store reversed characters
        */
        char[] reversed = new char[s.length];

        /**
         * 2. Copy elements in reverse order
        */
        for (int i = 0; i < s.length; i++) {
            reversed[i] = s[s.length - 1 - i];
        }

        /**
         * 3. Copy reversed array back to the original array
        */
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }


    /**
     * Approach-2: Two Pointers
     * 1. Use Two Pointers:
     *    a. left starting from the beginning
     *    b. right starting from the end. 
     * 2. Swap the characters at left and right
     * 3. Move both pointers closer:
     *    a. Increment left
     *    b. Decrement right
     * 4. Stop when left >= right
     * 
     * TC: O(n)
     * SC: O(1)
    */

    public static void reverseString(char[] s) {
        int left = 0;               
        int right = s.length - 1; 

        while (left < right) {
            /**
             * Swap characters at left and right positions:
            */
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            /**
             * Move both pointers towards the center:
            */
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scn.nextLine();

        char[] s = str.toCharArray();
        reverseString(s);
        System.out.println("Reverse string using Approach-2: " + new String(s));
        
        char[] s1 = str.toCharArray();
        reverseStringI(s1);
        System.out.println("Reverse string using Approach-1: " + new String(s1));
        
        scn.close();
    }
}
