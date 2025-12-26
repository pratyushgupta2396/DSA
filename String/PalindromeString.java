 /*
You are given a string s. Your task is to determine if the string is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.
Examples :
Input: s = "abba"
Output: true
Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
*/
class Solution {
    boolean isPalindrome(String s) {
        // code here
        int left = 0; 
        int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
         }
        return true;
    }
}
