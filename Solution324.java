import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] a = nums.clone();
        Arrays.sort(a);
        int j = (n + 1) / 2 - 1, k = n - 1;
        for (int i = 0; i < n; i += 2) nums[i] = a[j--];
        for (int i = 1; i < n; i += 2) nums[i] = a[k--];
    }
}
