// GFG: Max Sum Subarray of size K  
/*
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
*/


import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0, j = 0, sum =0, res = Integer.MIN_VALUE;
        
        while(j <N){
            
            if(j-i+1<k){
                sum += Arr.get(j);
            }
            else if(j -i +1 ==k){
                sum += Arr.get(j);
                res = Math.max(res, sum);
                sum -= Arr.get(i);
                i++;
            }
            j++;
        }
        return res;
    }
}