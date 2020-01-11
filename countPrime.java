/*Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/


class countPrime {
    public int countPrimes(int n) {
        
        if(n <= 1)
            return 0;
        
        int sum = 0;
        
        for( int i = n-1; i > 1 ; i--)
        {
            if(isPrime(i))
                sum++;
        }
        
        return sum;
        
    }

    
    public boolean isPrime(int number) {
        
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

}
