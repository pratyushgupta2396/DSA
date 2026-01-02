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
You are given the root of a binary search tree (BST), where the values of exactly two nodes 
of the tree were swapped by mistake. Recover the tree without changing its structure.
Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
*/

class Solution {
    TreeNode curr = null;
    TreeNode prev = null;
    TreeNode node1 = null;
    TreeNode node2 = null;
    public void recoverTree(TreeNode root) {
       traversal(root);
       int temp = node1.val;
       node1.val = node2.val;
       node2.val = temp; 
    }

    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        curr = root;
        if(prev != null && prev.val > curr.val){
            if(node1 == null){
                node1 = prev;
                node2 = curr;
            }else{
                node2 = curr;
            }
        }
        prev = curr;
        traversal(root.right);
    }
}
