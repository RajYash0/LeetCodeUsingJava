class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] stack = new int[parts.length + 1];
        int maxLen = 0;
        for (String part : parts) {
            int level = part.lastIndexOf("\t") + 1;
            int len = stack[level] + part.length() - level + 1;
            stack[level + 1] = len;
            if (part.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}
