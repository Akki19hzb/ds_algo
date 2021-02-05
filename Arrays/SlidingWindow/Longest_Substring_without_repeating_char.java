/*
LC: 3. Longest Substring Without Repeating Characters

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

*/

import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> temp = new HashSet<Character>();
        int a_pointer=0, b_pointer=0, res = 0;
        while(b_pointer < s.length()){
            if(!temp.contains(s.charAt(b_pointer))){
                temp.add(s.charAt(b_pointer));
                b_pointer++;
                res = Math.max(res,temp.size());
            }
            else{
                temp.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return res;
    }

}