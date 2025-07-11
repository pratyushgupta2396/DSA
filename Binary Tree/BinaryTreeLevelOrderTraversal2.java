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
/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. 
  (i.e., from left to right, level by level from leaf to root).
  Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int level = 1;
        List<List<Integer>> ans = new ArrayList<>();

        while(q.size() != 0){
            int size = q.size(); // 
            List<Integer> li = new ArrayList<>();
            while(size != 0){
                TreeNode rem = q.removeFirst();
                li.add(rem.val);
                if(rem.left != null){
                    q.addLast(rem.left);
                }
                if(rem.right != null){
                    q.addLast(rem.right);
                }
                size--;
            }
            level++;
            ans.add(li);
        }
        Collections.reverse(ans);
         return ans;
    }
}
