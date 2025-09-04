/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0; 
        int j = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        while(i < s.length()){
            char chi = s.charAt(i);
            freq.put(chi, freq.getOrDefault(chi, 0) + 1);
            while(freq.get(chi) > 1){
                char chj = s.charAt(j);
                freq.put(chj, freq.get(chj) -1);
                j++;
            }
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }
}
