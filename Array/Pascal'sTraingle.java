import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

	public static ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> zerothLi = new ArrayList<>();
        zerothLi.add(1);
        ans.add(zerothLi);
        if(n == 1){
            return ans;
        }

        ArrayList<Integer> firstLi = new ArrayList<>();
        firstLi.add(1);
        firstLi.add(1);
        ans.add(firstLi);

        for( int row = 2; row < n; row++){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);

            ArrayList<Integer> prev = ans.get(row - 1);
            for(int j = 0; j < prev.size() - 1; j++){
                int val1 = prev.get(j);
                int val2 = prev.get(j+1);
                int sum = val1 + val2;

                curr.add(sum);
            }
            curr.add(1);

            ans.add(curr);
            
        }
        return ans;
    }
   
}
