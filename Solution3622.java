class Solution {
    public boolean checkDivisibility(int n) {
        int sum = sumOfDigits(n);
        int product = productOfDigits(n);
        int divisor = sum + product;
        if(n % divisor == 0) return true;
        return false;
    }
    
    public static int sumOfDigits(int n){
        if(n < 10) return n;
        int sum = 0;
        while(n > 0){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int productOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        
        int product = 1;
        
        while (n > 0) {
            int digit = n % 10;
            
            if (digit == 0) {
                return 0;
            }
            
            product *= digit;
            n /= 10;
        }
        
        return product;
    }
}
