import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

/*
You are given N nodes and have to form BST from it. The task is to find the minimum element in this BST.

Input Format
The first line inputs N, the number of nodes.
The second line inputs the value of N nodes of the BST.

Output Format
Print the minimum value of the BST in a new line.

Example 1
Input

7
2 81 42 87 90 41 66
Output

2
Explaination

     2
      \
      81
     /  \
   42    87
  /  \    \
 41   66   90

The minimum in the BST is 2.
*/

class Solution{
    public int minimumNode(Node root){
        // WRITE YOUR CODE HERE 
        if(root == null) return -1;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
             
    }
    
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        int result= obj.minimumNode(t.root);
        System.out.print(result);
        
    }
}
