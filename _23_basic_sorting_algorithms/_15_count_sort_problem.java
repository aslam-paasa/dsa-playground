package _23_basic_sorting_algorithms;

public class _15_count_sort_problem {
    /**
     * Count Sort based Question:
     * Q. Array, all elements b/w 10^9+3 to 10^9+300.
     *    Sort this array in O(n).
     * 
     * Can we create a simple count array where we can count everything?
     * => Count arr means my max no. will will be covered i.e. count[10^9+300]
     * => So, do you think this is possible to create count[10^9+300]? No!
     * 
     * If this is not possible then how we can solve this?
     * => Idea: HashMap => But hashmap cannot solve this, because in hashmap
     *                     keys are not in sorted form, and if keys are not
     *                     in sorted form then how can we sort our array 
     *                     using hashmap.
     * 
     * => Idea: Creating a count arr, but consider 10^9+3 to 0 which is common
     *          in both. So, 
     *          a. 10^9 + 3 = 0
     *          b. 10^9 + 4 = 1
     *          c. 10^9 + 5 = 2
     *          .....
     *          .....
     *          z. 10^9 + 300 - (10^9+3)= 297  
     * 
     *    Size of this arr will be 298.
     * 
     *    So, create an array of count(298) and whatever num comes, we
     *    will get the index by count[x - (10^9+3)]++
     * 
     * Ex: count[10] = 47
     *     number = 10 + (10^9 + 3)
     * 
     * 1. If we want to go from number to index, do:
     * =>           -10^9+3
     *        number -----> idx
     * 
     * 2. If we want to go from index to number, do:
     * =>     number <----- idx
     *               +10^9+3
     *  
     *    
    */
}
