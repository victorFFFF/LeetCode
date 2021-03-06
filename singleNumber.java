/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4*/

class singleNumber {
    public int singleNumber123(int[] nums) {
        
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            hMap.put(nums[i],0);
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            hMap.put(nums[i],hMap.get(nums[i])+1);
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if( hMap.get(nums[i]) == 1)
                return nums[i];
        }
        return -1;
    }
}
