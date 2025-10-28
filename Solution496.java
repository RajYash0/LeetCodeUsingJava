import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> next = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        for (int num : nums2) {
            while (!st.isEmpty() && st.peekLast() < num) next.put(st.pollLast(), num);
            st.addLast(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) ans[i] = next.getOrDefault(nums1[i], -1);
        return ans;
    }
}