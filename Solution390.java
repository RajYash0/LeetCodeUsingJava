class Solution {
    public int lastRemaining(int n) {
        int head = 1, step = 1;
        boolean left = true;
        while (n > 1) {
            if (left || n % 2 == 1) head += step;
            n /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
