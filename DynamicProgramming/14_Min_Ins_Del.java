//Leetcode: 583. Delete Operation for Two Strings

class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length(); // string 1
        int m = word2.length(); // string 2

        int[][] dp = new int[n+1][m+1];

        for(int i =0; i <n+1; i++){
            for(int j=0; j<m+1; j++){

                if(i==0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return (n-dp[n][m]) +(m -dp[n][m] );

        // delete operations = string1_length - LCS
        // Insert operations = string2_length - LCS

    }
}