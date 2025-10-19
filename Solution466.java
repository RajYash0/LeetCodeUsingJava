class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        int s1Count = 0, s2Count = 0, index = 0;
        Map<Integer, int[]> recall = new HashMap<>();
        while (true) {
            s1Count++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        s2Count++;
                        index = 0;
                    }
                }
            }
            if (s1Count == n1) return s2Count / n2;
            if (recall.containsKey(index)) {
                int[] last = recall.get(index);
                int preLoopS1 = last[0], preLoopS2 = last[1];
                int inLoopS1 = s1Count - preLoopS1, inLoopS2 = s2Count - preLoopS2;
                int ans = preLoopS2 + (n1 - preLoopS1) / inLoopS1 * inLoopS2;
                int rest = (n1 - preLoopS1) % inLoopS1;
                for (int i = 0; i < rest; i++) {
                    for (int j = 0; j < s1.length(); j++) {
                        if (s1.charAt(j) == s2.charAt(index)) {
                            index++;
                            if (index == s2.length()) {
                                ans++;
                                index = 0;
                            }
                        }
                    }
                }
                return ans / n2;
            } else {
                recall.put(index, new int[]{s1Count, s2Count});
            }
        }
    }
}