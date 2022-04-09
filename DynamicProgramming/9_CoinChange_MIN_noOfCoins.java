//Leetcode : 322: Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i< amount+1; i++){
            dp[0][i] = Integer.MAX_VALUE -1; // Change in code when the array is empty and sum i.e; amount we  need to get

            // We are using Integer.MAX_VALUE -1 not Integer.MAX_VALUE as we are adding 1 in code value this will make it a negative value
        }


        for(int i=1; i< n+1; i++){
            dp[i][0] =  0;
        }

        for(int i =1; i< n+1; i++){
            for(int j=1; j< amount+1; j++){

                if(coins[i-1] <=j){

                    dp[i][j] = Math.min((dp[i][j-coins[i-1]]+1) , dp[i-1][j]);  //Change in code
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        if(dp[n][amount] == Integer.MAX_VALUE-1)
            return -1;
        else
            return dp[n][amount];
    }
}