class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        } else return "Neither";
    }

    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String s : parts) {
            if (s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0')) return false;
            if (s.length() > 3) return false;
            for (char c : s.toCharArray()) if (!Character.isDigit(c)) return false;
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;
        String hexDigits = "0123456789abcdefABCDEF";
        for (String s : parts) {
            if (s.length() == 0 || s.length() > 4) return false;
            for (char c : s.toCharArray()) if (hexDigits.indexOf(c) == -1) return false;
        }
        return true;
    }
}