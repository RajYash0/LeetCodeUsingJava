import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger curr = null;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r).trim();
                if (!num.isEmpty()) curr.add(new NestedInteger(Integer.parseInt(num)));
                if (!stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }
                l = r + 1;
            } else if (ch == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r).trim();
                    if (!num.isEmpty()) curr.add(new NestedInteger(Integer.parseInt(num)));
                }
                l = r + 1;
            }
        }
        return curr;
    }
}
