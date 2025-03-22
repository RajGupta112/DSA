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
        return validBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBst(TreeNode root, long minval, long maxval) { // Change Long to long for minval and maxval
        if (root == null) return true;

        // The value of the current node must be strictly between minval and maxval
        if ((long) root.val <= minval || (long) root.val >= maxval) return false;  // Explicitly cast root.val to long

        // Recursively check left and right subtrees with updated ranges
        return validBst(root.left, minval, root.val) && validBst(root.right, root.val, maxval);
    }
}
