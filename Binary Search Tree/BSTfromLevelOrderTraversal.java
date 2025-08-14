import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

/*
You are given an array representing the valid level order traversal of a BST. You are required to build the unique 
Binary Search Tree of which the level order traversal is provided.
A Binary Search Tree (BST) is a binary tree data structure that has the following properties -

The left subtree of a node contains only nodes with data less than the node’s data.
The right subtree of a node contains only nodes with data greater than the node’s data.
Both the left and right subtrees must also be binary search trees.
Note
You are required to return the root node of the BST and the printing will be taken care of in the main function. 
Simply complete the function bstFromLevel which receives n and input array as parameters and returns the root node of the BST.

Input Format
First line of input contains n representing the number of nodes.
The second line contains the n space-separated nodes representing the level order of the BST.

Output Format
The single line of output contains the level order traversal of the BST.

Example 1
Input
6
3 2 5 1 6 7

        3
      /  \
    2     5
  /        \
1           6
             \
              7
Output
3 2 5 1 6 7

Example 2
Input
6
5 3 6 2 4 7 

        5
      /   \
    3      6
  /  \      \
2     4      7
Output
5 3 6 2 4 7 
*/
class Solution {
    class Pair{
        Node parent;
        int min;
        int max;
        boolean isLeft;
        Pair(Node parent, int mmin, int max, boolean isLeft){
            this.parent = parent;
            this.min = min;
            this.max = max;
            this.isLeft = isLeft;
        }
    }
    Node bstFromLevel(int arr[], int n) {
        // write code here
        if(n == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Integer.MIN_VALUE, root.data, true));
        q.add(new Pair(root, root.data, Integer.MAX_VALUE, false));

        int i = 1;
        while(i < n && !q.isEmpty()){
            Pair curr = q.poll();
            if(arr[i] > curr.min && arr[i] < curr.max){
                Node child = new Node(arr[i]);
                if(curr.isLeft){
                    curr.parent.left = child;
                }else{
                    curr.parent.right = child;
                }
                q.add(new Pair(child, curr.min, arr[i], true));
                q.add(new Pair(child, arr[i], curr.max, false));
                i++;
            }
        }
        return root;
    }
}
