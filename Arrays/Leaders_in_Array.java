/*
GFG: Leaders in an Array 

	Input:
	N = 6
	A[] = {16,17,4,3,5,2}
	Output: 17 5 2

*/

import java.io.*;
import java.util.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Leader obj = new Leader();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    
		    //appending result to a String
		    for(int i=0; i<res.size(); i++){
		        str.append(res.get(i)+" ");
		    }
		    
		    //printing the String
		    System.out.println(str);
		}
		
	}
}
// } Driver Code Ends


class Leader{
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int max = arr[n-1];
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(max);
        for(int i = n-2; i>=0 ;i--){
            if(arr[i] >= max){
                res.add(arr[i]);
                max = arr[i];
            }
        }
        for (int i = 0; i < res.size() / 2; i++) { 
            Integer temp = res.get(i); 
            res.set(i, res.get(res.size() - i - 1)); 
            res.set(res.size() - i - 1, temp); 
        } 
        return res;
    }
}
