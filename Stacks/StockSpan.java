/*
GFG: Stock span problem

Input: 
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6

*/

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new solve().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends


class solve{
    
    // Function to calculate span
    // price[]: input array
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stk = new Stack<>();
        int i =0;
        int[] res = new int[n];
        
        while(i<n){
            if(stk.empty()){
                res[i] = i+1;
            }
            else if(price[stk.peek()] <= price[i]){
                while(!stk.empty() && price[stk.peek()] <= price[i]){
                    stk.pop();
                }
                if(stk.empty()){
                    res[i]= i+1;
                }
                else{
                    res[i] = i- stk.peek();
                }
            }
            else{
                res[i] = i- stk.peek();
            }
            stk.push(i);
            i++;
        }
        return res;
    }
    
}