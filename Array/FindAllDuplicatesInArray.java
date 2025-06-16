/*Input

8
4 3 2 7 8 2 3 1
Output

2 3
Explanation

2 and 3 are only the elements that are repeated twice*/

import java.util.*;

class Solution {
    public void allDuplicates(int n, int[] arr) {
        // Write Your code here.
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                result.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        Collections.sort(result);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}
