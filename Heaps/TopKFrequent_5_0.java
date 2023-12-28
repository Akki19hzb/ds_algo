/*
LC: 347. Top K Frequent Elements

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        HashMap<Integer,Integer> hm = new HashMap<>();

        //Used Min Heap (a--> freq, b-->number)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });

        int j =0,n=nums.length;

        while(j<n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            j++;
        }

        
        hm.forEach((v,f)->{
            int[] temp = new int[]{f,v};
            pq.add(temp);
            
            //if pq has more than k elements then the element with least freq is polled out
            if(pq.size()>k){
                pq.poll();
            }
        });

        j=0;
        //iterating the PQ and getting the value stored in pq and putting it in the result
        while(pq.size()>0){
            int[] temp = pq.poll();
            res[j]=temp[1];
            j++;
        }
        return res;
    }
}
