/*We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"] */



class uncommonWordsFromTwoSentences{
    public String[] uncommonFromSentences(String A, String B) {
        
        HashMap<String, Integer> hMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> uncommon = new ArrayList<>();
        int start = 0;
        
    if(A.length() == 0 && B.length() == 0)
    {
        return new String[]{""};
    }
        
    else
    {
        for(int i = 0; i< A.length(); i++)
        {
            if(A.charAt(i) == ' ')
            {
                if(hMap.containsKey(A.substring(start,i)))
                    hMap.put(A.substring(start,i),1);
                else
                {
                    hMap.put(A.substring(start,i),0);
                    list.add(A.substring(start,i));
                }
                
                 start = i+1;
            }
            if(i == A.length()-1)
            {
                if(hMap.containsKey(A.substring(start,i+1)))
                    hMap.put(A.substring(start,i+1),1);
                else
                {
                    hMap.put(A.substring(start,i+1),0);
                    list.add(A.substring(start,i+1));
                }
            }
        }
        
        
        
        
         start = 0;
        for(int i = 0; i< B.length(); i++)
        {
            if(B.charAt(i) == ' ')
            {
                if(hMap.containsKey(B.substring(start,i)))
                    hMap.put(B.substring(start,i),1);
                
                else
                {
                    hMap.put(B.substring(start,i),0);
                    list.add(B.substring(start,i));
                }
                
                start = i+1;
            }
            
            if( i == B.length()-1 )
            {
                if(hMap.containsKey(B.substring(start,i+1)))
                     hMap.put(B.substring(start,i+1),1);
                else
                {
                    hMap.put(B.substring(start,i+1),0);  
                    list.add(B.substring(start,i+1));
                }
            }
        }
        
        
    }
        
        for(int i = 0; i < list.size() ; i++)
        {
            if( hMap.get(list.get(i)) == 0)
                uncommon.add(list.get(i));           
        }
        

            
        return uncommon.toArray(new String[uncommon.size()]);
}
}
        
