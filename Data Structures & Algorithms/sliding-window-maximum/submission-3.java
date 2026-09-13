class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int z = k-1;
        int out[] = new int[nums.length-z];
        Deque<Integer> deq = new ArrayDeque<Integer>();
        for (int i=0; i<nums.length; i++)
        {
            if (deq.isEmpty() || nums[i] >= nums[deq.peekFirst()]) 
            {
                deq.offerFirst(i);
            }
            else {
                while (nums[i] >= nums[deq.peekLast()])
                    deq.pollLast();
                deq.offerLast(i);
            }

            while (deq.peekFirst() < i-z) deq.pollFirst();

            if (i>=z) {
                out[i-z] = nums[deq.peekFirst()];
            }
        }
        return out;
    }
}
