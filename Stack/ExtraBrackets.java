/*
Example 1
Input
((a + b) + (c + d))
Output
false

Example 2
Input
(a + b) + ((c + d))
Output
true
*/
class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here
       Stack<Character> st = new Stack<>();
       for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        if(ch == ')'){
            if(st.peek() == '('){
                return true;
            }else{
                while(st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
        }else{
            st.push(ch);
        }
       }
       return false;
    }
}
