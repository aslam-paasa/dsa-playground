package _23_basic_sorting_algorithms;

public class _01_sorting_intro {
    /**
     * Q. What do you mean by Sorting?
     * => Arranging data in some order (ascending/descending) based on a
     *    specific parameter.
     * 
     *    (a) Sorting in ascending order by value:
     *     => [3, 8, 9, 14, 19]
     * 
     *    (b) Sorting in descending order by value:
     *     => [19, 14, 9, 8, 3]
     * 
     *    (c) Sorted in ascending order by factors:
     *     => [1, 13, 9, 6, 12]
     *     => Not sorted on the basis of ascending or descending by value.
     *     => Sorted in ascending order by no of factors.
     *     => arr    : [1, 13, 9, 6, 12]
     *        factor :  1  2   3  4  5
    */

    /**
     * Q. Why we need sorting?
     * => Sorting helps us in arranging data in specific order, and this
     *    makes our searching easy.
     * => So, we will learn sorting in order to do easy searching.
     *    Ex: Lexographical - Sort based on alphabetical order
     * 
     * => Before Sorting:
     *        Name            Score (Parameter)
     *        Shivam          32
     *        Mohit           60
     *        Aman            72
     *        Shrest          12
     *        Satyam          10
     *        Aman(2)         72
     *        Ayush           80 
     * 
     *  => After Sorting:
     *        Name            Score (Parameter)
     *        Satyam          10
     *        Shrest          12
     *        Shivam          32
     *        Mohit           60
     *        Aman            72
     *        Aman(2)         72
     *        Ayush           80 
     * 
     * Note: Relative Order of Aman1 & Aman2 is still same. Means Aman
     *       still comes before Aman2. Currently the order is preserved
     *       means before sorting Aman1 comes first, after sorting still
     *       Aman1 comes first, even though both of them have same amount
     *       of score.
     * 
     *       But suppose after sorting Aman2 comes first and then Aman1,
     *       can we say the sorting is wrong? No! Sorting is correct
     *       according to score but the relative order of the things has
     *       changed. (Score is same, but Aman2 comes first then unstable 
     *       sort). So, the relative order only talked about things which 
     *       have same parameter i.e. Score. So:
     *       (a) when relative order is same => Stable Sort
     *       (b) When relative order is changes => Unstable Sort
     * 
     * Q. What is In-place Sort?
     * => Sorting algorithm where we do not use extra space.
     *    (Swapping positions without using extra space.)
    */

    /**
     * Types of Sorting Algorithms:
     * 1. Comparison Based: [TC: O(n^2), SC: O(1)]
     *    a. Bubble Sort
     *    b. Insertion Sort
     *    c. Selection Sort
     * 
     * 2. Divide & Conquer Based/Optimized Approach:
     *    a. Merge Sort
     *    b. Quick Sort
     *    c. Heap Sort
     * 
     * 3. Counting Based:
     *    a. Count Sort
     *    b. Radix Sort
     *    c. Bucket Sort
     *    
    */
}
