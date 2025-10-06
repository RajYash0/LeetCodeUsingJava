class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) cnt[c - 'a']++;
        int left = 0, right = 0, need = p.length();
        while (right < s.length()) {
            if (cnt[s.charAt(right++) - 'a']-- > 0) need--;
            if (need == 0) res.add(left);
            if (right - left == p.length() && cnt[s.charAt(left++) - 'a']++ >= 0) need++;
        }
        return res;
    }
}