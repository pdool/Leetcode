package com.xin.dp.medium;

import java.util.Arrays;

public class Sln2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        //建立与grid一样大的二维表
        int[][] dp = new int[m][n];
        //第一行上面没有数据，所以第一行就是自己本身的代价
        for(int i = 0;i < n;i++){
            dp[0][i] = grid[0][i];
        }
        //题目需要最小路径代价，所以从第二行开始，初始化为Integer.MAX_VALUE，
        //防止干扰正确结果
        for(int i = 1;i < m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //从上到下遍历
        for(int i = 1;i < m;i++){
            //从左到右遍历
            for(int j = 0;j < n;j++){
                //dp[i][j]的数据需要上一行的数据，遍历上一行每一个单元格
                for(int k = 0;k < n;k++){
                    //动态转移方程，一条路径的代价是：所以路径经过的单元格的值之和加上所有移动的代价之和
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][k] + grid[i][j] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        //遍历最后一行取出最小路径代价
        for(int i = 0;i < n;i++){
            ans = Math.min(ans,dp[m - 1][i]);
        }
        //返回
        return ans;
    }
}
