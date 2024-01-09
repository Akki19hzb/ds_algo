/*
GFG: Next Greater Element

Input: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1

*/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new solve().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        long[] res = new long[n];
        Stack<Long> stk = new Stack<>();
        int  p = n-1;
        
        while(p>-1){
            if(stk.empty()){
                res[p] = -1;
            }
            
            else if(stk.peek() >arr[p]){
                res[p] = stk.peek();
            }
            else{
                while(!stk.empty() && stk.peek() <arr[p] ){
                    stk.pop();
                }
                
                if(stk.empty()){
                    res[p] = -1;
                }
                else{
                    res[p] = stk.peek();
                }
            }
            stk.push(arr[p]);

            p--;
        }
    
        return res;
    } 
}