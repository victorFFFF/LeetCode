/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/


class binarySearch {
    public int search(int[] nums, int target) {    
        
       int result = binarySearch(0, nums.length-1 , target, nums);
        
        return result;
    }
    
    
    public int binarySearch(int left, int right, int theTarget, int [] array)
    {
        int mid = left + (right-left)/2;
        
        if( left <= right && right >= left )
        {
            if(theTarget == array[mid])
               return mid;
            if(theTarget < array[mid])
              return  binarySearch(left, mid-1, theTarget, array);
            else
                return binarySearch(mid+1, right, theTarget, array);
        }
        else
            return -1;   
    }
}
