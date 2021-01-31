/*
LeetCode: 122. Best Time to Buy and Sell Stock II
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Input: [7,1,5,3,6,4]
Output: 7
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length ==0){
            return 0;
        }
        int profit = 0;
        for(int i =0; i < prices.length-1; i++){
            if(prices[i+1]> prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}