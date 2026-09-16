class Solution {
    char[][] board;
    int m, n;
    String word;
    boolean found;
    public boolean exist(char[][] board, String word)
    {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        found = false;

        for (int y=0; y<m; y++)
        for (int x=0; x<n; x++)
        dfs(x,y,0);

        return found;
    }

    void dfs(int x, int y, int i)
    {
        if (found || board[y][x] != word.charAt(i)) return;

        if (i+1 == word.length())
        {
            found = true;
            return;
        }

        char t = board[y][x];
        board[y][x] = '#';

        if (x+1 < n && board[y  ][x+1] != '#') dfs(x+1, y  , i+1);
        if (x   > 0 && board[y  ][x-1] != '#') dfs(x-1, y  , i+1);
        if (y+1 < m && board[y+1][x  ] != '#') dfs(x  , y+1, i+1);
        if (y   > 0 && board[y-1][x  ] != '#') dfs(x  , y-1, i+1);

        board[y][x] = t;
    } 
}
