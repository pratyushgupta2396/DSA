/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length -1];

        int i = 0;
        while(i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }
        return first.substring(0, i);
    }
}
