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
You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

  Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
*/

class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    TreeNode infected = null;
    public void travel(TreeNode node, TreeNode parent, int infectedValue){
        if(node == null){
            return;
        }
        if(node.val == infectedValue){
            infected = node;
        }
        map.put(node,parent);
        travel(node.left, node, infectedValue);
        travel(node.right, node, infectedValue);
    }
    public int amountOfTime(TreeNode root, int start) {
        travel(root, null, start);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(infected);
        Set<TreeNode> isInfected = new HashSet<>();
        int time = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                TreeNode rem = q.removeFirst();
                isInfected.add(rem);
                if(rem.left != null && !isInfected.contains(rem.left)){
                    q.addLast(rem.left);
                }
                if(rem.right != null && !isInfected.contains(rem.right)){
                    q.addLast(rem.right);
                }
                TreeNode parent = map.get(rem);
                if(parent != null && !isInfected.contains(parent)){
                    q.addLast(parent);
                }
            }
            time++;
        }
        return time-1;
    }
}
