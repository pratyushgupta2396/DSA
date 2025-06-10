
import java.util.*;

class Solution {
    public static void solve(int []coins,int amt,ArrayList<Integer> curr){
        if(amt==0){
            for(int lol : curr){
                System.out.print(lol+" ");
            }
            System.out.println();
        }

        if(amt<0) return;

        for(int i=0;i<coins.length;i++){
            curr.add(coins[i]);
            solve(coins,amt-coins[i],curr);
            curr.remove(curr.size()-1);
        }
    }
    public static void coinChange2(int[] coins, int amt){
        //Write your code here
        solve(coins,amt,new ArrayList<>());

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange2(coins, amt);
    }
}
