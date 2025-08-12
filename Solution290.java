class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> c2w = new HashMap<>();
        Map<String, Character> w2c = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (c2w.containsKey(c) && !c2w.get(c).equals(w))
                return false;
            if (w2c.containsKey(w) && w2c.get(w) != c)
                return false;
            c2w.put(c, w);
            w2c.put(w, c);
        }
        return true;
    }
}
