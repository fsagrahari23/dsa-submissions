class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] minPro = new int[n];
        int[] maxPro = new int[n];

        minPro[0] = nums[0];
        maxPro[0] = nums[0];

        int ans = nums[0];

        for (int i = 1; i < n; i++) {

            int a = nums[i];
            int b = nums[i] * maxPro[i - 1];
            int c = nums[i] * minPro[i - 1];

            maxPro[i] = Math.max(a, Math.max(b, c));
            minPro[i] = Math.min(a, Math.min(b, c));

            ans = Math.max(ans, maxPro[i]);
        }

        return ans;
    }
}