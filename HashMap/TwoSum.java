 /*Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1] 
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }else{
                map.put(nums[i], i);
            }
        }
        //return null;
        throw new IllegalArgumentException("No match found");
    }
}
