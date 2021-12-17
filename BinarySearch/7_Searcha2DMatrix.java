Leetcode: 74. Search a 2D Matrix

class Solution {
    
    public int[] search(int[][] mat, int t){
        int m= mat.length, n=mat[0].length;
        int i=0, j= n-1;
        int[] res = new int[2];
        
        while(i>=0 && i <m && j>=0 && j<n){
            if(mat[i][j] == t){
                res[0] = i; res[1] =j;
                return res; 
            }
            else if(mat[i][j] > t){
                j--;
            }
            else{
                i++;
            }
        }
        res[0]=-1; res[1] =-1;
        return res;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int[] res = search(matrix,target);
        
        if(res[0] == -1){
            return false;
        }
        else{
            return true;
        }
    }
}