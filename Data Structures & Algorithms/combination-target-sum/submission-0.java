class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        ans = new ArrayList<>();

        solve(nums, target, new ArrayList<>(), 0, 0);

        return ans;
    }

    void solve(int[] nums, int target,
               List<Integer> curr,
               int sum,
               int start) {

        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            curr.add(nums[i]);

            // i, not i+1 → number can be reused
            solve(nums, target, curr,
                  sum + nums[i], i);

            curr.remove(curr.size() - 1);
        }
    }
}