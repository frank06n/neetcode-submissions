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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, -1_000_000_000, 1_000_000_000);
    }
    public boolean validBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return validBST(root.left, min, root.val) 
            && validBST(root.right, root.val, max);
    }
}
