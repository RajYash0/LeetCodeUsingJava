class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while(n > 0){
            int digit = n % 10;
            if(max1<digit){
                max2 = max1;
                max1 = digit;
            }else if(max2<digit){
                max2 = digit;
            }
            n /= 10;
        }
        return max1 * max2;
    }
}
