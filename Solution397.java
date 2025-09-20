class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                if (num == 3 || ((num & 2) == 0)) num--;
                else num++;
            }
            count++;
        }
        return count;
    }
}
