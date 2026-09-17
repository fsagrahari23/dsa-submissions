class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, solve(root.left));
        int rightSum = Math.max(0, solve(root.right));

        // Path passing through current node
        int currentPath = root.val + leftSum + rightSum;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return best path that can be extended to parent
        return root.val + Math.max(leftSum, rightSum);
    }
}