/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/





class Solution {
    public int trap(int[] height) {
        int res= 0, n= height.length, i=0;
        int[] l = new int[n];
        int[] r = new int[n];

        //left array
        l[0] = height[0];
        for(i = 1; i < n; i++){
            if(height[i]>l[i-1])
                l[i] = height[i];
            else
                l[i] = l[i-1];
        }

        // right array
        r[n-1] = height[n-1];

        for(i = n-2; i>=0; i--){
            if(height[i]> r[i+1])
                r[i] = height[i];
            else
                r[i] = r[i+1]; 
        }

        //finding min of the tower of left and right side of index
        i = 0;

        while(i<n){
            res += (Math.min(l[i],r[i])) - height[i];
            i++;
        }

        return res;
        
    }
}