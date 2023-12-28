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
        int j=0, n= nums.length,index=0;
        int[] res = new int[n];
        while(j<n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            j++;
        }
         //(a--> freq, b-->number)
        //Used Min Heap when frequency is not same, but when frquency is same as it should be in decreasing oreder so used max heap there
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                                                    if(a[0]!=b[0])
                                                        return a[0]-b[0]; //min heap
                                                    else
                                                        return b[1]-a[1]; //max heap 
                                                });
        
        hm.forEach((v,f)->{
            int[] temp = new int[]{f,v}; //storing freq in 0 index and value at index 1
            pq.add(temp);
        });

        while(pq.size()>0){
            int[] temp = pq.poll();
            int value = temp[1];
            int freq = temp[0];
            int i=0;
            while(i<freq){
                res[index++] = value;
                i++;
            }
        }
        return res;
    }
}