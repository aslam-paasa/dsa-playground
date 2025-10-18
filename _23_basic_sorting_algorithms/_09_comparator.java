package _23_basic_sorting_algorithms;

public class _09_comparator {
    /**
     * Comparator:
     * Comparator is a fn which compares two integers. It is suppose to
     * tell whether 'a' will come before 'b' or not.
     * (a) If 'a' is before 'b', return true.
     * (b) If 'b' is before 'a', return false.
     * 
     * boolean comp(int a, int b) {
     *    // whether a is before b or not
     *    // (a) If a is before b, return true
     *    // (b) If b is before a, return false
     * }
     * 
     * Ex: Sort in decreasing order.
     * => if(a < b) {
     *       return false;
     *    } else {
     *       return true;
     *    }
     * 
     * Q. How to we use this comparator?
     * => Write sort() and pass the arrayName and the comp as param:
     * 
     *    sort(arr, comp)
     * 
     * => If arr is integer, it will arrange in ascending order, and if
     *    it is string then it will arrange in lexographical order.
     * => But if we give it a comp function, everytime before comparison
     *    it will check not according to in-built logic but according
     *    to our given logic.
     * 
     *     0     1      2    3 
     * Q. "98", "998", "9", "89". How will we arrange these nums to get
     *    the largest possible numbers?
     * => Idx: 2 1   0  3
     *         9 998 98 89
     * 
     * Q. Two strings 'a' & 'b'. How would you rearrange them?
     * => Ther is only two arrangement:
     *    (a) [a, b] => a + b ('+' means concat)
     *    (b) [b, a] => b + a
     * => if(a+b > b+a) {
     *       return true;
     *    } else {
     *       return false;
     *    }
     * => And then we just need to sort all of these string using the
     *    comparator function.
    */
}
