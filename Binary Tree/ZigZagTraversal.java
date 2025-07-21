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
 Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
 (i.e., from left to right, then right to left for the next level and alternate between).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while(!q.isEmpty()){
            List<Integer> current = new ArrayList<>();
            int level = q.size();
            for(int i = 0; i < level; i++){
                TreeNode curr = q.poll();
                if(!flag){
                    current.addLast(curr.val);
                }else{
                    current.addFirst(curr.val);
                }
                if(curr.left  != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(current);
            flag =! flag;
        }
        return res;
    }
}
