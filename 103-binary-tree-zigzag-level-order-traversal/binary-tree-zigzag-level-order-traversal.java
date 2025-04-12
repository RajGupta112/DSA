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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> res= new ArrayList<>();
       Queue<TreeNode> q= new LinkedList<>();
       boolean lefttoright=true;
       if(root==null) return res;
       q.add(root);
       while(!q.isEmpty()){
        int size=q.size();
        List<Integer> r= new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode node=q.poll();
            if(lefttoright){
                r.addLast(node.val);
            }else{
                r.addFirst(node.val);
            }

            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
        }
        res.add(r);
        lefttoright=!lefttoright;
       }
       return res;
    }
}