Leetcode: 744. Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res=' ';
        int l = 0, len= letters.length, r= len-1; 
        int flag =0;
        
        while(l<=r){
            int mid = (l+ (r-l)/2);
            
            if(letters[mid] == target){
                flag =1;
                l= mid+1;
            }
            else if(letters[mid] < target){
                l = mid+1;
            }
            else{
                res = letters[mid];
                r= mid-1;
            }
        }
        if(res == ' '){
            res = letters[0];
        }
        return res;
    }
}