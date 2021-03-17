/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/



class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        
        
        int length = s.length();
        StringBuilder str = new StringBuilder();
        
        for( int i = 0; i < length/2; i++)
        {
            for( int j = 0; j < length/(1+i); j++)
            {
                str.append(s.substring(0, i+1));
            }
            
            if( str.toString().equals(s))
                return true;
                
          str.setLength(0);
            
        }
        
        return false;
    }
}