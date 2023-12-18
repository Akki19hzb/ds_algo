//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
//26. Remove Duplicates from Sorted Array

package Practice;

class Solution {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        int i = 0, p=0;
        while(i <len-1){
            if(nums[i] < nums[i+1] ){
                nums[++p] = nums[i+1];
            }
            i++;
        }
        return p+1;
    }
}