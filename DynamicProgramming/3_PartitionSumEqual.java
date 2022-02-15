/*
Leetcode 

416. Partition Equal Subset Sum


*/

class Solution {
    public boolean canPartition(int[] nums) {
        
        int len = nums.length;
        int sum =0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        
        if(sum %2 != 0){
            return false;
        }
        return esp(nums, len, sum/2);
    }
    
    public static boolean esp(int[] nums, int n, int sum){
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                   // System.out.println("i="+ i);
                    if(nums[i-1] <=  j){
                        dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                        
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                    
                }
            }
        }
        return dp[n][sum];
    }
}