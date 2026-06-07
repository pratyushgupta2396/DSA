
/*
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
 
Example 1:
Input: nums = [1,3,5,4,7]
Output: 3

Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.
*/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLength = 1;
        int currLength = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            }else{
                currLength = 1;
            }
        }
        return maxLength;
    }
}
