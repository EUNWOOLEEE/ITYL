class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = 1;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            int max = 0;
            
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] < nums[i]) {
                    max = dp[j] > max ? dp[j] : max;

                    if (max == res)
                        break;
                }   

            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
