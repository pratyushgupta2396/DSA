/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
and each integer appears at most twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                if(set.contains(nums[i])){
                    result.add(nums[i]);
                }else{
                    set.add(nums[i]);
                }
            }
            return result;
    }
}
