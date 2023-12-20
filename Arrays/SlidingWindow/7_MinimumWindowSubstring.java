/**
https://leetcode.com/problems/minimum-window-substring/

LC: 76

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

**/

class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(),tLen = t.length(),res_len = Integer.MAX_VALUE;
        int p=0,i=0,j=0,start=0,end=0,count =0;

        if(tLen > sLen)
            return "";        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(p<tLen){
            char c = t.charAt(p);
            hm.put(c,hm.getOrDefault(c,0) + 1);
            p++;
        }
        count = hm.size();

        while (j < sLen){
            char c = s.charAt(j);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c) - 1);

                if(hm.get(c) == 0){
                    count--;
                }
            }

            while (count == 0) {
                if(res_len > j - i + 1) {
                    res_len =  j - i + 1;
                    start = i;
                    end = j + 1;
                }
                char q = s.charAt(i);
                if (hm.containsKey(q)) {
                    hm.put(q, hm.get(q) + 1);
                    if (hm.get(q) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return s.substring(start,end);
    }
}
