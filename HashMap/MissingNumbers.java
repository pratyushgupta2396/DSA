   /*Example 1

Input
10  
203 204 205 206 207 208 203 204 205 206 
13 
203 204 204 205 206 207 205 208 203 206 205 206 204

Output
204 205 206
 
Explanation
203 is in both arr and brr and its frequency is 2 in both arrays, hence it is not included in output
204 is included in both arrays but have different frequency hence, it is included in output
Similarly other numbers are considered*/

import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr1[], int m, int arr2[]) {
        //Write your code here
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            // if(map1.containszkey(arr1[i])){
            //     int freq = map1.get(arr[i]);
            //     map1.put(arr1[i], freq + 1);
            // }else{
            //     map1.put(arr1[i] , 1);
            // }
            map1.put(arr1[i], map1.getOrDefault(arr1[i] ,0) + 1);
        }
             HashMap<Integer, Integer> map2 = new HashMap<>();
             for(int i = 0; i < arr2.length; i++){
                map2.put(arr2[i], map2.getOrDefault(arr2[i] ,0) + 1);
             }

             ArrayList<Integer> missingNumbers = new ArrayList<>();
             for(int key : map2.keySet()){
                if(map1.containsKey(key)){
                    int freq1 = map1.get(key);
                    int freq2 = map2.get(key);
                    if(freq1 != freq2){
                        missingNumbers.add(key);
                    }
                }else{
                    missingNumbers.add(key);
                }
             }
             Collections.sort(missingNumbers);
             if(missingNumbers.size() > 0){
                for(int i = 0; i < missingNumbers.size(); i++){
                System.out.print(missingNumbers.get(i) + " ");
             }
          }else{
            System.out.println(-1);
          }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}
