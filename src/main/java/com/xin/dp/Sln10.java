package com.xin.dp;

public class Sln10 {
    /**
     * <img src="../../../../resources/10.png"></>
     * <img src="../../../../resources/10-1.png"></>
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        // # 状态更新
        for (int i = 1; i < m + 1; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') { //【题目保证'*'号不会是第一个字符，所以此处有j>=2】
                    if (sc != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
    // 根本不会，看答案
    // 官方答案下面第一个题解不错
    //  https://leetcode.cn/problems/regular-expression-matching/solution/by-flix-musv/
}
