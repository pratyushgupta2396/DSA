/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

 Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int right = s.length()-1;

        while(right >= 0 && s.charAt(right) == ' '){
            right--;
        }

        while(right >= 0 && s.charAt(right) != ' '){
            length++;
            right--;
        }
        return length;
    }
}
