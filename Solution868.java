class Solution {
    public int binaryGap(int n) {
        int prev = -1, distance = 0, position = 0;
        while(n>0){
            if((n&1) == 1){
                if(prev != -1){
                    distance = Math.max(distance, position - prev);
                }
                prev = position;
            }
            n >>= 1;
            position++;
        }
        return distance;
    }
}
