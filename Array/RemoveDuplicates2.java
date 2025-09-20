/*
You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once.
Return an array containing these distinct elements in the same order as they appeared.
Examples :

Input: arr[] = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position
and you should return array containing [2] after modifying the array.

Input: arr[] = [1, 2, 4]
Output: [1, 2, 4]
Explation:  As the array does not contain any duplicates so you should return [1, 2, 4].
*/
class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            // Agar list empty hai ya last element alag hai
            if(result.isEmpty() || result.get(result.size()-1) != arr[i]) {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
