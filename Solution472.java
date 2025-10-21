class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> memo = new HashMap<>();
        for (String w : words) {
            if (isConcatenated(w, wordSet, memo)) {
                ans.add(w);
            }
        }
        return ans;
    }
    private boolean isConcatenated(String w, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(w)) return memo.get(w);
        for (int i = 1; i < w.length(); i++) {
            String prefix = w.substring(0, i);
            String suffix = w.substring(i);
            if (wordSet.contains(prefix) &&
                (wordSet.contains(suffix) || isConcatenated(suffix, wordSet, memo))) {
                memo.put(w, true);
                return true;
            }
        }
        memo.put(w, false);
        return false;
    }
}