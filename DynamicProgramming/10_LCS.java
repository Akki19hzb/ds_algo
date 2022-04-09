//Leetcode : 1143  Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        char[] c1 = text1.toCharArray();

        char[] c2 = text2.toCharArray();

        int n = c1.length;
        int m = c2.length;

        int[][] dp = new int[n+1][m+1];

        for(int i =0; i< n+1; i++){
            dp[i][0] = 0;
        }


        for(int i =0; i< m+1; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i < n+1; i++){
            for(int j=1; j<m+1; j++){

                if( c1[i-1 ]== c2[j-1]){

                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{

                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }
}