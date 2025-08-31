/*
Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
*/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i = words.length -1; i >= 0; i--){
            sb.append(words[i]);
        
        if(i != 0) sb.append(" ");
        }
        return sb.toString();

    }
}
