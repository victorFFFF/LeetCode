/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/


class reverseWordsInaStringIII {
    public String reverseWords(String s) {
        
        int start = 0;
        int end = 0;
        char[] c = s.toCharArray();
        
      for(int i = 0; i < c.length; i++)
      {
          if(c[i] == ' ')
          {
              end = i-1;
              reverse(start, end, c);
              start = i+1;
          }
          
          if( i == c.length-1)
          {
              end = i;
              reverse(start, end, c);
          }
      }
        return String.valueOf(c);   
    }
    
    public void reverse(int start, int end, char [] charReverse)
    { 
        char temp;   
      
        while( start != end &&  start < end)
        {
           temp =  charReverse[start];
           charReverse[start] = charReverse[end];
           charReverse[end] = temp;
            
            start++;
            end--;
        }
    }
    
}
