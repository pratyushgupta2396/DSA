import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

/*
You are a given a root node of partially constructed BST. You are also given a value target , 
your task is to print all the nodes that add up to form the target value.Make sure all pairs print the smaller value
first and avoid duplicacies and also print the pairs in increasing order.

Input Format
The first line of input contains a number n, representing the number of nodes.

The second line of input contains an integer array representing the nodes.

The third line of input contains a single integer target.

Output Format
You need to print all the nodes that adds up to form the target value.

Example 1
Input

3
2 1 3
4
Output

1 3
Explanation


        2
       / \
      1   3
The sum that adds to be 4 is 1 and 3.
*/

class Accio {
    

    public void targetSum(Node root, int tar)
    {
        // your code here
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int slow = 0;
        int fast = inorder.size() -1;
        boolean found = false;
        while(slow < fast){
            int sum = inorder.get(slow) + inorder.get(fast);
            if(sum == tar){
                System.out.println(inorder.get(slow) + " " + inorder.get(fast));
                found = true;
                slow++;
                fast--;
            }else if(sum < tar){
                slow++;
            }else{
                fast--;
            }
        }
        if(!found){
            System.out.print("-1");
        }
    }
    public void inorderTraversal(Node root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

}
