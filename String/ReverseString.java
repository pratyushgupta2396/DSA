/*
Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
*/
class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
