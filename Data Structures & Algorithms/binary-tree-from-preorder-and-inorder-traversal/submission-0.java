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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bdtree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    TreeNode bdtree(int[] preorder, int[] inorder, int pi, int pj, int ii, int ij)
    {
        if (pi == pj) return null;

        TreeNode node = new TreeNode();
        node.val = preorder[pi];
        
        int left = 0;
        while (inorder[ii+left] != node.val) left++;

        node.left = bdtree(preorder, inorder, pi+1, pi+1+left, ii, ii+left);
        node.right = bdtree(preorder, inorder, pi+1+left, pj, ii+left+1, ij);

        return node;
    }
}
