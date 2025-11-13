class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            if (k == 0) {
                if (e.getValue() > 1) count++;
            } else {
                if (map.containsKey(num + k)) count++;
            }
        }
        return count;
    }
}