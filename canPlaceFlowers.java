/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False*/


// My approach is to see if a flower is plantable at a each array position by checking its right and left adjacents.  
// A flower is only plantable if it is equal to 0 and its left and right is also equal to 0 or out of bound index.
// Once we found a flower to be plantable, we can add 1 to the current array position to represent a flower is planted there.
// At the end we can compare "sum" to "n". If sum >=n then we know it is true. Otherwise, it is false.

class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
         int sum = 0;  //Represents the maximum number of flowers that can be planted.
    
        if(flowerbed == null || flowerbed.length == 0)
            return sum == n;
        if(flowerbed.length == 1)
        {
            if(flowerbed[0] == 0)
            {
                sum++;
                return sum >= n;       //we use >= because n can be less than the max number of plants and 
            }                          //still is valid (plantable on the flowerbed)
            else
                return sum >= n;
        }
        //Calcualte the maximum number of flowers we can plant
        for(int i =0; i < flowerbed.length; i++)
        {
            if( flowerbed[i] == 0)
            {
                if(i == 0) //checks if first element
                {
                    if(flowerbed[i+1] == 0)    
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
                else if( i == flowerbed.length-1)   //checks if last element
                {
                    if(flowerbed[i-1] == 0)
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
                else
                {
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0)  //middle element checks adjacent side left and right of it.
                    {
                        sum++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return sum>=n;
    }
}
