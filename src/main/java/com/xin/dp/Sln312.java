package com.xin.dp;

import java.util.Arrays;

public class Sln312 {
    public int[][] rec;
    public int[] val;

    // 记忆化搜索
    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        //   val 是nums的复制，在第一位和最后一位增加了一个
        for (int i = 1; i < val.length - 1; i++) {
            val[i] = nums[i - 1];
        }
        //  加上2个占位,防止越界
        val[0] = 1;
        val[n+1] = 1;
        //  对二位数组初始化
        rec = new int[val.length][val.length];
        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i], -1);
        }
        solve(0, n + 1);
        return rec[0][n + 1];
    }

    public int solve(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        //  计算过了，不需要计算，直接取出来
        if (rec[left][right] != -1) {
            return rec[left][right];
        }
        // 放入一个气球
        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right] + solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(sum, rec[left][right]);
        }
        return rec[left][right];
    }

    //  策略是什么？ 似乎是留大的到最后，不对
    //  重写一遍错的地方

    /**
     * 1、solve 解决的是开区间，left 不会和right相交
     * 2、val[left] * val[i] * val[right]  这里是左边界，右边界，不是i-1 i+1,
     *  solve(left, i)  ， solve(i, right) 是其他计算完的，最后只剩三个数 left i right
     * 3、
     *
     */
}

