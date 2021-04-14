class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int longest = 0;
        int current = 0;
        Queue<Character> q = new LinkedList<>();
        int [] ascii  = new int[128];
        int length = s.length();
        
        for( int i = 0; i < length; i++)
        {
            char c = s.charAt(i);
            //Found no duplicate
            if( ascii[c] == 0)
            {
                q.add(c);
                ascii[c]++;
                current++;
            }
            //Found duplicate
            else{
            
                //Assumes the first char in queue is equal to current char
                char temp = q.remove();
                ascii[temp] = 0;
                current--;
             
                //Only executes if the first char in the queue is not equal to current char
                //Loops until it founds the duplicate character in the queue
                    while( temp != c )
                        {
                            temp = q.remove();
                            ascii[temp] = 0;
                            current--;
                        } 
                //Record the current char
                q.add(c);
                ascii[c]++;
                current++;
            }
            if( current >= longest)
                longest = current;
        }
        return longest;
    }
}