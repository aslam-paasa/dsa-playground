package _23_basic_sorting_algorithms;

public class _10_comparator {
    /**
     * Till now, we have only sorted things in ascending order.
     * How we are going to sort things in descending order?
     * (a) Check the condition
     * (b) Sort in ascending order & take the reverse
     *     And to this we have something called Comparator fn.
    */

    /**
     * Custom Sorting with Comparator:
     * Q. Sort an array in ascending order by the number of factors.
     * => If no. of factors is same then sort in ascending order of
     *    value.
     * 
     * Example-1: 
     * Input  : [1, 9, 6, 13, 12]
     * factor :  1  3  4  2   6
     * Output : [1, 13, 9, 6, 12]
     * 
     * Example-2:
     * Input  : [9, 3, 10, 6, 4]
     * Factor :  3  2  4   4  3  
     * 
     * => (3,3, 4,4) are creating confusion. So, need some different
     *    condition.
     * 
     * #Ans with extra info:
     * => [3, 4, 9, 6, 10] => Output-2
     *     2  3  3  4  4
     * 
     * Q. [1, 2, 3, 4]
     *    => a[i] < a[i+1]
     *    => Comparison based sorting.
     *    => Here, comparing 1 values at a time.
     * 
     * Comparison based Sorting
     * => In any sorting algorithm at a time we only need to compare 
     *    2 data points.
     * 
     * Comparator Function:
     * (a) Take two arguments or datatype that has to be compared.
     * (b) Based on our parameter & rules that we define, it should
     *     tell which one is smaller and which is larger.
     * (c) Return type is usually boolean.
     * 
     *     bool Comp(data a, data b) {
     *        return 0/1;
     *               (a) 0: a > b
     *               (b) 1: a < b
     *     }
     * Note: It can also return integer.
     * 
     * Code:
     * => boolean Comp(int a, int b) {
     *       int fact1 = countFactor(a);
     *       int fact2 = countFactor(b);
     *    
     *       if(f1 < f2) {
     *          return true;
     *       }
     * 
     *       if(f1 == f2) {
     *          if(a < b) {
     *             return true;
     *          } 
     *       }
     *       return false;
     *    }
     * 
     * Sorting Algorithm:
     * => It use a comparator function inside it.
     * 
    */

    /**
     * Q. When the sort function actually calls the comparator function?
     * => 
    */
}
