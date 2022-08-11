package com.xin.dp.medium;

public class SlnOffer47 {
    //  https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //  注意这个特殊处理
                if (i == 0 && j == 0){
                    continue;
                }
                int left = Integer.MIN_VALUE;
                if (j - 1 >= 0) {
                    left = dp[i][j - 1];
                }
                int up = Integer.MIN_VALUE;
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                dp[i][j] = Math.max(left, up) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int i = new SlnOffer47().maxValue(nums);
        System.out.println(i);
    }
}
