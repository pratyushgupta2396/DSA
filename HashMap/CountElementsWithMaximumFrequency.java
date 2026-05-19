/*You are given an array nums consisting of positive integers.
Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
The frequency of an element is the number of occurrences of that element in the array.

 

Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
  
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.


* Approach (HashMap Frequency Count)

We need to:
Count frequency of every element
Find maximum frequency
Add frequencies of elements having maximum frequency

*/
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for(int freq : map.values()){
            maxFreq = Math.max(maxFreq, freq);
        }

        int total = 0;
        for(int freq : map.values()){
            if(freq == maxFreq){
                total += maxFreq;
            }
        }
        return total;
    }
}
