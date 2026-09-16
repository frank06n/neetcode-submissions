class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {
    char[][] board;
    int m, n;
    List<String> out;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word: words) insert(root, word);

        this.board = board;
        m = board.length;
        n = board[0].length;
        out = new ArrayList<String>();

        for (int y=0; y<m; y++)
        for (int x=0; x<n; x++)
        dfs(y, x, root);

        return out;
    }

    void dfs(int y, int x, TrieNode ptr) {
        int ci = board[y][x] - 'a';
        TrieNode np = ptr.children[ci];
        if (np == null) return;
        if (np.word != null) {
            out.add(np.word);
            np.word = null;
        }

        char temp = board[y][x];
        board[y][x] = '#';

        if (x+1<n && board[y][x+1] != '#') dfs(y, x+1, np);
        if (y+1<m && board[y+1][x] != '#') dfs(y+1, x, np);
        if (x>0 && board[y][x-1] != '#') dfs(y, x-1, np);
        if (y>0 && board[y-1][x] != '#') dfs(y-1, x, np);

        board[y][x] = temp;
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
