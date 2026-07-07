class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) {
            return 0;
        }
        return removeZeroesMath(n);
    }

    public static long removeZeroesMath(int num) {
        int result = 0;
        int multiplier = 1;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10; 
            
            if (digit != 0) {
                result += digit * multiplier;
                multiplier *= 10;
                sum += digit;
            }
            
            num /= 10; 
        }
        
        return (long)result*sum;
    }
}
