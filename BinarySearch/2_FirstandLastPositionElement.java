Leetcode: 34. Find First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = 0, len= nums.length, r = len-1;
        int[] res = new int[2];
        res[0] =-1; res[1] = -1;
        if(len==0){
            return res;
        }
        if(len==1 && nums[0] == target){
             res[0] =0; res[1] = 0;
            return res;
        }
       
        //First Occurance
        while(l<=r){
            
            int mid = l+(r-l)/2;
            
            if(nums[mid] ==target){
                res[0]= mid; 
                r= mid-1;
            }
            else if(nums[mid]>target){
                r = mid-1;
            }
            else{
                l= mid+1;
            }
        }
        
        //Last Occurance
        l=0;
        r= len-1;   
        while(l<=r){
            
            int mid = l+(r-l)/2;
            
            if(nums[mid] ==target){
                res[1]= mid;
                l= mid+1;
            }
            else if(nums[mid]>target){
                r = mid-1;
            }
            else{
                l= mid+1;
            }
        }
        
        return res;
        
    }
}