class TrieNode {
    TrieNode[] children;
    boolean ends;
    TrieNode() {
        children = new TrieNode[26];
        ends = false;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word: words) insert(root, word);

        int m = board.length, n = board[0].length;
        Set<String> out = new HashSet<String>();

        for (int i=0; i<m*n; i++) {
            Set<Integer> visited = new HashSet<Integer>();
            dfs(board, i, "", root, visited, out);
        }

        return new ArrayList<>(out);
    }

    void dfs(char[][] board, int i, String prefix, TrieNode ptr, Set<Integer> visited, Set<String> out) {
        int m = board.length, n = board[0].length;
        int y = i/n, x = i%n;

        prefix += board[y][x];
        int ci = board[y][x] - 'a';
        TrieNode np = ptr.children[ci];
        if (np == null) return;
        if (np.ends) out.add(prefix);

        visited.add(i);

        if (x+1<n && !visited.contains(i+1)) {
            dfs(board, i+1, prefix, np, visited, out);
        }
        if (y+1<m && !visited.contains(i+n)) {
            dfs(board, i+n, prefix, np, visited, out);
        }
        if (x>0 && !visited.contains(i-1)) {
            dfs(board, i-1, prefix, np, visited, out);
        }
        if (y>0 && !visited.contains(i-n)) {
            dfs(board, i-n, prefix, np, visited, out);
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

        ptr.ends = true;
    }
}
