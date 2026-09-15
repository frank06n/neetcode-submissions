class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word: words) insert(root, word);

        int m = board.length, n = board[0].length;
        List<String> out = new ArrayList<String>();

        for (int i=0; i<m*n; i++) {
            Set<Integer> visited = new HashSet<Integer>();
            dfs(board, i, root, visited, out);
        }

        return out;
    }

    void dfs(char[][] board, int i, TrieNode ptr, Set<Integer> visited, List<String> out) {
        int m = board.length, n = board[0].length;
        int y = i/n, x = i%n;

        int ci = board[y][x] - 'a';
        TrieNode np = ptr.children[ci];
        if (np == null) return;
        if (np.word != null) {
            out.add(np.word);
            np.word = null;
        }

        visited.add(i);

        if (x+1<n && !visited.contains(i+1)) {
            dfs(board, i+1, np, visited, out);
        }
        if (y+1<m && !visited.contains(i+n)) {
            dfs(board, i+n, np, visited, out);
        }
        if (x>0 && !visited.contains(i-1)) {
            dfs(board, i-1, np, visited, out);
        }
        if (y>0 && !visited.contains(i-n)) {
            dfs(board, i-n, np, visited, out);
        }

        visited.remove(i);
    }

    void insert(TrieNode root, String word) {
        TrieNode ptr = root;

        for (int i=0; i < word.length(); i++)
        {
            int ci = word.charAt(i)-'a';
            
            if (ptr.children[ci] == null)
                ptr.children[ci] = new TrieNode();
            
            ptr = ptr.children[ci];
        }

        ptr.word = word;
    }
}
