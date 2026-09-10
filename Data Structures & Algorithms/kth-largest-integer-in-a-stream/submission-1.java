class KthLargest {
    int k, nums[];
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<Integer>();
        for (int x : nums)
        {
            if (pq.size() < k) pq.add(x);
            else if (x > pq.peek())
            {
                pq.poll();
                pq.add(x);
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) pq.add(val);
        else if (val > pq.peek())
        {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
