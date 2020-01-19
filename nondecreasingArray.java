/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
*/


class nondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int bigger = 0;
        ArrayList<Integer> record = new ArrayList<>();
        
       for(int i = 0; i < nums.length-1; i++)
        {
             for( int j = i; j < nums.length-1; j++)
             {  
                 if(nums[i] > nums[j+1])
                 {
                   if(!record.contains(j+1))
                   {
                     record.add(j+1);
                     bigger++;
                     break;
                   }
                 }
             }
              if(bigger >= 2)
                return false;
        }
            return true;
    }
}
