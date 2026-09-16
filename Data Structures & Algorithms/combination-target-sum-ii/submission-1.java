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
        int last = -1;
        for (j=i; j<nums.length; j++)
        {
            if (last == nums[j]) continue;
            if (currSum + nums[j] > target) break;

            curr.add(nums[j]);
            currSum += nums[j];
            last = nums[j];
            
            dfs(j+1);

            curr.remove(curr.size()-1);
            currSum -= nums[j];
        }
    }
}
