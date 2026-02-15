  /*Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
*/ 
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
     TreeNode prev = null; 
    TreeNode dummy = new TreeNode(-1);  

    public TreeNode increasingBST(TreeNode root) {
        prev = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        
        node.left = null;
        prev.right = node;
        prev = node;

        inOrder(node.right);
    }
}
