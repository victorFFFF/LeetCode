/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3 */

class romanInteger {
   public int romanToInt(String s) {
     
        int sum = 0;
        int length = s.length();
        char[] array = new char[length];
        
        for(int i =0; i < length ; i++)
        {
            array[i] = s.charAt(i);
        }        
    
        for( int i = 0; i < length-1 ; i++)
         {
                    switch( array[i] )
                    {
                        case 'I':if(length == 1) 
                                    sum += 1;
                                  else
                                      if(array[i+1] == 'V' || array[i+1] == 'X')
                                        sum -= 1;
                                  else
                                      sum += 1;
                                  break;
                        case 'V': sum += 5;
                                  break;
                        case 'X': if(length == 1) 
                                    sum += 10;
                                  else
                                      if(array[i+1] == 'L' || array[i+1] == 'C')
                                        sum -= 10;
                                  else
                                      sum += 10;
                                  break;    
                        case 'L': sum += 50;
                                  break;
                        case 'C': if(length == 1) 
                                    sum += 100;
                                  else
                                      if(array[i+1] == 'D' || array[i+1] == 'M')
                                        sum -= 100;
                                  else
                                        sum += 100;
                                  break;
                        case 'D': sum += 500;
                                  break;
                        case 'M': sum += 1000;
                                  break;      
                        }
            }
        
               if( length >= 1)
                    {
                              switch( array[length-1] )
                                {
                                    case 'I': sum += 1;
                                              break;
                                    case 'V': sum += 5;
                                              break;
                                    case 'X': sum += 10;
                                              break;    
                                    case 'L': sum += 50;
                                              break;
                                    case 'C': sum += 100;
                                              break;
                                    case 'D': sum += 500;
                                              break;
                                    case 'M': sum += 1000;
                                              break;      
                                    }
                    }
          return sum;
  }
}
