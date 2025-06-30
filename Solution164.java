import java.util.*;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) return 0;
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            int i = (num - min) / bucketSize;
            bucketMin[i] = Math.min(bucketMin[i], num);
            bucketMax[i] = Math.max(bucketMax[i], num);
            bucketUsed[i] = true;
        }
        int maxGap = 0, prevMax = min;
        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution164 sol = new Solution164();
        int[] nums = {3, 6, 9, 1};
        int result = sol.maximumGap(nums);
        System.out.println("Maximum Gap: " + result);
    }
}
