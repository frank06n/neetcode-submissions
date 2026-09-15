class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();

        dfs(nums, out, 0, new ArrayList());
        return out;
    }
    void dfs(int[] nums, List<List<Integer>> out, int i, List<Integer> curr)
    {
        if (i+1 == nums.length)
        {
            curr.add(nums[i]);
            out.add(new ArrayList(curr));
            curr.remove((Integer)nums[i]);
            out.add(new ArrayList(curr));
        }
        else
        {
            curr.add(nums[i]);
            dfs(nums, out, i+1, curr);
            curr.remove((Integer)nums[i]);
            dfs(nums, out, i+1, curr);
        }
    }
}
