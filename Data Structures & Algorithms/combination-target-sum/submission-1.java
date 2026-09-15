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
            // for (int k=0; k<i; k++) System.out.print("  ");
            // System.out.printf("N=0 i[%d] csum=%d\n", i, currSum);
        }

        // for (int k=0; k<i; k++) System.out.print("  ");
        // System.out.printf("i[%d]*0 dfs;\n", i);
        dfs(i+1);
        
        for (int j=0; j<N; j++)
        {
            curr.add(nums[i]);
            currSum += nums[i];

            // for (int k=0; k<i; k++) System.out.print("  ");
            // System.out.printf("i[%d]*%d dfs;\n", i, j+1);
            dfs(i+1);
        }

        for (int j=0; j<N; j++)
        {
            curr.remove(curr.size() - 1);
            currSum -= nums[i];
        }
    }
}
