import java.util.*;

class solution{
    public static void realsolve(int[]nums,int n ,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr,int index){
        if(!curr.isEmpty()){
            ans.add(new ArrayList<>(curr));
            
        }
        

        for(int i=index;i<nums.length;i++){
            if(i> index && nums[i]==nums[i-1])  continue;
            curr.add(nums[i]);
            realsolve(nums,n,ans,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>>  solve(int[]nums,int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
         realsolve(nums,n,ans,new ArrayList<>(),0);
         return ans;
         
    }
    }

public class Main{
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums []= new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> list =solution.solve(nums,n);

        for (ArrayList<Integer> innerList : list) {
    Collections.sort(innerList);
}
       
                Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int len = Math.min(a.size(), b.size());
                for (int i = 0; i < len; i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return a.size() - b.size(); 
            }
        });

        for (ArrayList<Integer> inner : list) {
            for (int num : inner) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}
