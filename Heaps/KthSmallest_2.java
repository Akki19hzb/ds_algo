/*
GFG Kth Smallest Element in an Array 

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Another approach create min heap and pop element till kth 

*/

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    
		    System.out.println(kthSmallest(arr, 0, n-1, k));
		}
	}
	

    
 // } Driver Code Ends


//User function Template for Java

public static int kthSmallest(int[] arr, int l, int r, int k) 
{ 
    //Your code here
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    while(l <=r){
        pq.add(arr[l]);
        
        if(pq.size()> k){
            pq.poll();
        }
        l++;
    }    
    return pq.peek();
} 


// { Driver Code Starts.


}
  // } Driver Code Ends