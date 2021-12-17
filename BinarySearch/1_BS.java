LeetCode: 704 BinarySearch

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;  
        int s = 0, e = nums.length-1;
            while(e>=s){
            
            int mid = (e+s)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                e= mid-1;
            }
            else{
                s= mid+1;
            }
            
            }
            return -1;
        }

}

