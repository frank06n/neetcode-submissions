class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int x : nums)
        {
            if (pq.size() < k || x > pq.peek()) pq.add(x);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
