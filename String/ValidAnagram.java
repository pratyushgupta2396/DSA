/*Example 1
Input:

anagram
grmaana
Output:

Yes
Explanation:

Both anagram and gramaana contains same set of characters.*/

import java.util.*;

class Solution {
   static boolean areAnagram(String c1, String c2) {
       //Write your code here
       if (c1.length() != c2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < c1.length(); i++) {
            count[c1.charAt(i) - 'a']++;
            count[c2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
