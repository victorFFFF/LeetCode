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

class groupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> list = new ArrayList<>();
    List<String> innerList = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    // Associate array
    String[] strs2 = strs.clone();

    // Alphabetize each string in array
    for (int i = 0; i < strs.length; i++) {
      char[] c = strs[i].toCharArray();
      Arrays.sort(c);
      strs[i] = new String(c);
    }

    // Group up same anagram together
    for (int i = 0; i < strs.length; i++) {

      if (map.get(strs[i]) == null) {
        map.put(strs[i], new ArrayList<>());
        map.get(strs[i]).add(i);
      } else
        map.get(strs[i]).add(i);
    }

    // Finish grouping by putting into the list
    for (int i = 0; i < strs.length; i++) {

      if (map.get(strs[i]) != null) {
        for (int x : map.get(strs[i])) {
          innerList.add(strs2[x]);
        }
        map.remove(strs[i]);
        list.add(innerList);
        innerList = new ArrayList<>();
      }
    }

    return list;

  }
}
