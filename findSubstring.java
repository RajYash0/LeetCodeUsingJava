import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            Map<String, Integer> windowCount = new HashMap<>();

            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    windowCount.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> indices = solution.findSubstring(s, words);
        System.out.println(indices);
    }
}
