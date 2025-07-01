import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        long rem = num % den;
        if (rem == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));    // Output: "0.5"
        System.out.println(fractionToDecimal(2, 1));    // Output: "2"
        System.out.println(fractionToDecimal(2, 3));    // Output: "0.(6)"
        System.out.println(fractionToDecimal(4, 333));  // Output: "0.(012)"
        System.out.println(fractionToDecimal(1, 5));    // Output: "0.2"
        System.out.println(fractionToDecimal(-50, 8));  // Output: "-6.25"
    }
}
