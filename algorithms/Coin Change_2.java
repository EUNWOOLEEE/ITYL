
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            for (int i = 1; i * coin <= amount; i++)
                dp[i * coin] = i;

            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] == 0) continue;
                
                if (dp[i] == 0 || dp[i] > dp[i - coin] + 1)
                    dp[i] = dp[i - coin] + 1;
            }
        }

        return dp[amount] != 0 ? dp[amount] : -1;
    }
}
