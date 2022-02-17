//Initial Template for Java

/**
 * Logic
 * S1 + S2 = Sum
 * goal is to min (S2-S1)
 * diff = S2- S1
 * diff = Sum- 2S1
 * 
 * In dp last row holds all the elemetns of the array so loop to the half of set
 * and check that element is present or not
 */

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDiffernce(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDiffernce(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range =0; //sum
	    
	    for(int i =0;  i< n; i++){
	        range += arr[i];
	    }
	    int sum = range;
	    range = range/2;
	    boolean[][] dp = new boolean[n+1][range+1];
	    
	    for(int i = 0; i < range+1; i++){
	        dp[0][i] = false;
	    }
	    
	    for(int i = 0; i< n+1; i++){
	        dp[i][0] = true;
	    }
	    
	    for(int i =1; i < n+1; i++){
	        for(int j =1; j< range+1; j++){
	            if(arr[i-1] <= j){
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            else{
	               dp[i][j] = dp[i-1][j]; 
	            }
	        }
	    }
	    
	    /*for(int i =0; i< n+1; i++){
            for(int j =0; j< range+1; j++ ){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        
	    
	    int diff = Integer.MAX_VALUE;
	    
	    //System.out.println("ranGE"+ range);
	    for(int j = range; j>=0; j--){
	         if (dp[n][j] == true)
            {
                diff = sum - 2 * j;
                break;
            }
	    }
	    
	    return diff;
	} 
}
