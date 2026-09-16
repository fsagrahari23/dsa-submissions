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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        int i=0;
        

        while(!que.isEmpty()){
           int size = que.size();
           ans.add(new ArrayList<>());
           while(size-->0){
              TreeNode node = que.poll();
              ans.get(i).add(node.val);
              if(node.left!=null){
                que.add(node.left);
              }
              if(node.right!=null){
                que.add(node.right);
              }

           }
           i++;
           
        }

        return ans;
    }
}
