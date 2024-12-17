class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycleLen) {
                result.append(s.charAt(j));

                int diagonalIdx = j + cycleLen - 2 * row;
                if (row != 0 && row != numRows - 1 && diagonalIdx < s.length()) {
                    result.append(s.charAt(diagonalIdx));
                }
            }
        }

        return result.toString();
    }
}
