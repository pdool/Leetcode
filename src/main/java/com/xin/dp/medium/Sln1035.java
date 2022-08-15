package com.xin.dp.medium;
//  https://leetcode.cn/problems/uncrossed-lines/
public class Sln1035 {
    //  最长公共序列
    public int maxUncrossedLines(int[] s1, int[] s2) {
        int n = s1.length, m = s2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (s1[i - 1] == s2[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][m];
    }
}
