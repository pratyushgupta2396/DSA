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
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
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
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

/*
 Given the root node of a BST, print its left view i.e print all the nodes from top to bottom that will appear while looking the tree from left.

Input Format
The first line contains an integer n, the number of nodes.
The next line inputs the value of n nodes.

Output Format
Print the left view of the tree as a single line of space-separated values.

Example 1
Input

6
1 2 5 3 4 6
Output

1 2 5 3 4 
Explanation

The BST is like :-
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
So,the left view of tree results in 1,2,5,3,4 as the required result. only 6 is not visible from left view
*/

class Solution
{
    public static void letfView(Node root)
    {
        // Your code here
       ArrayList<Integer> ans = new ArrayList<>();
    //if(root == null) return ans;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            Node curr = q.poll();
            if(i == 0) ans.add(curr.val);
            if(curr.left  != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
            
        }
    }
    for(int data : ans){
            System.out.print(data + " ");
	 
    }
    }
    
}
