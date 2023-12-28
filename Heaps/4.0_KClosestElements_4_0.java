/*
LC: 658. Find K Closest Elements (Medium)

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
         //comparator for the pq (int[] stores pair (a,b))
        // a is the abs diff and b is the number itself 
        //using MAX HEAP
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> {
                                    if(a[0] == b[0])
                                        return b[1] - a[1];
                                    else
                                        return b[0] - a[0];
                                });

        int i =0;

      //Adding all the elements in the PQ and if it is more than the req K we poll means discarding the larger element keeping the smallest i.e; closest
        while(i<arr.length){
            pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});
            if(pq.size()>k){
                pq.poll();
            }
            i++;
        }
        i=0;
      //iterating the PQ to get the result stored 
        while(i<k){
            int[] a = pq.poll();
            res.add(a[1]);
            i++;
        }
        Collections.sort(res);
        return res;
    }
}
