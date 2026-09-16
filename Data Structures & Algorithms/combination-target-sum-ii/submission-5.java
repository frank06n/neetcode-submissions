class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int[] nums;
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        out = new ArrayList<>();
        curr = new ArrayList<>();

        dfs(0, target);

        return out;
    }

    void dfs(int i, int remaining) {
        if (remaining == 0) {
            out.add(new ArrayList<>(curr));
            return;
        }

        int j;
        for (j=i; j<nums.length; j++)
        {
            if (j > i && nums[j] == nums[j - 1]) continue;
            if (nums[j] > remaining) break;

            curr.add(nums[j]);
            dfs(j+1, remaining - nums[j]);
            curr.remove(curr.size()-1);
        }
    }
}
