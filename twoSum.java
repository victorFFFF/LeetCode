class twoSum {
public int[] twoSum(int[] nums, int target) {
    HashMap <Integer, Integer> theHashMap = new HashMap <>();
    
    for(int i = 0; i < nums.length ; i++)
    {
        theHashMap.put(nums[i], i);
    }
    
    for(int i = 0; i < nums.length ; i++)
    {
        int compliment = target - nums[i];
        if(theHashMap.containsKey(compliment) && i != theHashMap.get(compliment))
            return new int[]{i,theHashMap.get(compliment)};
    }
    
        return null;
}
}
