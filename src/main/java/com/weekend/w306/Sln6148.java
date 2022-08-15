package com.weekend.w306;
//  https://leetcode.cn/contest/weekly-contest-306/problems/largest-local-values-in-a-matrix/
public class Sln6148 {

    public int[][] largestLocal(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] maxLocal = new int[row -2][col -2];

        for (int i = 0; i < row-2; i++) {
            for (int j = 0; j < col-2; j++) {
                maxLocal[i][j]= getMax(i+1,j+1,grid);
            }
        }
        return  maxLocal;
    }

    private int getMax(int i, int j, int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int x = -1;x<2;x++){
            for (int y = -1;y<2;y++){
                max = Math.max(max ,grid[x+i][y+j]);
            }
        }
        return max;
    }
}
