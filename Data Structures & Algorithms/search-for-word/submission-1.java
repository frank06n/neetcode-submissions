class Solution {
    char[][] board;
    int m, n;
    String word;
    
    public boolean exist(char[][] board, String word)
    {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;

        for (int y=0; y<m; y++)
        for (int x=0; x<n; x++)
        if (dfs(x,y,0))
        return true;

        return false;
    }

    // return true if found
    boolean dfs(int x, int y, int i)
    {
        if (board[y][x] != word.charAt(i)) return false;

        if (i+1 == word.length()) return true;

        char t = board[y][x];
        board[y][x] = '#';

        if (x+1 < n && board[y  ][x+1] != '#') if (dfs(x+1, y  , i+1)) return true;
        if (x   > 0 && board[y  ][x-1] != '#') if (dfs(x-1, y  , i+1)) return true;
        if (y+1 < m && board[y+1][x  ] != '#') if (dfs(x  , y+1, i+1)) return true;
        if (y   > 0 && board[y-1][x  ] != '#') if (dfs(x  , y-1, i+1)) return true;

        board[y][x] = t;
        return false;
    } 
}
