/*You are given a partially written BST class.
You are required to complete the body of size, sum, max, min and find function. The functions are expected to:

size - return the number of nodes in BST
sum - return the sum of nodes in BST
max - return the value of the node with the greatest value in BST
min - return the value of the node with the smallest value in BST
find - return true if there is a node in the tree equal to "data"
Note
Complete the given function. The input and output would be handled by the driver code.

Input Format
Input is managed for you.
Output Format
Output is managed for you.

Example 1
Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
70

Output
9
448
87
12
true
Explanation
The number of nodes is 9.
The sum of values is 448.
The maximum value is 87.
The minimum value is 12.
The BST contains a node with value 70. Thus, true.
*/
public static int size(Node node) {
    // write your code here
    if(node == null) return 0;
    int leftSize = size(node.left);
    int rightSize = size(node.right);
    return leftSize + rightSize + 1;
  }

  public static int sum(Node node) {
    // write your code here
    if(node == null) return 0;
    int leftSum = sum(node.left);
    int rightSum = sum(node.right);
    return leftSum + rightSum + node.data;
  }

  public static int max(Node node) {
    // write your code here
    if(node.right == null) return node.data;
    return max(node.right);

  }

  public static int min(Node node) {
    // write your code here
    if(node.left == null) return node.data;
    return min(node.left);
  }

  public static boolean find(Node node, int data){
    // write your code here
    if(node == null) return false;
    if(node.data == data) return true;
    if(node.data < data){
      return find(node.right, data);
    }else{
      return find(node.left, data);
    }
  }  
