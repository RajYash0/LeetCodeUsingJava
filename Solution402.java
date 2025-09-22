class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (sb.length() > 0 || c != '0') sb.append(c);
        }
        while (sb.length() > 0 && k-- > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
