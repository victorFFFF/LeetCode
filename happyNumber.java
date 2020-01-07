
/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/



class Solution {
    public boolean isHappy(int n) {
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> record = new ArrayList<>();
        int sum = 0;
        
        if( n > 0)
        {
            while(!record.contains(n))
            {
                record.add(sum);
                sum = 0;
                stack = extractDigit( n , stack);
                
                while( !stack.isEmpty() )
                    sum += square(stack.pop());
                
                if(sum == 1)
                    return true;
                
                n = sum;
            }
            return false;
        }
            return false;
    }
    
    public int square(int x)
    {
        return x*x;
    }
    
    public Stack<Integer> extractDigit(int num, Stack<Integer> theStack)
    {
        while( num > 0 )
        {
            theStack.push( num % 10);
            num /= 10;
        }
        return theStack;
    }
}
