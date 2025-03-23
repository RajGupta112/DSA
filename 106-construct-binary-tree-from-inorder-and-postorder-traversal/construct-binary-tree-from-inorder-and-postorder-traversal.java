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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=inorder.length;
        return helper(inorder,postorder,0,len-1,0,len-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder,int instart, int inend,int poststart, int postend){
        if(instart>inend || poststart > postend){
            return null;
        }
        int rootval=postorder[postend];
        TreeNode root= new TreeNode(rootval);

          int rootindex = instart;
        while (inorder[rootindex] != rootval) {
            rootindex++;
        }

            int leftTreesize=rootindex-instart;
            int rightTreesize=inend-rootindex;
            root.left=helper(inorder,postorder,instart,rootindex-1,poststart,poststart+leftTreesize-1);
            root.right=helper(inorder,postorder,rootindex+1,inend,poststart+leftTreesize,postend-1);
         
         return root;
    }
}