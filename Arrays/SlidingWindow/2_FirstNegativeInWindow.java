/*
GFG- First negative integer in every window of size k

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains n space separated integers forming the array. The last line contains the window size k.

Output:
Print the space separated negative integer starting from the first till the end for every window size k. If a window does not contain a negative integer , then print 0 for that window.


Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void firstNegativeInteger(int[] nums, int n, int k){
        LinkedList<Integer> ll = new LinkedList<>();
        int i = 0, j=0;
        
        while(j<n){
            if(nums[j]<0){
                ll.add(nums[j]);
            }
            if(j-i+1 <k){
                j++;
            }
            else if(j-i+1==k){
                if(ll.size()==0){
                    System.out.print("0 ");
                }
                else{
                    System.out.print(ll.peek()+" ");
                    
                    if(nums[i] == ll.peek()){
                        ll.pop();
                    }
                    
                }
                i++;
                j++;
            }
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--> 0){
		    int n = sc.nextInt();
		    int[] nums = new int[n];
		    for(int i =0; i <n ; i++){
		        nums[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		    firstNegativeInteger(nums,n,k);
		    System.out.println();
		}
	}
}
