class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;
        while (i < n) {
            char c = chars[i];
            int j = i;
            while (j < n && chars[j] == c) j++;
            int count = j - i;
            chars[write++] = c;
            if (count > 1) {
                String s = Integer.toString(count);
                for (int k = 0; k < s.length(); k++) chars[write++] = s.charAt(k);
            }
            i = j;
        }
        return write;
    }
}
