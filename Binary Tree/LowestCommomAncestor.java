/*Example 1
Input

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
7 5
Output

1
Explanation

      1
    /   \
  2      3
 /      / \
4      5   6
 \
  7
The root of the tree is the deepest node which contains both the nodes 7 and 5 as its descendants, hence 1 is the answer.

Example 2
Input

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
4 2
Output

2
Explanation

      1
    /   \
  2      3
 /      / \
4      5   6
 \
  7
The node will value 2 of the tree is the deepest node which contains both the nodes 4 and 2 as its descendants, hence 2 is the answer.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;



class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
// Main Code --------------->>>>>>>>>
class Solution {
    public static Node findLCA(Node node,int n1,int n2) {
       // write code here
       if(node == null){
        return null;
       }
       if(node.data == n1 || node.data == n2){
        return node;
       }

       Node left  = findLCA(node.left, n1, n2);
       Node right = findLCA(node.right, n1, n2);

       if(left != null && right != null){
        return node;
       }else if(left != null){
        return left;
       }else if(right != null){
        return right;
       }else{
        return null;
       }
    }
}
