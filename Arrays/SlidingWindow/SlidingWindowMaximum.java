/*
LC: 239. Sliding Window Maximum

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

*/

import java.util.*; 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> ll = new ArrayDeque<>();
        int i =0, j =0, p=0;
        System.out.println(len);
        while(j<len){
            while(ll.size()>0 && ll.peekLast() < nums[j]){
                ll.pollLast();
            }
            
            ll.add(nums[j]);
            
            if(j-i+1 <k){                
                j++;
            }
            
            else if(j-i+1==k){
                res[p] = ll.peek();                
                p++;
                if(ll.peek() == nums[i]){
                    ll.pollFirst();
                }
                i++;
                j++;
                
            }
           
        }
        return res;
    }
}