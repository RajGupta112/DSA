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
     public void preorder(TreeNode root, List<Integer> pre){
        if(root==null) return;
        
        preorder(root.left,pre);
        pre.add(root.val);
        preorder(root.right,pre);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> pre=new ArrayList<>();
        preorder(root,pre);
        return pre;
    }
}