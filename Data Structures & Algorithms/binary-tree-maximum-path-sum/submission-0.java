/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if (root==null) return 0;
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    int dfs(TreeNode root)
    {
        if (root == null) return 0;
        int sum = root.val;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int exSum = Math.max(leftSum, rightSum);
        if (exSum > 0)
        {
            if (sum+leftSum+rightSum > maxSum) maxSum = sum+leftSum+rightSum;
            sum = sum+exSum;
        }
        
        if (sum > maxSum) maxSum = sum;
        // System.out.printf("R: %d | LS: %d | RS: %d | S: %d | MS: %d\n",
        // root.val, leftSum, rightSum, sum, maxSum);
        return sum;
    }
}
