class Solution {
    int n;
    List<List<String>> out;
    List<String> curr;    
    int[] cols, dia1, dia2;
    String dots;

    void init(int n) {
        this.n = n;
        out = new ArrayList<>();
        curr = new ArrayList<>();
        cols = new int[n]; // x, col -> |
        dia1 = new int[n*2-1]; // x+y, dia -> /
        dia2 = new int[n*2-1]; // n-1+x-y, dia -> \
        dots = ".".repeat(n);
    }

    public List<List<String>> solveNQueens(int n) {
        init(n);
        solve(0);
        return out;
    }

    void solve(int y) {
        if (y==n) {
            out.add(new ArrayList<>(curr));
            return;
        }
        StringBuilder row = new StringBuilder(dots);

        for (int x=0; x<n; x++) {   
            if (
                cols[x] == 1 || 
                dia1[x+y] == 1 ||
                dia2[n-1+x-y] == 1
            ) continue;

            cols[x] = 1; 
            dia1[x+y] = 1;
            dia2[n-1+x-y] = 1;

            row.setCharAt(x, 'Q');
            curr.add(row.toString());

            solve(y+1);

            cols[x] = 0;
            dia1[x+y] = 0;
            dia2[n-1+x-y] = 0;

            row.setCharAt(x, '.');
            curr.remove(curr.size() - 1);
        }
    }
}
