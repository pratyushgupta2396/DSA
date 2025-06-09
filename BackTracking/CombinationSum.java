import java.util.*;

class Solution {
    public void solve(int[] nums, int target, int i, List<List<Integer>> ans, List<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || i >= nums.length) return;

        // Include current element
        curr.add(nums[i]);
        solve(nums, target - nums[i], i, ans, curr); // Use same element again
        curr.remove(curr.size() - 1);

        // Exclude current element
        solve(nums, target, i + 1, ans, curr);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sorting to help with deduplication
        solve(nums, target, 0, ans, new ArrayList<>());
        return ans;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums, target);

        // Optional: Sort inner lists and outer list
        for (int i = 0; i < ans.size(); ++i) {
            Collections.sort(ans.get(i));
        }

        Collections.sort(ans, (o1, o2) -> {
            int m = Math.min(o1.size(), o2.size());
            for (int i = 0; i < m; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return Integer.compare(o1.size(), o2.size());
        });

        for (List<Integer> list : ans) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
