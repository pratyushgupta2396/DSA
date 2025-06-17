/*Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Input Format
Input consists of two lines.

First line contains an integer n which is the number of elements in nums.

Next line contains n spaced integers which represents the elements of nums.

Output Format
Return true if a 132 pattern is found otherwise return false.

Example 1
Input

4
1 2 3 4
Output

false
Explanation

There is no 132 pattern in the sequence.*/

import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        //Write code here
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int third = Integer.MIN_VALUE;

        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < third){
                return true;
            }
            while(!st.isEmpty() && nums[i] > st.peek()){
                third = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        boolean result = Obj.find132pattern(arr);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
