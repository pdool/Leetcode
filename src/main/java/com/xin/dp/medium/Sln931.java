package com.xin.dp.medium;

import java.util.Arrays;

public class Sln931 {
    public int minFallingPathSum(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] dp = new int[rowLen][colLen];
        dp[0] = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    a = dp[i - 1][j - 1];
                }
                if (j + 1 < row.length) {
                    b = dp[i - 1][j + 1];
                }
                int c = dp[i - 1][j];

                dp[i][j] = Math.min(a, Math.min(b, c)) + matrix[i][j];
            }
        }
        int min = Arrays.stream(dp[rowLen - 1]).min().getAsInt();
        return min;

    }
}
