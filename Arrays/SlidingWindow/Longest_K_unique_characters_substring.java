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


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int longestKUnique(String s, int k){
        HashMap<Character,Integer> hm = new HashMap<>();
        int i=0, j=0, len= s.length(), size =0, res =-1;
        
        while(j<len){
            if(!hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j),1);
            }
            else{
                hm.put(s.charAt(j), hm.get(s.charAt(j))+1);
            }
            size = hm.size();
            if(size==k){
                res = Math.max(res, j-i+1);
            }
            else if(size>k){
                while(size>k && i <= j){
                    int val = hm.get(s.charAt(i))-1;
                    if( val==0){
                        hm.remove(s.charAt(i));
                        size = hm.size();
                    }
                    else{
                        hm.put(s.charAt(i), val);
                    }
                    i++;
                }
            }
            j++;
        }
        //System.out.println(i+" "+j);
        return res ;
    }

    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String s = sc.next();
		    int k = sc.nextInt();
		    int res = longestKUnique(s,k);
		    System.out.println(res);
		}
	}
}