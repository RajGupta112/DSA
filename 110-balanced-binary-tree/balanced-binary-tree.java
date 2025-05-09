class Solution {
    public int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int left = dfsHeight(root.left);
        if (left == -1) return -1;

        int right = dfsHeight(root.right);
        if (right == -1) return -1;

        // ✅ Correct comparison
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
}

