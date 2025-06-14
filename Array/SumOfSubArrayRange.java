/*Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.*/

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            for(int j = i; j < n; j++){
                minValue = Math.min(minValue, nums[j]);
                maxValue = Math.max(maxValue, nums[j]);
                ans += maxValue - minValue;
            }
        }
        return ans;
    }
}
