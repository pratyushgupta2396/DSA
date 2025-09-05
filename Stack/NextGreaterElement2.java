/*Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.*/

class Solution { 
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int [] ans = new int[n];

        for(int i = 2 * n -1; i >= 0; i--){
            int idx = i % n;
            while(!st.isEmpty() && st.peek() <= nums[idx]){
                st.pop();
            }
            ans[idx] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[idx]);
        }
        
        return ans;
    }
}
