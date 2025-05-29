import java.util.*;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, "", 0, res);
        return res;
    }

    private void backtrack(String s, int index, String path, int segment, List<String> res) {
        if (segment == 4 && index == s.length()) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }
        if (segment >= 4 || index >= s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) continue;
            backtrack(s, index + len, path + part + ".", segment + 1, res);
        }
    }

    public static void main(String[] args) {
        Solution93 sol = new Solution93();
        String s = "25525511135";
        List<String> result = sol.restoreIpAddresses(s);
        for (String ip : result) {
            System.out.println(ip);
        }
    }
}
