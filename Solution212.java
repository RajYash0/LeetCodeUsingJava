class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) insert(root, word);

        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);
        board[i][j] = ch;
    }
}
