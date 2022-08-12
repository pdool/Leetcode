package com.xin.dp.medium;

//  https://leetcode.cn/problems/cyJERH/
public class SlnOfferII92 {
    //  dp[i][0] 表示 i 的位置是0
    //  dp[i][1] 表示 i 的位置是1
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[][] dp = new int[len][2];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            dp[0][1] = 1;
        }else {
            dp[0][0] = 0;
        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '1') {
                dp[i][0]= dp[i-1][0];
            }else {
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+1;
            }
        }
        return Math.min(dp[len -1][0],dp[len -1][1]);
    }
}
