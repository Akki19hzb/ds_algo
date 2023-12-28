/*
LC: 973. K Closest Points to Origin

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].


*/



class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //Sample traversing of jagged array 
        // for(int[] arr : points){
        //     System.out.println(arr[0]+" "+arr[1]);
        // }
        
        /* Created a Min Heap with comparator based on the distance from origin x*x + y*y */
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> 
                                                (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] +b[1]*b[1])
                                                     );
        for(int[] arr : points){
            //System.out.println(arr[0]*arr[0] + arr[1]*arr[1]);
            pq.add(arr);
        }
        
        int [][] res = new int[K][2];
        
        while(K -- > 0){
            int arr[] = pq.poll();
            //System.out.println(arr[0]*arr[0] + arr[1]*arr[1]);
            res[K][0] = arr[0];
            res[K][1] = arr[1];
        }
        
        return res;
    }
}