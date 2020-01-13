/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/


//MY Solution. 
class findAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
    
        ArrayList<Integer> list = new ArrayList <>();
        Arrays.sort(nums);
        
        for(int i =0; i < nums.length; i++)
        {
            if( i != 0)
            {
                if(nums[i-1] == nums[i])
                    list.add(nums[i]);
            }
        }                  
        return list;
    }
}





//Fast approach but uses extra space. Not my code
public class findAllDuplicatesInAnArray {
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) 
        {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(nums[i]));   
            nums[index] = -nums[index];
        }
        return res;
    }
}
