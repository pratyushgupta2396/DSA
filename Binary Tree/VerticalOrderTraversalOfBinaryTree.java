/*Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
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
class Solution {public class Pair implements Comparable<Pair>{
        TreeNode node;
        int vidx;
        int hidx;
        Pair(TreeNode node, int vidx,int hidx){
            this.node = node;
            this.vidx = vidx;
            this.hidx = hidx;
        }

        public int compareTo(Pair o){
            if(this.hidx == o.hidx){
                return this.node.val - o.node.val;
            }else{
                return this.hidx - o.hidx;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        LinkedList<Pair> q = new LinkedList<>();
        
        int level = 1;
        q.addLast(new Pair(root, 0, level));
        while(q.size() > 0){
            int size = q.size();
            while(size-- != 0){
                // 1. Remove node
                Pair rem = q.removeFirst();
                int vidx = rem.vidx;
                // 2. put that node in map
                if(map.containsKey(vidx)){
                    List<Pair> li = map.get(vidx);
                    li.add(rem);
                }else{
                    List<Pair> li = new ArrayList<>();
                    li.add(rem);
                    map.put(vidx, li);
                }
                // put child of node in queue 
                if(rem.node.left != null){
                    q.addLast(new Pair(rem.node.left, vidx - 1, level + 1));
                }
                if(rem.node.right != null){
                    q.addLast(new Pair(rem.node.right, vidx + 1, level +1 ));
                }
            }
            level = level + 1;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int key : map.keySet()){
            List<Pair> li = map.get(key);
            Collections.sort(li);
            List<Integer> li2 = new ArrayList<>();
            for(Pair p : li){
                li2.add(p.node.val);
            }
            ans.add(li2);
        }

        return ans;



    }
}
