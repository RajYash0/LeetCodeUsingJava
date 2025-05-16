public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        System.out.println(sol.addBinary("11", "1"));       // Output: "100"
        System.out.println(sol.addBinary("1010", "1011"));  // Output: "10101"
    }
}
