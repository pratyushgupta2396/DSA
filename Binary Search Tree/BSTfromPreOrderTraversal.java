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
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
class Solution {
    int idx = 0;
    public TreeNode constructTree(int [] preorder, int leftR, int rightR){

        if(idx >= preorder.length){
            return null;
        }
        if(preorder[idx] <= leftR || preorder[idx] >= rightR){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = constructTree(preorder, leftR, root.val);
        root.right = constructTree(preorder, root.val, rightR);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
}
