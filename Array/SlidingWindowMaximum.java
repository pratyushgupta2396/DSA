/*Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */

class Solution {
    public int [] calculateNge(int [] nums){
        Stack<Integer> st = new Stack<>();
        int [] nge = new int[nums.length];
        for(int i = nums.length -1; i>=0; i--){
            while(st.size() > 0 && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = nums.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] nge = calculateNge(nums);
        int [] ans = new int[n - k + 1];

        for(int i = 0; i <= n - k; i++){
            int j = i;
            int eI = i + k - 1;
            while(nge[j] <= eI){
                j = nge[j];
            }
            ans[i] = nums[j];
        }
        return ans;  
    }
}
