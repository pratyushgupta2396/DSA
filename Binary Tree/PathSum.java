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
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
  such that adding up all the values along the path equals targetSum.
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum.
  */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        int remainingSum = targetSum - root.val;
        boolean leftSum  = hasPathSum(root.left, remainingSum);
        boolean rightSum = hasPathSum(root.right, remainingSum);
        return leftSum || rightSum;
    }
}
