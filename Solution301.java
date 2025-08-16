class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String t = queue.poll();
            if (isValid(t)) {
                res.add(t);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')') continue;
                String nxt = t.substring(0, i) + t.substring(i + 1);
                if (!visited.contains(nxt)) {
                    visited.add(nxt);
                    queue.add(nxt);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else if (c == ')') {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
}
