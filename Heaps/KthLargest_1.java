/*
215. Kth Largest Element in an Array (Medium)

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Another approach create max heap and pop element till kth 

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}