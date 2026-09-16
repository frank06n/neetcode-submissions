class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    Set<Integer> used;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        out = new ArrayList<>();
        curr = new ArrayList<>();
        used = new HashSet<>();

        Arrays.sort(nums);
        this.nums = nums;

        dfs(0);
        return out;
    }
    void dfs(int i)
    {
        if (i == nums.length)
        {
            out.add(new ArrayList<>(curr));
            return;
        }

        if (used.contains(nums[i]))
        {
            // Include nums[i]
            curr.add(nums[i]);
            dfs(i+1);
            curr.remove(curr.size() - 1);
            return;
        }

        // Include nums[i]
        curr.add(nums[i]);
        used.add(nums[i]);
        dfs(i+1);
        curr.remove(curr.size() - 1);
        used.remove(nums[i]);

        // Exclude nums[i]
        dfs(i+1);
    }
}
