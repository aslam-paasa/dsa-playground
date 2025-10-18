package _23_basic_sorting_algorithms;

public class _06_min_cost_to_del_array_elements {
    /**
     * Motive: How sorting can help us:
    */

    /**
     * Q. arr = [2, 4, 6, 5]
     *    Delete every element, but there is a cost of deletion of
     *    every element. Total cost of deletion = 17 i.e. Sum of current
     *    elements.
     *    => delete 5 = 17
     *    => delete 2 = 12
     *    => delete 4 = 10
     *    => delete 6 =  6
     *      +--------------+
     *                   45
     * 
     * => It depend upon us, in which order we want to delete. We have to
     *    find a better order whose cost is less.
     *    delete 6 = 17
     *    delete 5 = 11
     *    delete 4 =  6
     *    delete 2 =  2
     *   +--------------+
     *               36
     * 
     * Q. Why should we delete maximum first?
     * => Because if we don't delete maximum then it will again contribute
     *    to the cost next time. So, we have to delete maximum first,
     *    and this is Greedy Algorithm.
     * 
     * Logic:
     * A : [a, b, c, d] => remove: a, b, c ,d
     * => [a, b, c, d]: Remove a => a + b + c + d
     * => [b, c, d]   : Remove b =>     b + c + d
     * => [c, d]      : Remove c =>         c + d
     * => [d]         : Remove d =>             d
     * 
     * Total Cost = a + 2*b + 3*c + 4*d
     *                      |
     *                      V
     *            Minimize this cost
     * 
     * To minimize this cost, we should arrange the elements in 
     * descending order:
     * => Order: a > b > c > d
     *    where, 
     *           d = Smallest element in an array
     *           c = 2nd smallest element in an array
     *           b = 3rd smallest element in an array
     *           a = last smallest element in an array [greatest]
     * 
     * Note: By removing the largest element first, it will only get 
     *       added once, resulting in the minimum cost. So, we should
     *       remove values in descending order.
     * 
     * Example:
     * A : [4, 6, 1]
     * => (a) [4, 6, 1] => Remove-6 => 6 + 4 + 1 = 11
     *    (b) [4, 6]    => Remove-4 => 4 + 1     = 5
     *    (c) [1]       => Remove-1 => 1         = 1
     * => Min Cost => 17
     * 
     * 
     * PseudoCode: Minimum Cost to remove all the array elements
     * sort(arr);
     * int totalCost = 0;
     * for(int i = 0; i < n; i++) {
     *    totalCost += arr[i] * (n-i);
     * }
     * return totalCost;
     * 
     * TC: O(n logn) + O(n) => O(n logn)
     * SC: O(depends on the sorting algo used). 
    */ 
}
