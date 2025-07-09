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
/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
postorder is the postorder traversal of the same tree, construct and return the binary tree.
  Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 Output: [3,9,20,null,null,15,7]*/

 // isi = inorderStartIndex, iei = inorderEndIndex
 // psi = postorderStartIndex, pei = postorderEndIndex
 
class Solution {
    public TreeNode createTree(int[] in, int[] post, int isi, int iei, int psi, int pei, HashMap<Integer, Integer> map){
        if(isi > iei || psi > pei){
            return null;
        }
        TreeNode root = new TreeNode(post[pei]);
        int idx = map.get(post[pei]);
        int lc = idx - isi;

        root.left = createTree(in, post, isi, idx - 1, psi, psi + lc - 1, map);
        root.right = createTree(in, post, idx + 1, iei, psi + lc, pei - 1, map);
        return root;



    }
    public TreeNode buildTree(int[] in, int[] post) {
        int n = in.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        TreeNode root = createTree(in, post, 0, n-1, 0, n-1, map);
        return root;
    }
}
