package _09_basic_array_problems;

public class _27_best_time_to_buy_and_sell_stocks {
    /**
     * DP on Stocks (6-problems):
     * Q. Best time to buy & sell stocks:
     * => arr = [7, 1, 5, 3, 6, 4], n = 6
     *    (a) Price is 7 on 1st day.
     *    (b) Price is 1 on 2nd day.
     *    (c) Price is 5 on 3rd day.
     *    (d) Price is 3 on 4th day.
     *    (e) Price is 6 on 5th day.
     *    (f) Price is 4 on 6th day.
     * => We have 'n=6' no of days, and we have to decide
     *    (a) On which day, we will buy the stock 
     *    (b) On which day, we will sell the stock.
     * 
     * Assume, buying the stock cost me 1rs. So, when we will sell it?
     * => When the cost is 6rs. So, the profit we make it 5rs.
     * => First we have buy stock then only we are allowed to sell.
     * => And the profit has to be maximum.
     * 
     * Approach: DP (means remembering the past)
     * => arr = [7, 1, 5, 3, 6, 4]
     * => Suppose we sell the stock at 4rs. So, it means we bought
     *    the stock when it is the minimum price on the left side.
     * Note: If you are selling on ith day. You buy on the minimum
     *       price from the 1st day to i-1 day.
     * 
     * int min = arr[0];
     * int maxProfit = 0;
     * 
     * for(int i = 1; i < arr.length; i++) {
     *    cost = arr[i] - min;
     *    maxProfit = Math.max(maxProfit, cost);
     *    min = Math.min(min, arr[i]);
     * }
     * return maxProfit;
     *
     * TC: O(N)
     * SC: O(1) 
    */

}
