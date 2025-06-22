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


/*Input

6 5 6 1 1 N 6
Output

6 5 1 1 6 6 
Explanation

The given tree can be represented as:- 
        6
       / \
      5   6
     / \   \
    1   1   6
The preorder traversal of the tree is :- 6 5 1 1 6 68*/

class Solution {
    public void preorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
}
