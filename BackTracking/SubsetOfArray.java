import java.util.*; 

class Main{

    public static void sort2DArrayList(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> sublist1, ArrayList<Integer> sublist2) {
                // Compare values up to the minimum of their sizes
                int minLength = Math.min(sublist1.size(), sublist2.size());
                for (int i = 0; i < minLength; i++) {
                    int valueComparison = Integer.compare(sublist1.get(i), sublist2.get(i));
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                }

                // If values are the same, compare sizes
                return Integer.compare(sublist1.size(), sublist2.size());
            }
        });
    }
    
 
    
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        //Write your code here 
        calcSubset(0, arr, new ArrayList<>());
        return main;
       
    }

    static ArrayList<ArrayList<Integer>> main = new ArrayList<>();

    public static void calcSubset(int idx, int [] arr, ArrayList<Integer> ssf){
        if(idx == arr.length){
            ArrayList<Integer> subset = new ArrayList<>(ssf);
            main.add(subset);
            return;

        }
        ssf.add(arr[idx]);
        calcSubset(idx + 1, arr, ssf);
        ssf.remove(ssf.size() - 1);
        calcSubset(idx + 1, arr, ssf);
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int []A=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            } 

            Arrays.sort(A); 
            ArrayList <ArrayList<Integer>> res = subsets(A,n); 
        
            sort2DArrayList(res); 

            for (int i = 0; i < res.size (); i++)
            {
                for (int j = 0; j < res.get(i).size (); j++)
                {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();

            }
        }
    }
}
