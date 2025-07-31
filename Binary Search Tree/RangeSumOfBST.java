/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
You are given a pointer to the root of binary search tree. You are also given two integers L and R.
You have to find the sum of values of nodes which lie in the range from [L, R] inclusive.

NOTE: You need to complete the given function rangeSum which receives the root, L and R as the parameters and
returns the required sum. The input and printing of output will be handled by the driver code.

Input Format:
The first line contains the number of test cases.

For each test case: You are given a pointer to the root of the binary tree and the values of 'L' and 'R'.

Output Format:
For each test case print the sum.

Example 1:
Input:

1
3 2 4
1 2 3

Output:

5
Explanation:

   2
 /   \
1     3
'2' and '3' lie within the range [2, 4]. 2 + 3 = 5.
*/
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int currVal = (root.val >= low && root.val <= high) ? root.val : 0;

        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);

        return currVal + leftSum + rightSum;
    }
}
