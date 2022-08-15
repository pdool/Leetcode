package com.weekend.w306;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//  https://leetcode.cn/contest/weekly-contest-306/problems/node-with-highest-edge-score/
public class Sln6149 {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            int target = edges[i];
            Long orDefault = map.getOrDefault(target, 0L);
            map.put(target, orDefault + i);
        }
        Long max = Long.MIN_VALUE;
        int pos = Integer.MAX_VALUE;
        if (map.size() == 0){
            return 0;
        }
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Long v = entry.getValue();
            if (v > max) {
                max = v;
                pos = k;
            } else if (v.equals(max)) {
                pos = Math.min(pos, k);
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 2};
        new Sln6149().edgeScore(nums);
    }
}
