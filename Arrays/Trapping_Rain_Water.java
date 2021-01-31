/*
Leetcode: 42. Trapping Rain Water(Lower Envelope Imagine the graph getting drawn)

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len < 3){
            return 0;
        }
        int res=0, lMax= height[0], rMax = height[len-1];
        int i =0,  j = len-1;
        
        while(i<=j){
            if(lMax<height[i]){
                lMax = height[i];
            }
            if(rMax<height[j]){
                rMax = height[j];
            }
            
            if(lMax < rMax){
                res += lMax-height[i];
                i++;
            }
            else{
                res += rMax-height[j];
                j--;
            }
        }
        return res;
    }
}