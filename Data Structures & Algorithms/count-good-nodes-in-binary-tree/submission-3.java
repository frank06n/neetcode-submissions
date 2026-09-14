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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    int dfs(TreeNode node, int max)
    {
        int count = 0;
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        if (node.left != null) count += dfs(node.left, max);
        if (node.right != null) count += dfs(node.right, max);
        
        return count;
    }
}
