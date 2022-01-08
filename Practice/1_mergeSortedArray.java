//Leetcode 
/*
88. Merge Sorted Array
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int k = 0, i= 0, j=0;
        while(i <= m-1 && j<= n-1){
            if(nums1[i] <= nums2[j]){
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i<=m-1){
            res[k] = nums1[i];
            i++;k++;
        }
        
        while(j<=n-1){
            res[k] = nums2[j];
            j++; k++;
        }
        
        for(int p=0; p< (m+n); p++){
            nums1[p] = res[p];
        }
        
    }
}