/*

85. Maximal Rectangle (Hard)

*/


class Solution {
    public static int[] NSL(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int res[] = new int[arr.length];
        int i = 0;
        
        while(i < arr.length){
            if(stk.empty()){
                res[i] =-1;
            }
            else if(arr[stk.peek()]>= arr[i]){
                while(!stk.empty() && arr[stk.peek()]>= arr[i])
                    stk.pop();
                if(stk.empty())
                    res[i] = -1;
                else
                    res[i] = stk.peek();
                
            }
            else{
                res[i] = stk.peek();
            }
            stk.push(i);
            i++;
        }
        return res;
    }
    
    public static int[] NSR(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int res[] = new int[arr.length];
        int len = arr.length;
        int i = len-1;
        
        while(i >-1){
            if(stk.empty()){
                res[i] =len;
            }
            else if(arr[stk.peek()]>= arr[i]){
                while(!stk.empty() && arr[stk.peek()]>= arr[i])
                    stk.pop();
                if(stk.empty())
                    res[i] = len;
                else
                    res[i] = stk.peek();
                
            }
            else{
                res[i] = stk.peek();
            }
            stk.push(i);
            i--;
        }
        return res;
    }
    
    public int MAH(int[] heights){
        int len = heights.length;
        int nsl[] = new int[len];
        int nsr[] = new int[len];
        nsl = NSL(heights);
        nsr = NSR(heights);
        int area = 0;
        for(int i=0; i < len;i ++){
            area = Math.max(area, (nsr[i]-nsl[i]-1)*heights[i]);
        }
    return area;
    }
    
    
    public int maximalRectangle(char[][] matrix) {
        int len = matrix[0].length;
        if (len == 0)
            return 0;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = Character.getNumericValue(matrix[0][i]);
        }
        
        int mx = MAH(arr);
        
        for(int i=1; i < matrix.length; i++){
            for(int j = 0; j<len; j++){
                if(Character.getNumericValue(matrix[i][j])==0){
                    arr[j] = 0;
                }
                else{
                    arr[j] += Character.getNumericValue(matrix[i][j]);
                }
            }
            mx = Math.max(mx, MAH(arr));
        }
        return mx;
    }
}