//Leetcode: 392. Is Subsequence


class Solution {
    public boolean isSubsequence(String s, String t) {


        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i =0; i < n+1; i++){
            for(int j = 0; j <m+1; j++){

                if(i==0 || j ==0){
                    dp[i][j] = 0;
                }
                else if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int len = dp[n][m];

        return (len==n? true:false);

    }
}