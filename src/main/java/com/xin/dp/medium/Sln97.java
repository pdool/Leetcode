package com.xin.dp.medium;

public class Sln97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int p = i + j -1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[len1][len2];
    }
    //  qa:
    // 1、数组为什么要 +1
    // 2、为什么字符相等要放在最后面，可否放在if上
}
