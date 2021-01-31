/*
LeetCode: 121. Best Time to Buy and Sell Stock
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min = prices[0];
        int md = 0; // max_diff
        for(int i =1; i< prices.length; i++){
            if(md< prices[i]-min){
                md = prices[i]-min;
            }         
            if(prices[i]<min)
                min = prices[i];
        }
        return md;
    }
}