/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
*/

class findWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
    
        int sum = 0;
        HashMap<Character, Integer> hMap = new HashMap<>();
        HashMap<Character, Integer> copyMap;
        
        for( int i = 0; i < chars.length(); i++)
        {
            if( hMap.get(chars.charAt(i)) == null)
                hMap.put(chars.charAt(i),1);
            else
                hMap.put(chars.charAt(i),hMap.get(chars.charAt(i)) +1);
        }     
        copyMap = (HashMap)hMap.clone();
   
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
               if( copyMap.get(words[i].charAt(j)) == null)
                   break;
              else if(  copyMap.get(words[i].charAt(j)) <= 0)
                  break;
                else
                {
                    if( j == words[i].length()-1 )
                        sum += words[i].length();
                    copyMap.put( words[i].charAt(j), copyMap.get(words[i].charAt(j))-1);
                }
            }
            copyMap = (HashMap)hMap.clone();
        }
        return sum;        
    }
}



//More time efficient solution 
//Not my solution

    public int countCharacters(String[] words, String chars) {
        int[] c = new int[128];
        //count the num of each character
        for (char ch : chars.toCharArray()) {
            c[ch]++;
        }
        
        int res = 0;
        for (String s : words) {
            //create copy of count array for this word
            int[] c2 = Arrays.copyOf(c, 128);
            boolean valid = true;
            for (char ch : s.toCharArray()) {
                c2[ch]--;
                //if we don't ave enough count of character
                if (c2[ch] < 0) {
                    valid = false;
                    break;
                }
            }
            //if we can form the word - add it's length to the result
            if (valid) {
                res+= s.length();
            } 
        }
        return res;
    }
