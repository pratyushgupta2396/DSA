
import java.util.*;

class Solution {
    public static void coinChange(int[] coins, int amt){
        //Write your code here 
        boolean [] visited = new boolean [coins.length];
        generatePermutation(coins, visited, amt, "", 0);
        
    }

    public static void generatePermutation(int [] coins, boolean [] visited, int target, String asf, int ssf){
        if(ssf > target){
            return;
        }
        if(ssf == target){
            System.out.println(asf);
            return;
           
        }
        for(int i = 0; i < coins.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                generatePermutation(coins, visited, target, asf + coins[i] + " ", ssf + coins[i]);
                visited[i] = false;
            }
        }
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
        Obj.coinChange(coins, amt);
    }
}
