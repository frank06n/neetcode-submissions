class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();

        dfs(nums, out, 0, new ArrayList<>());
        return out;
    }
    void dfs(int[] nums, List<List<Integer>> out, int i, List<Integer> curr)
    {
        if (i == nums.length)
        {
            out.add(new ArrayList<>(curr));
            return;
        }
        // Include nums[i]
        curr.add(nums[i]);
        dfs(nums, out, i+1, curr);
        curr.remove(curr.size() - 1);

        // Exclude nums[i]
        dfs(nums, out, i+1, curr);
    }
}
