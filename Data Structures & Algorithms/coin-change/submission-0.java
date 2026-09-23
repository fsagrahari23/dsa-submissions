class Solution {
    public int coinChange(int[] coins, int amount) {

        int ans = solve(coins, 0, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int solve(int[] coins, int idx, int amt) {

        if (amt == 0) {
            return 0;
        }

        if (amt < 0 || idx >= coins.length) {
            return Integer.MAX_VALUE;
        }

        // Take current coin.
        // Don't move idx because we can reuse this coin.
        int take = solve(coins, idx, amt - coins[idx]);

        // Don't take current coin.
        // Move to the next coin.
        int skip = solve(coins, idx + 1, amt);

        int ans = Integer.MAX_VALUE;

        if (take != Integer.MAX_VALUE) {
            ans = Math.min(ans, 1 + take);
        }

        if (skip != Integer.MAX_VALUE) {
            ans = Math.min(ans, skip);
        }

        return ans;
    }
}