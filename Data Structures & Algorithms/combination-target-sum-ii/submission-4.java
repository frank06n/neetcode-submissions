class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int remaining;
    int[] nums;
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        out = new ArrayList<>();
        curr = new ArrayList<>();
        remaining = target;

        dfs(0);

        return out;
    }

    void dfs(int i) {
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
            remaining -= nums[j];
            
            dfs(j+1);

            curr.remove(curr.size()-1);
            remaining += nums[j];
        }
    }
}
