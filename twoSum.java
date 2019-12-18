/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/


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
