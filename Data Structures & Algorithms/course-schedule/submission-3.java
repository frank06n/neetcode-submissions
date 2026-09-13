class Solution {
    Map<Integer, List<Integer>> graph;
    Set<Integer> verts, traversed, visited;

    public boolean canFinish(int nc, int[][] pre) {
        graph = new HashMap<>();
        verts = new HashSet<>();
        visited = new HashSet<>();

        for (int[] preq : pre)
        {
            verts.add(preq[0]);
            verts.add(preq[1]);
            List<Integer> edges = graph.computeIfAbsent(
                preq[1], k -> new ArrayList<>()
            );
            edges.add(preq[0]);
        }

        for (Integer v : verts)
        {
            if (visited.contains(v)) continue;

            traversed = new HashSet<>();
            boolean prevtraversed = visit(v);

            // contains cycle, cannot complete
            if (prevtraversed) return false;
        }

        return true;
    }

    // return TRUE if some node is already traversed
    boolean visit(int v) {
        if (traversed.contains(v)) return true;
        if (visited.contains(v)) return false;
        
        traversed.add(v);
        visited.add(v);

        if (graph.containsKey(v)) {
            for (int childV : graph.get(v)) 
            {
                boolean prevtraversed = visit(childV); 
                if (prevtraversed) return true;
            }
        }

        traversed.remove(v);
        return false;
    }
}
