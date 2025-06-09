import java.util.*;

class Solution {
    public static void solve(int start,int k, int n,List<List<Integer>> ans,List<Integer> curr){
        if(n==0 && curr.size()==k){
            ans.add(new ArrayList(curr));
            return;
        }
        if(n<0 || curr.size()>k) return;


        for(int i =start;i<=9;i++){
            curr.add(i);
            solve(i+1,k,n-i,ans,curr);
           curr.remove(curr.size()-1);
           //solve(i+1,k,n,ans,curr);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        //write your code here 
        List<List<Integer>> ans = new ArrayList<>();
        solve(1,k,n,ans,new ArrayList<Integer>() );
        return ans;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum3(k,n);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }


    }
}
