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
    public int maxLevelSum(TreeNode root) {
        int maxsum=Integer.MIN_VALUE;
        int relevel=0;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int level=1;

        while(!q.isEmpty()){
            int size=q.size();
            int levelsum=0;
            while(size-->0){
           TreeNode node=q.poll();
           levelsum+=node.val;
           if(node.left!=null){
            q.offer(node.left);
           }
           if(node.right!=null){
            q.offer(node.right);
           }
            }
            if(levelsum>maxsum){
                maxsum=levelsum;
                relevel=level;
            }
            level++;
        }
        return relevel;
    }
}