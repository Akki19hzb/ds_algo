//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
class GFG {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc=new Scanner(System.in);

        //taking total testcases
        int t=sc.nextInt();

        sc.nextLine();
        while(t-->0)
        {
            //taking String X and Y
            String S[]=sc.nextLine().split(" ");
            String X=S[0];
            String Y=S[1];

            //calling function shortestCommonSupersequence()
            System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
        }
    }





}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[m+1][n+1];
        int res =0;

        for(int i =0; i<m+1; i++){
            for(int j =0; j< n+1; j++){
                if( i==0|| j==0){
                    dp[i][j] = 0;
                }
                else if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        //m+n - dp[m][n]
        res = m+n -dp[m][n];  // This the main logic to understand
        //System.out.println(m+n +" "+ dp[m][n]);
        return res;
    }
}