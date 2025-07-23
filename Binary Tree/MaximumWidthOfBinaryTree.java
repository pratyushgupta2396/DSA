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
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down
to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.
Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
*/
class Solution {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0)); 

        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0, last = 0;

            for(int i = 0; i < size; i++){
                Pair current = q.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex;
                
                if(i == 0) first = index;
                if(i == size-1) last = index;

                if(node.left !=  null) q.offer(new Pair(node.left, 2*index));
                if(node.right != null) q.offer(new Pair(node.right, 2*index+1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}
