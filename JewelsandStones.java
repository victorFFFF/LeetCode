class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        
        if(S.length() == 0 || J.length() == 0)
            return 0;
            
        HashMap<Character, Integer> hMap = new HashMap<>();
        int sum = 0;
        
        for(int i = 0; i< S.length(); i++)
        {
            if(hMap.get(S.charAt(i)) == null)
               hMap.put(S.charAt(i), 1);
            else
                hMap.put(S.charAt(i), hMap.get(S.charAt(i))+1);
        }
        
        for(int i = 0; i < J.length(); i++)
        {
             if(hMap.containsKey(J.charAt(i)))
                 sum += hMap.get(J.charAt(i));
        }
        return sum;
        
    }
}
