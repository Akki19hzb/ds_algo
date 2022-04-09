// Leetcode 494. Target Sum


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum =0;
        int n = nums.length;
        int cnt =0;
        for(int i = 0; i < n; i++){
            sum += nums[i];

        }
        
        if(sum < S || (S+sum)%2 !=0){
            return 0;
        }
        
        int temp = (S+sum)/2;
        //temp =4;
        
        int[][] dp = new int[n+1][temp+1];
        
        for(int i = 0; i < temp+1; i++)
            dp[0][i]= 0;
        
        for(int i = 0; i < n+1; i++)
            dp[i][0] = 1;
        
        for(int i = 1; i < n+1; i++){
            for(int j= 0; j< temp+1; j++){
                // considering j =0 as in question 0 elements are also included
                if(nums[i-1]<= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
      
        for(int i =0; i< n+1; i++){
            for(int j =0; j< temp+1; j++ ){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
       // int a = (int)(Math.pow(2,cnt));
        return  dp[n][temp];
        
    }
}