Leetcode: 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, len = nums.length, r = len-1;
        
        if(len==1){
            return 0;
        }
        
        while(l <=r){
            
            int mid = l+(r-l)/2;
            
            if(mid>0 && mid <len-1){
                
                if(nums[mid]> nums[mid-1] && nums[mid] > nums[mid+1]){
                    return mid;
                }
                else if(nums[mid+1]> nums[mid]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else{
                if(mid==0){
                    if(nums[0] > nums[1]){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    if(nums[len-1] > nums[len-2]){
                        return len-1;
                    }
                    else{
                        return len-2;
                    }
                }
            }
            
        }
        return -1;
    }
}