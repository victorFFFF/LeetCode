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
           
        HashMap<String, Integer> hMap = new HashMap <>();
        List<String> list = new ArrayList<>();
        List<String> uncommon = new ArrayList<>();
        
        
        
    if(A.length() == 0 && B.length() == 0)
    {
        return new String[]{""};
    }
        
    else
    {
        String[] A2 = A.split(" ");
        String[] B2 = B.split(" ");
        
        
        for(int i = 0; i < A2.length; i++)
        {
            if(hMap.containsKey(A2[i]))
                hMap.put(A2[i],1);
            else
            {
                hMap.put(A2[i],0);
                list.add(A2[i]);
            }
        }
        
          for(int i = 0; i < B2.length; i++)
            {
                if(hMap.containsKey(B2[i]))
                    hMap.put(B2[i],1);
                else
                {
                    hMap.put(B2[i],0);
                    list.add(B2[i]);
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
        
