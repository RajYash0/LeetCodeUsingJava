public class Solution65 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean num = false, dot = false, exp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !num) return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution65 sol = new Solution65();
        System.out.println(sol.isNumber("0"));          // true
        System.out.println(sol.isNumber("e"));          // false
        System.out.println(sol.isNumber("2e10"));       // true
        System.out.println(sol.isNumber(" -90e3   "));  // true
        System.out.println(sol.isNumber("1a"));         // false
    }
}
