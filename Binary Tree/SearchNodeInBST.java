/*Example 1
Input

7 87
2 81 42 87 90 42 45 66
Output

YES
Explaination

   2
    \
    81
   /  \
  42   87
 /  \   \
45  66   90

As 87 is present in the given nodes , so the output will be YES.*/


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

class Solution{
    public boolean searchNode(Node root,int k){
        // WRITE YOUR CODE HERE
        if(root == null){
            return false;
        }
        if(root.val == k){
            return true;
        }
        if(k < root.val){
            return searchNode(root.left, k);
        }else{
            return searchNode(root.right, k);
        }
       
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        boolean result= obj.searchNode(t.root,k);
        if(result){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
        
    }
}
