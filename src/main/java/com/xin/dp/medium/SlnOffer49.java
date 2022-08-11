package com.xin.dp.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SlnOffer49 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        //  知识点： 一 去重，用 set
        //  二 最小堆 用 PriorityQueue
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
