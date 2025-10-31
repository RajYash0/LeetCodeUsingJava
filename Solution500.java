class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String w = word.toLowerCase();
            String row = row1.contains(w.charAt(0) + "") ? row1 : row2.contains(w.charAt(0) + "") ? row2 : row3;
            boolean ok = true;
            for (char c : w.toCharArray())
                if (!row.contains(c + "")) {
                    ok = false;
                    break;
                }
            if (ok) res.add(word);
        }
        return res.toArray(new String[0]);
    }
}