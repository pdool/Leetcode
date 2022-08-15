package com.xin.backtrack;

import java.util.Arrays;

//  https://leetcode.cn/problems/fair-distribution-of-cookies/
public class Sln2305 {
    int[] cookies = null;
    int n = 0;
    int k = 0;
    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        this.cookies = cookies;
        this.n = cookies.length;
        this.k = k;

        dfs(new int[k], n - 1);
        return res;
    }

    void dfs(int[] bkt, int index) {
        if (index < 0) {
            int max = 0;
            for (int b : bkt) {
                max = Math.max(max, b);
            }
            res = Math.min(max, res);
            return;
        }

        for (int i = 0; i < k; i++) {
            // 在分配第一个ck的时候，分配给哪个小朋友开启的回溯树都是一样的，因此就给第一个小朋友就可以了
            // 这一行可以剪去非常多的子计算
            if (index == n - 1 && i > 0) {
                return;
            }
            bkt[i] += cookies[index];
            dfs(bkt, index - 1);
            bkt[i] -= cookies[index];
        }
    }
}
