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
    int i=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++ ){
            indexMap.put(inorder[i],i);
        }
        return build(preorder,indexMap,0,inorder.length-1);
    }

    TreeNode build(int[] preorder,Map<Integer, Integer> indexMap,int left,int right){
        if(left>right){
            return null;
        }
        int rVal = preorder[i++];
        TreeNode root = new TreeNode(rVal);

        int mid = indexMap.get(rVal);

        root.left = build(preorder,indexMap,left,mid-1);
        root.right = build(preorder,indexMap,mid+1,right);

        return root;
    }
}
