class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder temp = curr;
                curr = strStack.pop();
                int count = countStack.pop();
                while (count-- > 0) curr.append(temp);
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
