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
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        //Max Heap Created with the distance from origin as comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                return (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]);
        });

        for(int[]point : points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i =0;
        while(pq.size()>0){
            int[] temp = pq.poll();
            res[i][0]=temp[0];
            res[i][1]=temp[1];
            i++; 
        }
        return res;
        
    }
}