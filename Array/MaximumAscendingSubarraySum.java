/*Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
Example 2:

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
*/

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                currentSum = currentSum + nums[i];
            }else{
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
