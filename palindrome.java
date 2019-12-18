/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true*/

class palindrome {
    public boolean isPalindrome(int x) {
        
        int length = Integer.toString(x).length();
        int count = 0;
        
        String xString = Integer.toString(x);
        
        
        
        for(int i = 0; i < length/2 ; i++)
        {
            if( xString.charAt(length-1-i)  == xString.charAt(i))
                count++;
        }
        
        if(count == length/2)
            return true;
        else
            return false;
        
    }
}
