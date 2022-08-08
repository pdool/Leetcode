package com.xin.dp.medium;

import java.util.ConcurrentModificationException;

public class Sln518 {
    //    dp[i] = sum(dp[i]- coins[j])
    // dp[0] 的赋值1
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        //  注意循环变量
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int[] coins1 = {2};
        new Sln518().change(5, coins);
    }
}
