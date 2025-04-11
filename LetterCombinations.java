import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, digits, new StringBuilder(), 0, mapping);
        return result;
    }

    private static void backtrack(List<String> result, String digits, StringBuilder current, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, current, index + 1, mapping);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(""));   // []
        System.out.println(letterCombinations("2"));  // ["a","b","c"]
    }
}
