import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            if (i < s.length() - 1 && current < romanMap.get(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();
        System.out.println(converter.romanToInt("III"));
        System.out.println(converter.romanToInt("LVIII"));
        System.out.println(converter.romanToInt("MCMXCIV"));
    }
}
