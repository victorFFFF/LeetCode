/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/



class mergeIntervals {
 public int[][] merge(int[][] intervals) {
     
        if(intervals == null || intervals.length == 0)
            return new int[0][];
            
        int [] start = new int[ intervals.length];
        int [] end = new int[intervals.length];        
        
        for(int i = 0; i < intervals.length; i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
     
        Stack< int[][] > stack = new Stack <>();
        
        for(int i =0; i < start.length; i++)
        {
            if( i == 0)
                stack.push(new int[][]{ {start[i],end[i]} });
            else
            {
                int[][] temp = stack.pop();
                
                //Test for overlap
                if( start[i] <= temp[0][1])
                    stack.push( new int[][]{ {temp[0][0], end[i]} });
                else{
                    stack.push(temp);
                    stack.push(new int[][] { {start[i], end[i]} });
                }                
                        
                }
        }
     
     //Get the updated merge
     int i = stack.size()-1;
     intervals = new int[stack.size()][2];
   
     while( !stack.isEmpty() )
     {
         int [][] temp = new int [1][2];
         temp = stack.pop();
         
         intervals[i][0] = temp[0][0]; //Start
         intervals[i][1] = temp[0][1];  //End
         i--;
        }  
     return intervals;     
    }
}
