class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int currSum;
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        this.target = target;
        out = new ArrayList<>();
        curr = new ArrayList<>();
        currSum = 0;

        dfs(0);

        return out;
    }

    void dfs(int i) {
        if (currSum == target) {
            out.add(new ArrayList<>(curr));
            return;
        }

        int j;
        for (j=i; j<nums.length; j++)
        {
            if (j > i && nums[j] == nums[j - 1]) continue;
            if (currSum + nums[j] > target) break;

            curr.add(nums[j]);
            currSum += nums[j];
            
            dfs(j+1);

            curr.remove(curr.size()-1);
            currSum -= nums[j];
        }
    }
}
