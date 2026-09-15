class TrieNode {
    TrieNode[] children;
    TrieNode() { children = new TrieNode[26]; }
}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        int m = board.length, n = board[0].length;
        int maxDepth = 0;
        for (String word: words) maxDepth = Math.max(maxDepth, word.length());

        for (int i=0; i<m*n; i++) {
            Set<Integer> visited = new HashSet<Integer>();
            dfs(board, i, root, visited, maxDepth);
        }

        List<String> out = new ArrayList<String>();
        for (String word: words)
            if (search(root, word)) out.add(word);
        return out;
    }

    void dfs(char[][] board, int i, TrieNode ptr, Set<Integer> visited, int maxDepth) {
        int m = board.length, n = board[0].length;
        int y = i/n, x = i%n;

        int ci = board[y][x] - 'a';
        TrieNode np = ptr.children[ci];
        if (np == null) {
            np = ptr.children[ci] = new TrieNode();
        }

        if (maxDepth == 1) return;

        visited.add(i);

        if (x+1<n && !visited.contains(i+1)) {
            dfs(board, i+1, np, visited, maxDepth-1);
        }
        if (y+1<m && !visited.contains(i+n)) {
            dfs(board, i+n, np, visited, maxDepth-1);
        }
        if (x>0 && !visited.contains(i-1)) {
            dfs(board, i-1, np, visited, maxDepth-1);
        }
        if (y>0 && !visited.contains(i-n)) {
            dfs(board, i-n, np, visited, maxDepth-1);
        }

        visited.remove(i);
    }

    boolean search(TrieNode root, String word) {
        TrieNode ptr = root;

        for (int i=0; i<word.length(); i++) 
        {
            int ci = word.charAt(i)-'a';
            ptr = ptr.children[ci];
            if (ptr == null) return false;
        }

        return true;
    }
}
