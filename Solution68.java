import java.util.*;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i + 1, len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            int spaceSlots = j - i - 1;
            if (j == words.length || spaceSlots == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                int totalSpaces = maxWidth - (len - spaceSlots);
                int space = totalSpaces / spaceSlots;
                int extra = totalSpaces % spaceSlots;
                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    sb.append(" ".repeat(space + (k - i < extra ? 1 : 0)));
                }
                sb.append(words[j - 1]);
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution68 sol = new Solution68();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> output = sol.fullJustify(words, maxWidth);
        for (String line : output) {
            System.out.println('"' + line + '"');
        }
    }
}
