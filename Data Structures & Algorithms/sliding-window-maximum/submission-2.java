class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int ix;
        Pair(int val, int ix) {
            this.val = val;
            this.ix = ix;
        }

        @Override
        public int compareTo(Pair p) {
            if (p == null)
            throw new NullPointerException("Cannot compare with null");
            
            return Integer.compare(this.val, p.val);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int z = k-1;
        int[] out = new int[nums.length-z];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int i=0; i<nums.length; i++)
        {
            pq.offer(new Pair(nums[i], i));
            if (i >= z) {
                Pair mp = pq.peek();
                while (mp.ix < i-z) {
                    pq.poll();
                    mp = pq.peek();
                }
                out[i-z] = mp.val;
            }
        }

        return out;
    }
}
