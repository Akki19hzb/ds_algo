/*
LeetCode: 169. Majority Element
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Input: nums = [3,2,3]
Output: 3

*/
class Solution {
    public int majorityElement(int[] nums) {
        int res =0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(! hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }
            else{
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            
            if(hm.get(nums[i])> (nums.length)/2){
                res = nums[i];
                break;
            }
        }
       return res; 
    }
}