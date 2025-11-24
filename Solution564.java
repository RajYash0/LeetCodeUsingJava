class Solution {
    public String nearestPalindromic(String n) {
        long self = Long.parseLong(n);
        int len = n.length();
        java.util.Set<Long> set = new java.util.HashSet<>();

        set.add((long)Math.pow(10, len) + 1);
        set.add((long)Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = prefix - 1; i <= prefix + 1; i++) {
            if (i < 0) continue;
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);

            int cut = Math.min(s.length(), len - s.length());
            if (cut < 0) cut = 0;
            if (cut > s.length()) cut = s.length();

            StringBuilder rev = new StringBuilder(s.substring(0, cut)).reverse();
            sb.append(rev);

            try {
                set.add(Long.parseLong(sb.toString()));
            } catch (Exception e) {}
        }

        set.remove(self);

        long ans = -1;
        for (long x : set) {
            long diff = Math.abs(x - self);
            if (ans == -1 || diff < Math.abs(ans - self) ||
               (diff == Math.abs(ans - self) && x < ans)) {
                ans = x;
            }
        }
        return String.valueOf(ans);
    }
}