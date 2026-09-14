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
        if (root.left != null) {
            if (root.left.val >= root.val) return false;
            if (root.left.val <= min) return false;
            if (!validBST(root.left, min, root.val)) return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            if (root.right.val >= max) return false;
            if (!validBST(root.right, root.val, max)) return false;
        }
        return true;
    }
}
