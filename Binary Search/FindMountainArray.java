/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

/*

Example 1:

Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
*/
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Find peak
        int start = 0;
        int end = mountainArr.length() -1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                start = mid+1;
            }else{
                end = mid;
            }
        }

         int peak = start;

        // Search in ascending part
        int ans = binarySearch(mountainArr, target, 0, peak, true);
        if (ans != -1) {
            return ans;
        }

        // Search in descending part
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);

    }
    public int binarySearch(MountainArray arr, int target, int start, int end, boolean isAsc){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr.get(mid)){
                return mid;
            }
            if(isAsc){
                if(target < arr.get(mid)){
                    end = mid-1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target < arr.get(mid)){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
