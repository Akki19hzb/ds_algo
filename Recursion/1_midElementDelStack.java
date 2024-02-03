/*
GFG

Input: 
Stack = {10, 20, 30, 40, 50}
Output:
ModifiedStack = {10, 20, 40, 50}


Input: 
Stack = {10 20 30 40}
Output:
ModifiedStack = {10 30 40}


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

*/ 

//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        int k = (sizeOfStack/2)+1;
        solve(s, k);
            
    } 
    
    private void solve(Stack<Integer> s, int k){
        
        if(k==1){
            s.pop();
            return;
        }
        
        int temp = s.pop();
        solve(s,k-1);
        s.push(temp);
    }
}

