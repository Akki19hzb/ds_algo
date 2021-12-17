leetcode 33. Search in Rotated Sorted Array

class Solution {
    public int bst(int[] nums,int target, int l, int r){
        
        while(l<=r){
            int mid = l+(r-l)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] <= target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int l =0, len = nums.length, r = len-1;
        int res = nums[l];
        int prev, next;
        while(l<=r){
            //when array is already sorted 
            if(nums[l] <= nums[r]){
                res= l;
                break;
            }
            
            int mid= l+ (r-l)/2;
            prev = (mid+len-1)%len;
            next = (mid+1)%len;
            
            //mid is less then the prev and the next element
            if(nums[mid]<= nums[prev] && nums[mid] <= nums[next]){
                res= mid;
                break;
            }
            else if(nums[mid] >= nums[l]){
                l = mid+1;
            }
            else {
                r= mid-1;
            }
            
        }
        
        int f_res = bst(nums,target,0, res-1);
        if(f_res == -1){        
            f_res = bst(nums,target,res,len-1);
        }
       
        return f_res;
        
    }
}