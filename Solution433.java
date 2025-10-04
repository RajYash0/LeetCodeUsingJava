class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        char[] genes = {'A','C','G','T'};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(end)) return level;
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char g : genes) {
                        arr[j] = g;
                        String next = new String(arr);
                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return -1;
    }
}