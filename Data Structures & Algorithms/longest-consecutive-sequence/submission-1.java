class Solution {
    class Chain {int start; int end;}

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashMap<Integer, Chain> map = new HashMap<>();
        int longest = 1;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            final boolean hasPrev = map.containsKey(num-1);
            final boolean hasNext = map.containsKey(num+1);
            if (hasPrev && hasNext) {
                Chain cp = map.get(num-1);
                Chain cn = map.get(num+1);
                cp.end = cn.end;
                map.put(num, cp);
                for (int i=cn.start; i<=cn.end; i++) map.put(i, cp);
                longest = Math.max(longest, cp.end-cp.start+1);
            }
            else if (hasPrev) {
                Chain c = map.get(num-1);
                c.end = num;
                map.put(num, c);
                longest = Math.max(longest, c.end-c.start+1);
            }
            else if (hasNext) {
                Chain c = map.get(num+1);
                c.start = num;
                map.put(num, c);
                longest = Math.max(longest, c.end-c.start+1);
            }
            else {
                Chain c = new Chain();
                c.start = c.end = num;
                map.put(num, c);
            }
        }
        return longest;
    }
}
