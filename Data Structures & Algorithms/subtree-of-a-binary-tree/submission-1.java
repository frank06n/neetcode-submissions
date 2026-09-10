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
    boolean check(TreeNode root, TreeNode subRoot, boolean subcheck)
    {
        // System.out.println("chk" + (subcheck?"(sub)":""));
        if (root==null) return subRoot==null;
        if (subRoot==null) return root==null;

        // System.out.println("> chk-val: " + root.val+" "+subRoot.val);
        if (root.val == subRoot.val)
        {
            boolean ans = check(root.left, subRoot.left, true)
                        && check(root.right, subRoot.right, true);
            if (ans) return true;
        }
        if (subcheck) return false;

        return check(root.left, subRoot, false) || check(root.right, subRoot, false);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return check(root, subRoot, false);
    }
}
