/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]*/

class mergeSortedArray {
    public static void merge(int[] firstArray, int firstIndex, int[] secondArray, int secondIndex) {
        
        boolean firstEmpty = false;
        boolean secondEmpty = false;
        int[] thirdArray = new int[firstIndex+secondIndex];
        int numElement = secondIndex + firstIndex;
        
        if( firstIndex == 0)
            firstEmpty = true;
        if(secondIndex == 0)
            secondEmpty = true;
        
           while( firstEmpty != true && secondEmpty != true )
            {
                 if(secondArray[secondIndex-1] > firstArray[firstIndex-1]) 
                 {
                    thirdArray[firstIndex + secondIndex-1] = secondArray[secondIndex-1]; 
                     secondIndex--;
                 }
                else{
                    thirdArray[firstIndex + secondIndex-1] = firstArray[firstIndex-1];
                    firstIndex--;
                }
                if( firstIndex == 0)
                    firstEmpty = true;
                if( secondIndex == 0)
                    secondEmpty = true;
            }
        
        if(firstEmpty == true)
        {
            for(int i = secondIndex ; i > 0 ; i--)
            {
                thirdArray[firstIndex+secondIndex-1] = secondArray[secondIndex-1];
                secondIndex--;
            }
        }
        if(secondEmpty == true)
        {
            for(int i = firstIndex; i > 0 ; i--)
            {
                thirdArray[firstIndex+secondIndex-1] = firstArray[firstIndex-1];
                firstIndex--;
            }
        }

        for(int i = 0; i < numElement;i++)
        {
            firstArray[i] = thirdArray[i];
        }
            
    

    }
}
