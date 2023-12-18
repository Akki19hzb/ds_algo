/*
LC: 3. Longest Substring Without Repeating Characters

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

*/

import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs =  new HashSet<>();
        int i=0, j=0,res=0, n=s.length();
        while(j<n){
            char c = s.charAt(j);
            if(!hs.contains(c)){
                hs.add(c);
                res = Math.max(res,j-i+1);
                j++;
            }
            else{
                char p = s.charAt(i);
                hs.remove(p);
                i++;
            }
        }
        return res;
    }
}