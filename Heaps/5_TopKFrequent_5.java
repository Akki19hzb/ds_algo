/*
LC: 347. Top K Frequent Elements

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        //Creating Hash (key--> Number, val --> Frequency)
        for(int i =0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            
            //Below logic replaced by getOrDefault method of hashMap.
            /* if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
                }
                else{
                    hm.put(nums[i], hm.get(nums[i])+1);
             }*/
        }
        
        // Max Heap Customised Comparator 
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> {return (a[0] == b[0]) ? (b[1]-                                                              a[1]) : (b[0]-a[0]);}
                                                     );
        Iterator itr = hm.entrySet().iterator();
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry)(itr.next());
            int element = (int)(me.getValue());
            int key = (int)(me.getKey());
            /* Adding element to queue (frequecy, element) and
            frequency is getting used for sorting
            */
            
            pq.add(new int[]{element, key});
        }
        
        
        int[] res = new int[k];
        /* Elements with highest frequency is at the top of the heap, 
        so polling one by one to get top  k elements
        */
        for(int i =0; i < k; i++){
            int[] temp = pq.poll();
            res[i] = temp[1];
        }
        

        return res;
    }
}