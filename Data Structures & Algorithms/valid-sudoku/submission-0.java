class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Integer>[] rows = new Set[n];
        Set<Integer>[] cols = new Set[n];
        Set<Integer>[] secs = new Set[n];

        for (int i=0; i<n; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            secs[i] = new HashSet();
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) { 
                char c = board[i][j];
                if (c == '.') continue;
                int k = c - '0';
                int gi = (i/3)*3 + (j/3);
                if (rows[i].contains(k) || 
                    cols[j].contains(k) ||
                    secs[gi].contains(k)) return false;
                rows[i].add(k);
                cols[j].add(k);
                secs[gi].add(k);
            }
        }

        return true;
    }
}
