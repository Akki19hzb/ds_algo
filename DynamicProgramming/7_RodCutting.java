import java.util.Scanner;
class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            GFG obj = new GFG();
            System.out.println(obj.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class GFG {
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n+1][n+1];
        
        int[] len = new int[n];
        for(int i =0; i <n; i++){
            len[i] = i+1;
        }
        
        for(int i =0; i < n+1; i++){
            dp[0][i] = 0;
        }
        
        for(int i =0 ; i < n+1; i++){
            dp[i][0] =0;
        }
        
        for(int i =1; i < n+1; i++){
            for(int j =1; j<n+1; j++){
                if(len[i-1] <=j ){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]],
                                dp[i-1][j]
                    );
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}