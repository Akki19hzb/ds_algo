/*
 GFG

 Reverse stack without using extra space
Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}

 */


//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.size()==1){
            return;
        }
        
        int temp = s.pop();
        reverse(s);
        insert(s,temp);
    }
    
    private static void insert(Stack<Integer> s , int k ){
        
        if(s.size()==0){
            s.push(k);
            return;
        }
        
        int temp = s.pop();
        insert(s,k);
        s.push(temp);
    }
}