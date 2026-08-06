class Solution {
    public int smallestNumber(int n, int t) {
        int product = getProduct(n);
        if(product % t == 0) return n;
        while(product % t != 0){
            n++;
            product = getProduct(n);
        }
        return n;
    }
    public static int getProduct(int n) {
 
        if (n == 0) return 0;
        
        int product = 1;
        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            n = n / 10;
        }
        
        return product;
    }
}
