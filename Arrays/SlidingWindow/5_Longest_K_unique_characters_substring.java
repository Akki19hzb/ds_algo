/*
GFG - Longest K unique characters substring

Input:
2
aabacbebebe
3
aaaa
1
Output:
7
4
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        int i=0,j=0,size=0,res=0,n=s.length();
        
        while(j<n){
            char c = s.charAt(j);
            if(!hm.containsKey(c))
                hm.put(c,1);
            else
                hm.put(c,hm.get(c)+1);
            size = hm.size();
            
            if(size==k)
                res = Math.max(res,j-i+1);
            else if(size>k){
                while(size>k){
                    char p = s.charAt(i);
                    hm.put(p,hm.get(p)-1);
                    if(hm.get(p)==0){
                        hm.remove(p);
                        size =hm.size();
                    }
                    i++;
                }
            }
            j++;
        }
        return res>0?res:-1;
    }
}