/*LC: 438. Find All Anagrams in a String
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> res = new ArrayList<Integer>();
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int t= 0, count =0, k = p.length(), i=0, j=0;
        while(t<k){
            char c = p.charAt(t);
            if(!hm.containsKey(c)){
                hm.put(c,1);
            }
            else{
                hm.put(c, hm.get(c)+1);
            }
            t++;
        }
        count = hm.size();
        
        while(j< s.length()){
            char z = s.charAt(j);
            if(hm.containsKey(z)){
                hm.put(z, hm.get(z)-1);
                
                if(hm.get(z)== 0){
                count--;
                }
            }
            
            
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                
                if(count==0){
                    res.add(i);
                }
                char y= s.charAt(i);
                if(hm.containsKey(y)){
                    hm.put(y, hm.get(y)+1);
                    
                    if(hm.get(y)==1){
                    count++;
                    }
                }
                
                i++;
                j++;
            }
            
        }
        return res;
    }
}