/*
LC:1636. Sort Array by Increasing Frequency

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.


Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

*/





class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        //Creating Hash (key--> Number, val --> Frequency) 
        for(int i=0; i< nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        
        // Created a Min heap (condition if the freq is same the higher value should be given preference)
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) ->{
                                                    return (a[0] == b[0] ? b[1] -a[1] : a[0] -b[0]);});
    
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            /* Adding element to queue (frequecy, element) and
            frequency is getting used for sorting
            */
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }
        int p =0;
        while(pq.size()> 0){
            int[] temp = pq.poll();
            for(int i = 0; i < temp[0]; i++){
                nums[p] = temp[1];
                p++;
            }
        }
        return nums;
        
    }
}