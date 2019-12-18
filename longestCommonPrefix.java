/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String commonString = "";
        int shortest = 100;
        char character;
        
        //find smallest string length in the array
        for(int i = 0; i < strs.length; i++)
        {
          if( strs[i].length() <= shortest)
              shortest = strs[i].length();
        }
        
        //If string array is empty
        if(strs.length > 0)
        {
        for(int i = 0; i < shortest ; i++)
        {
            character = strs[0].charAt(i);
            
            for( int j = 0 ; j < strs.length ; j++)
            {
                if(strs[j].charAt(i) != character)
                    return commonString;
            }
            commonString += Character.toString(character);
        }
    }
        return commonString;
    }
}
