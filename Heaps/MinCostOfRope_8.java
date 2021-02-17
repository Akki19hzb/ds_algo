/*
GFG: Minimum Cost of ropes

There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output: 
29
Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
*/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        
        //Taking input using class Scanner
        Scanner in = new Scanner(System.in);
        
        //Taking count of testcases
        int t = in.nextInt();
        while (t-- > 0) {
            
            //takling count of elements
            int n = in.nextInt();
            
            //Creating an array of size n
            long arr[] = new long[n];

            //inserting elements to the array
            for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

            //calling minCost method of class solve
            System.out.println(new solve().minCost(arr, n));
        }
    }
}
// } Driver Code Ends


class solve {

    long minCost(long arr[], int n) {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i =0 ; i < n; i++){
            pq.add(arr[i]);
        }
        
        long res =0;
        
        while(pq.size() > 1){
            long first = pq.poll();
            long second = pq.poll();
            
            pq.add(first+second);
            
            res += first+ second;
            //System.out.println(temp+" "+res);
        }
        return res;
    }
}
