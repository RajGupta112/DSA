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
    int totalSum=Integer.MIN_VALUE;
    public int solve(TreeNode root){
  if(root==null) return 0;
  int left=solve(root.left);
  int right=solve(root.right);
  int fs=left+right+root.val;
  int ss=Math.max(left,right)+root.val;
  int ts=root.val;
 totalSum = Math.max(totalSum, Math.max(fs, Math.max(ss, ts)));
  return Math.max(ss,ts);
  
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return totalSum;
    }
}