class Solution {
    List<Integer>[] graph;
    int[] state;

    public boolean canFinish(int nc, int[][] pre) {
        graph = new List[nc];
        state = new int[nc];

        for (int[] preq : pre)
        {
            List<Integer> edges = graph[preq[1]];
            if (edges == null)
            {
                edges = graph[preq[1]] = new ArrayList();
            }
            edges.add(preq[0]);
        }

        for (int i=0; i<nc; i++)
        {
            if (state[i] == 2) continue;
            boolean hasCycle = visit(i);

            if (hasCycle) return false;
        }

        return true;
    }

    // return TRUE if cycle detected
    boolean visit(int v) {
        if (state[v] == 1) return true;
        if (state[v] == 2) return false;
        
        state[v] = 1;

        if (graph[v] != null) {
            for (int childV : graph[v]) 
            {
                boolean hasCycle = visit(childV); 
                if (hasCycle) return true;
            }
        }

        state[v] = 2;
        return false;
    }
}
