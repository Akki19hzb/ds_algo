/*
GFG: Nearly sorted


Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.


Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void nsa(int[] arr, int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index =0;
        for(int i = 0; i < n; i++){
            //System.out.println(arr[i]);
            if(pq.size() >= k+1){
                arr[index++] = pq.peek();
                pq.poll();
            }
            pq.add(arr[i]);
            //System.out.println("i= "+i+" index= "+ index +" "+ arr[index]+" "+pq);
        }
        Iterator<Integer> itr = pq.iterator();
        
        while(itr.hasNext()){
            arr[index++] = pq.peek();
                pq.poll();
        }

    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < n ; i++){
		        arr[i] = sc.nextInt();
		    }
		    nsa(arr,n,k);
		    for(int i = 0; i < n; i++){
		        System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		}
		
		//
	}
}