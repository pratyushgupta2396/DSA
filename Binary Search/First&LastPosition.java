/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

 Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // for first position
        int low = 0;
        int high = nums.length -1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    high = mid-1;
                    first = mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        // for second position
         low = 0;
         high = nums.length -1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    low = mid+1;
                    last = mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        int[] ans = {first, last};
        return ans;
    }
}
