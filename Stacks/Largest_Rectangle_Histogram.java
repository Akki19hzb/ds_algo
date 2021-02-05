/*
LC: 84.Largest Rectangle in Histogram

Input: [2,1,5,6,2,3]
Output: 10	

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
    
    public int largestRectangleArea(int[] heights) {
        
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
}