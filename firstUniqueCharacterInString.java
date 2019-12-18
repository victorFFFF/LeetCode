/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

class firstUniqueCharacterInString {
    public int firstUniqChar(String s) {
       
        HashMap<Character,Integer> hMap = new HashMap<>();
        
        if( s.length()  > 0)
        {
        for(int i = 0; i < s.length() ; i++)
            hMap.put(s.charAt(i), 0 );
        
        for(int i = 0; i < s.length() ; i++)
            hMap.put(s.charAt(i), hMap.get(s.charAt(i) )+1 );
        
        for(int x = 0; x < s.length() ; x++)
        {
            if( hMap.get(s.charAt(x)) == 1 )
                return x;
        }
            
        }
        
        return -1;
            
}
        
}
