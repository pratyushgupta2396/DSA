/*Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, s.length() - 1); 
            
            while (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
