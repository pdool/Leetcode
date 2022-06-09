package com.xin.twopointer.easy;

import java.util.HashSet;
import java.util.Set;

public class Sln202 {
    //  没什么思路，主要是怎么检测死循环 (官方通过set)
    //  根据我们的探索，我们猜测会有以下三种可能。
    //最终会得到 11。
    //最终会进入循环。
    //值会越来越大，最后接近无穷大 这个没想到
    public boolean isHappy(int n) {
        Set<Integer> hasSeen = new HashSet<>();
        while (n != 1 && !hasSeen.contains(n)){
            hasSeen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int x = 0;
        while (n != 0) {
            int d = n%10;
            x += d*d;
            n = n/10;
        }
        return x;
    }

    public static void main(String[] args) {
        new Sln202().isHappy(19);
    }
}
