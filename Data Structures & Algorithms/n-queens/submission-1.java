class Solution {
    List<List<String>> out;
    List<String> curr;    
    int n;
    int[] rows, cols, dia1, dia2;
    String dots;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        out = new ArrayList<>();
        curr = new ArrayList<>();
        dots = "";
        for (int i=0; i<n; i++) dots += ".";

        rows = new int[n]; // y, row -> -
        cols = new int[n]; // x, col -> |
        dia1 = new int[n*2-1]; // x+y, dia -> /
        dia2 = new int[n*2-1]; // n-1+x-y, dia -> \

        for (int x=0; x<n; x++) execute(0, x);

        return out;
    }

    void execute(int y, int x)
    {
        // System.out.printf("y:%d x:%d d1:%d d2:%d\n", y,x,x+y,n-1+x-y);
        if (
            rows[y] == 1 ||
            cols[x] == 1 || 
            dia1[x+y] == 1 ||
            dia2[n-1+x-y] == 1
        ) return;

        System.out.println("V");

        rows[y] = 1;
        cols[x] = 1; 
        dia1[x+y] = 1;
        dia2[n-1+x-y] = 1;

        StringBuilder row = new StringBuilder(dots);
        row.setCharAt(x, 'Q');
        curr.add(row.toString());

        if (y+1==n) {
            out.add(new ArrayList<>(curr));
        }
        else {
            for (int x2=0; x2<n; x2++)
            {
                if (x2==x) continue;
                execute(y+1, x2);
            }
        }

        rows[y] = 0;
        cols[x] = 0;
        dia1[x+y] = 0;
        dia2[n-1+x-y] = 0;

        curr.remove(curr.size() - 1);
    }
}
