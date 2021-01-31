/*
Leetcode: 53. Maximum Subarray

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max_sf= nums[0] , max_global = nums[0];
        int i =1;
        while(i<nums.length){
            if(max_sf+nums[i]<nums[i]){
                max_sf = nums[i];
            }
            else{
                max_sf = max_sf+nums[i];
            }
            
            if(max_global<max_sf){
                max_global = max_sf;
            }
            i++;
        }
        return max_global;
    }
}