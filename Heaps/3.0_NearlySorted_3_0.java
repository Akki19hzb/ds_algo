/*
GFG: Nearly sorted


Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

Input:
First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.

Output:
Single line output to print the sorted array.


Example:
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56

*/

 //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> res = new ArrayList<>();
        int index =0, i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(i<num){
            pq.add(arr[i]);
            if(pq.size()>k+1){
                res.add(index++,pq.poll());
            }
            i++;
            
        }
        
        while(index<num){
            res.add(index++,pq.poll());
        }
        return res;
    }
