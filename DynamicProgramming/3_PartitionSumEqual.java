/*
Leetcode 

416. Partition Equal Subset Sum

This is the base for Q11. DP of AV count the number of subset with given differnce 

arr= [1,1,2,3] ; diff =1

S1 - S2 = diff
S1 + S2 = sum
-----------------
2S1 = diff+sum
S1 = (diff+sum)/2
int sum  = (diff+sum)/2
S1 is the subset, so we need to find how many subset we can find as S1

esp(nums, n, S1);


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