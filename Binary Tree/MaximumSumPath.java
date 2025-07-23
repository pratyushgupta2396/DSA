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
 A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
 A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

*/

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }
    public int maxPath(TreeNode root){
        if(root == null) return 0;

        int leftGain  = Math.max(maxPath(root.left), 0);
        int rightGain = Math.max(maxPath(root.right), 0);

        int currSum = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currSum);
        return root.val + Math.max(leftGain, rightGain);
    }
}
