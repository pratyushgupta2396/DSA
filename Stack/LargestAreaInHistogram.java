/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>(); 
        int [] nsel = new int[heights.length]; // nsel -> next smaller element on the index left
        st.push(0);
        nsel[0] = -1;
        for(int i = 1; i < heights.length; i++){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nsel[i] = -1;
            }else{
                nsel[i] = st.peek();
            }
            st.push(i);
        }


        st = new Stack<>();
        int [] nser = new int[heights.length]; // nser -> next smaller element on the index right
        st.push(heights.length-1);
        nser[heights.length-1] = heights.length;
        for(int i = heights.length -2; i >= 0; i--){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nser[i] = heights.length;
            }else{
                nser[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int width = nser[i] - nsel[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }
}
