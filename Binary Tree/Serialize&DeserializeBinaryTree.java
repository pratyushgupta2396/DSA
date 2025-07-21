/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
   Serialization is the process of converting a data structure or object into a sequence of bits 
   so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
   same or another computer environment.
   Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
   serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be 
   serialized to a string and this string can be deserialized to the original tree structure.

  Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
  You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

   Example 1:
   Input: root = [1,2,3,null,null,4,5]
   Output: [1,2,3,null,null,4,5]
*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(q.size() > 0){
            int size = q.size();
            while(size-- != 0){
                TreeNode rem = q.removeFirst();
                if(rem == null){
                    sb.append("# ");
                }else{
                    q.addLast(rem.left);
                    q.addLast(rem.right);
                    sb.append(rem.val + " ");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String [] nodeVals = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int idx = 1;
        while(q.size() > 0){
            TreeNode rem = q.removeFirst();
            TreeNode left = null;
            if(!nodeVals[idx].equals("#")){
                left = new TreeNode(Integer.parseInt(nodeVals[idx]));
                rem.left = left;
                q.addLast(left);
            }
            idx++;
            TreeNode right = null;
            if(!nodeVals[idx].equals("#")){
                right = new TreeNode(Integer.parseInt(nodeVals[idx]));
                rem.right = right;
                q.addLast(right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
