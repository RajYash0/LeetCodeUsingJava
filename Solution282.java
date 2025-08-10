import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String num, int target, int pos, long prev, long eval, StringBuilder sb, List<String> ans) {
        if (pos == num.length()) {
            if (eval == target) ans.add(sb.toString());
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') break;
            String s = num.substring(pos, i + 1);
            long curr = Long.parseLong(s);
            int len = sb.length();
            if (pos == 0) {
                dfs(num, target, i + 1, curr, curr, sb.append(s), ans);
                sb.setLength(len);
            } else {
                dfs(num, target, i + 1, curr, eval + curr, sb.append("+").append(s), ans);
                sb.setLength(len);
                dfs(num, target, i + 1, -curr, eval - curr, sb.append("-").append(s), ans);
                sb.setLength(len);
                dfs(num, target, i + 1, prev * curr, eval - prev + prev * curr, sb.append("*").append(s), ans);
                sb.setLength(len);
            }
        }
    }
}
