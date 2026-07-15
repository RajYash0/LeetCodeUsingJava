class Solution {
    public int gcdOfOddEvenSums(int n) {
        int countOdd = 0;
        int countEven = 0;
        int sumOdd = 0;
        int sumEven = 0;
        for(int i = 1; countOdd < n && countEven < n; i++){
            if(i % 2 == 0){
                sumEven += i;
                countEven++;
            }else{
                sumOdd += i;
                countOdd++;
            }
        }
        return findGCD(sumOdd,sumEven);
    }
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
