class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        for (int x : stones)
        {
            maxPQ.add(x);
            // if (maxPQ.size() < 2) continue;
            // int st = Math.abs(maxPQ.poll() - maxPQ.poll());
            // if (st!=0) maxPQ.add(st);
        }

        while (maxPQ.size() > 1)
        {
            int st = Math.abs(maxPQ.poll() - maxPQ.poll());
            if (st!=0) maxPQ.add(st);
        }

        return maxPQ.size()==0 ? 0 : maxPQ.peek();
    }
}