import java.util.*;

class Solution {
    private Random random = new Random();
    
    private int rand7() {
        return random.nextInt(7) + 1;
    }

    public int rand10() {
        int num = 40;
        while (num >= 40) {
            num = (rand7() - 1) * 7 + rand7() - 1;
        }
        return num % 10 + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] freq = new int[11];
        for (int i = 0; i < 100000; i++) {
            freq[s.rand10()]++;
        }
        System.out.println(Arrays.toString(freq));
    }
}