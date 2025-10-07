/*
Given an array of n integers where n > 1, return an array output such that output[i] is equal to the sum of all the elements of nums except nums[i]. 
All integers in array are greater than 0.

Input Format
First line consists of an integer n which is the number of elements in array
Next n lines correspond to n elements of array

Output Format
Return the resultant array as asked in question.

Example 1
Input
4
4 3 2 10

Output
15 16 17 9

Explanation
a[0]=15 i.e., 3+2+10
a[1]=16 i.e., 4+2+10
a[2]=17 i.e., 4+3+10
a[3]=9 i.e., 4+3+2
*/
import java.util.*;

public class Main {

    public static int[] SumArrayExpectSelf(int[] nums, int n) {
        //Write code here
        int totalSum = 0;
        for(int num : nums){
            totalSum = totalSum + num;
        }

        int [] result = new int[n];
        for(int i = 0; i < nums.length; i++){
            result[i] = totalSum - nums[i];
        }
        return result;
    }


  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] Ans = SumArrayExpectSelf(nums, n);

        for(int a : Ans)
            System.out.print(a + " ");
    }
}
