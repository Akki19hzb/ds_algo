//Leetcode: 516. Longest Palindromic Subsequence
class Solution {
    public int longestPalindromeSubseq(String s) {

        StringBuilder s1 = new StringBuilder(s);
        s1.reverse();
        String sb = s1.toString();
        int len = s.length();
        int res =0;
        int[][] dp = new int[len+1][len+1];

        for(int i =0; i < len+1; i++){
            for(int j =0; j <len+1; j++){
                if(i ==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(s.charAt(i-1) == sb.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        res = dp[len][len];
        return res;

    }
}