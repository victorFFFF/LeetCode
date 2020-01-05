/*You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.*/

class nextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            List <Integer> arrayList = new ArrayList<>();
        
        //nums1 loop
            for( int i = 0; i < nums1.length; i++)
            {
            
             //nums2 loop
                for(int j = find( nums1[i], nums2 ) ; j < nums2.length; j++)
                {
                    if(nums1[i] < nums2[j])
                    {
                      arrayList.add(nums2[j]);
                      break;
                    }
                    if(j == nums2.length-1)
                        arrayList.add(-1);
                }
            }
    
        //Convert Arraylist into int []
            int [] array = new int[arrayList.size()];

        for(int i = 0; i < arrayList.size(); i++)
            array[i] = arrayList.get(i);
        
        return array;
    }
    
    public int find(int target, int [] array2)
    {
        int found = -1;
        for( int i = 0; i < array2.length; i++)
        {
            if(array2[i]  == target)
                found = i;
        }
        return found;
    }
}
