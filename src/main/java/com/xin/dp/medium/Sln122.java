package com.xin.dp.medium;

public class Sln122 {
    public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            //  dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
            //  dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）。
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
    }
}
