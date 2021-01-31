/*
LeetCode: 918. Maximum Sum Circular Subarray
Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
*/


import java.util.*;
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }
        
        int min_so_far=A[0], min_global=A[0], max_so_far =A[0], max_global=A[0]; 
        
        for(int j =1; j< A.length; j++){
            max_so_far = Math.max(A[j], max_so_far+A[j]);
            max_global = Math.max(max_so_far, max_global);
            
            min_so_far = Math.min(A[j], min_so_far+ A[j]);
            min_global = Math.min(min_so_far, min_global);
            
        }
        //System.out.print(max_global+" "+min_global+" "+sum);
        if( sum == min_global){
            return max_global;
        }
        else{
            return Math.max(max_global, sum - min_global);
        }
            
    }
}