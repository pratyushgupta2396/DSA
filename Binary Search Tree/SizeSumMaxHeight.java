/*Output Format
The first line contains the size of the tree.

The second line contains the sum of the tree.

The third line contains the maximum value in the tree.

The fourth line contains the height of the tree.

Example 1
Input

1 2 3 4 5 N N N N N N
Output

5
15
5
3
Explanation

The tree looks like this:

        1
      /   \
     2     3
    / \
   4   5
The size of the tree is 5, the sum of the tree is 15, the maximum value in the tree is 5 and the height of the tree is 3.*/


class Solution {
    public int sizeOfTree(Node root) {
        if(root == null) return 0;
        int leftSize = sizeOfTree(root.left);
        int rightSize = sizeOfTree(root.right);
        int size = 1 + leftSize + rightSize;
        return size;
    }

    public int sumOfTree(Node root) {
        if(root == null) return 0;
        int leftSum = sumOfTree(root.left);
        int rightSum = sumOfTree(root.right);
        int sum = root.data + leftSum + rightSum;
        return sum;
    }

    public int maxOfTree(Node root) {
        if(root == null) return Integer.MIN_VALUE;
        int lMax = maxOfTree(root.left);
        int rMax = maxOfTree(root.right);
        int max = Math.max(root.data, Math.max(lMax, rMax));
        return max;
    }

    public int heightOfTree(Node root) {
        if(root == null){
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int h = Math.max(lh, rh) + 1;
        return h;
    }
}
