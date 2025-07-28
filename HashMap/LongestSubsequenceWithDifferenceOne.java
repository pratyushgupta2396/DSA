/*
You are given an array nums of size N.
Find the length of the longest subsequence of array nums such that the absolute difference between every adjacent element in the subsequence is one.

Input Format
First line contains the size of array  N.
Second line contains n-spaced integers represeting array nums.

Output Format
Print an integer denoting the length of the longest subsequence of array nums such that the difference between adjacent elements is one.

Example 1
Input
5
4 2 1 5 6
Output
3
Explanation
The longest subsequence satisfying the condition is {4, 5, 6}.
*/

import java.util.*;

class Accio {
    public int longestSubsequence(int[] nums) {
       //Your code goes here
       HashMap<Integer, Integer> map = new HashMap<>();
       int maxLength = 0;
       for(int num : nums){
        int left = map.getOrDefault(num - 1, 0);
        int right = map.getOrDefault(num + 1, 0);
        int currLength = 1 + Math.max(left, right);
        map.put(num, currLength);
        maxLength = Math.max(maxLength, currLength);
       }
       return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
    	for(int i=0;i<N;i++)
	    nums[i] = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestSubsequence(nums));
    }
}
