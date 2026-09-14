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
        Map<Integer, Integer> inx = new HashMap<>();
        for (int i=0; i<inorder.length; i++) inx.put(inorder[i], i);
        return bdtree(preorder, inorder, 0, preorder.length,
            0, inorder.length, inx);
    }

    TreeNode bdtree(int[] preorder, int[] inorder, int pi, int pj, int ii, int ij,
    Map<Integer, Integer> inx)
    {
        if (pi == pj) return null;

        TreeNode node = new TreeNode();
        node.val = preorder[pi];
        
        int left = inx.get(node.val) - ii;

        node.left = bdtree(preorder, inorder, pi+1, pi+1+left, ii, ii+left, inx);
        node.right = bdtree(preorder, inorder, pi+1+left, pj, ii+left+1, ij, inx);

        return node;
    }
}
