/*
LC: 658. Find K Closest Elements (Medium)

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
*/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        //comparator for the pq
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> {
                                    if(a[0] == b[0])
                                        return a[1] - b[1];
                                    else
                                        return a[0] - b[0];
                                });
        
        for(int i =0 ; i < arr.length; i++){
            int[] a = new int[]{Math.abs(arr[i]-x), i};
            pq.add(a);
        }
        
        while(k>0){
            int[] b = pq.poll();
            res.add(arr[b[1]]); //putting the element of the array using the index fetched from heap(priortiyQueue)
            k--;
        }
        Collections.sort(res); // ans shoulb in ascending order
        return res;
    }
}