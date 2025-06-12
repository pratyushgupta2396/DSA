import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    static int[] stockSpan(int[] a) {
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[a.length];
        for(int i = 0; i < a.length; i++){
            while(st.size() > 0 && a[st.peek()] <= a[i]){
                st.pop();
            }
            if(st.size() == 0){
                int daySpan = i - (-1);
                ans[i] = daySpan;

            }else{
                int daySpan = i - st.peek();
                ans[i] = daySpan;
            }
             st.push(i);
        }
        return ans;
        
    }
}
