class Solution {
    int dist(int[] pt)
    {
        return pt[0]*pt[0] + pt[1]*pt[1];
    }
    public int[][] kClosest(int[][] points, int k)
    {
        // max priority queue for points
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (p1, p2) -> dist(p2) - dist(p1) // descending comparator for distance
        );

        for (int pt[] : points)
        {
            if (pq.size() < k || dist(pt) < dist(pq.peek()))
            {
                pq.add(pt);
                if (pq.size() > k) pq.poll();
            }
        }

        int[][] out = new int[k][2];
        for (int i=0; i<k; i++)
        out[i] = pq.poll();

        return out;
    }
}
