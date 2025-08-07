/*Example 1
Input

6 5 6 1 1 N 6
Output

1 5 1 6 6 6 
Explanation

The given tree can be represented as:- 
        6
       / \
      5   6
     / \   \ 
    1   1   6
The inorder traversal of the tree is :- 1 5 1 6 6 6 
*/

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.inorderTraversal(root);
            
		
	}
}
  


class Solution {

	

	public static void inorderTraversal(Node root) {
		//Write your code here 
        inorder(root);
    }

    // Helper recursive function for inorder traversal
    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);              // Visit left subtree
        System.out.print(node.data + " "); // Visit root
        inorder(node.right);             // Visit right subtree
    }
        
        
	}
