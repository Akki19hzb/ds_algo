/**
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
**/


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int mLen=0,sum=0;
        
        for(int i =0; i < N; i++){
            sum += A[i];
            
            if(sum==K){
                mLen= i+1;
            }
            
            if(!hm.containsKey(sum))
                hm.put(sum,i);
                
            if(hm.containsKey(sum-K)){
                mLen = Math.max(mLen, i- hm.get(sum-K));
            }
        }
        
        return mLen;
    }
    
    
}
