/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0*/


class findMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        
        if(nums.length != 0)
        {
            int min = nums[0];
            
            for(int i =0; i < nums.length; i++)
            {
                if(nums[i] <= min )
                    min = nums[i];
            }
                return min;    
        }
        return -1;
    }
}
