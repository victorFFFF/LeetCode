/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/

class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    String[] associateArray = strs.clone();

      //Sorting each individual element in alphabetical order
      for(int i = 0; i < strs.length; i++)
      {
        char[] arrayChar = strs[i].toCharArray();
        Arrays.sort(arrayChar);
        strs[i] = new String(arrayChar);
      }

      List< List<String> > wholeList = new ArrayList<>();
      
    //Loop through entire sorted array and compare each element, if the 2 strings are equal then insert it into a arrayList named partList.
      for(int i = 0; i < strs.length; i++)
      { 
          //make a new arraylist for partLis everytime i increase by 1
          List<String> partList = new ArrayList<>();
          
        if(strs[i] != null)
        {
          partList.add(associateArray[i]);

          if( i != strs.length-1)
            {
                for(int j = i ; j < strs.length-1; j++)
                {
                            if(strs[i].equals(strs[j+1]))
                            {
                              partList.add(associateArray[j+1]);
                              strs[j+1] = null;
                            }
                }
            }
         //Setting strs[i] to null so we will know if it is already inserted into the partList
          strs[i] = null;  
            
        //Add the partList into a elemnt of wholeList.
        //Each element wholeList contains a arrayList of partList
          wholeList.add(partList);
        }
      }
      return wholeList;      
  }
    
}
