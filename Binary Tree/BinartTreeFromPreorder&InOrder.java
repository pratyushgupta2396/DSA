import java.util.*;
import java.io.*;
class Node{
    int data; 
    Node left, right;
    Node(int key){
        data = key;
        left = right = null;
    }
}

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for(int i = 0; i < n; i++)
          preorder[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
          inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }
    
    public static void postOrdrer(Node root){
        if(root == null)
          return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
/*
You are given two arrays of size N each. They represent the preorder and inorder traversals of a binary tree.
You need to construct the original binary tree with their help. You need to print the postorder traversal of the formed tree.

NOTE You need to complete the given function and return the head node. The input and printing of output will be handled by the driver code.

Input
6
10 11 23 24 12 35
23 11 24 10 35 12
  
Output
23 24 11 35 12 10
  
Explanation
You can check the postorder from the given tree.
*/
  
class Solution{
    public  Node createTree(int[] inorder, int[] preorder, int psi, int pei, int isi, int iei, HashMap<Integer, Integer> map){
        // create root
        if(psi > pei || isi > iei){
            return null;
        }
        //if(psi == pie && isi == iei){
        //    return new Node(preorder[psi]);
       // }
        Node root = new Node(preorder[psi]);
        int idx = map.get(preorder[psi]);
        int lc = idx - isi;
        
        int lisi = isi;
        int liei = idx - 1;
        int lpsi = psi + 1;
        int lpei = psi + lc;

        int risi = idx + 1;
        int riei = iei;
        int rpsi = lpei + 1;
        int rpei = pei;

        root.left = createTree(inorder, preorder, lpsi, lpei, lisi, liei, map);
        root.right = createTree(inorder, preorder, rpsi, rpei, risi, riei, map);
        return root;
        // root.left = createTree(inorder, preorder, psi + 1, psi + lc, isi, idx - 1, map);
        // root.right = createTree(inorder, preorder, psi + lc + 1, pei, idx + 1, iei, map);
         //return root;
    }
    public Node buildTree(int inorder[], int preorder[], int n){
        //Your code here 
       // n = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        Node root = createTree(inorder, preorder, 0, n-1, 0, n-1, map);
        return root;
    }
     public void printPostorder(Node root) {
            if (root == null) return;
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
}
