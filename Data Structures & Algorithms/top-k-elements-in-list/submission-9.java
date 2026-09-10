class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int n : nums) 
        freq.put(n, freq.getOrDefault(n, 0) + 1);

        ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];

        for (int n : freq.keySet()) {
            int count = freq.get(n);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList();
            }
            buckets[count].add(n);
        }

        int out[] = new int[k];
        int ix=nums.length;
        while (k>0) {
            if (buckets[ix] == null) {
                ix--;
                continue;
            }
            for (int n : buckets[ix]) {
                out[--k] = n;
                if (k==0) break; // if unique solution exists, this condition will never occur
            }
            ix--;
        }
        return out;
    }
}