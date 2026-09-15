class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int currSum;
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        out = new ArrayList<>();
        curr = new ArrayList<>();
        currSum = 0;
        this.target = target;

        dfs(0);

        return out;
    }

    void dfs(int i)
    {
        if (i == nums.length) {
            if (currSum == target) out.add(new ArrayList<>(curr));
            return;
        }

        int N = (target - currSum)/nums[i];

        if (N == 0) {
            if (currSum == target) {
                out.add(new ArrayList<>(curr));
                return;
            }
        }

        dfs(i+1);
        
        for (int j=0; j<N; j++)
        {
            curr.add(nums[i]);
            currSum += nums[i];

            dfs(i+1);
        }

        for (int j=0; j<N; j++)
        {
            curr.remove(curr.size() - 1);
            currSum -= nums[i];
        }
    }
}
