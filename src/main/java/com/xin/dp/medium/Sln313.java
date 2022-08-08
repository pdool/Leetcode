package com.xin.dp.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sln313 {
    //  1、分解问题，减少规模
    //  2、递推公式，在已知一些状态的情况下如何递推
    //  3、第N个 肯定是 可以整除数组的
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    q.add(k * x);
                }
                if (x % k == 0) {
                    break;
                }
            }
        }
        return -1; // never
    }

    public static void main(String[] args) {
        int n = 12;
        int[] nums = {2, 7, 13, 19};
        new Sln313().nthSuperUglyNumber(n, nums);
        System.out.println();
    }
}
