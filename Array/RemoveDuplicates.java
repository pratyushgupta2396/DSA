/*
arr = [1,1,2,2,3,4,4,5]
Unique length = i+1 = 5
First 5 elements = [1,2,3,4,5]
*/
class Solution {
    // Function to remove duplicates and return new length
    int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0;  // pointer for unique elements
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];  // overwrite duplicate position
            }
        }
        return i + 1;  // number of unique elements
    }
}
