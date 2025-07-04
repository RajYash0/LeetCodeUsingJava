public class Solution172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution172 sol = new Solution172();
        int n = 100;
        System.out.println("Trailing zeroes in " + n + "! = " + sol.trailingZeroes(n));
    }
}
