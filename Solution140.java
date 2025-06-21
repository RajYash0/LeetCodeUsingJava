import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();
        if (wordDict.contains(s)) result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (!wordDict.contains(right)) continue;
            String left = s.substring(0, i);
            List<String> leftSentences = dfs(left, wordDict, memo);
            for (String sentence : leftSentences) {
                result.add(sentence + " " + right);
            }
        }
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        Solution140 solution = new Solution140();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        String s = "catsanddog";
        List<String> results = solution.wordBreak(s, wordDict);
        for (String str : results) {
            System.out.println(str);
        }
    }
}
