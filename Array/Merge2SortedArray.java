/*
int[] a = {1, 3, 5, 7};
int[] b = {2, 4, 6};
 merged → [1, 2, 3, 4, 5, 6, 7]

*/
class Solution {
    public int[] mergeArrays(int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        int[] result = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < m) result[k++] = a[i++];
        while (j < n) result[k++] = b[j++];

        return result;
    }
}
