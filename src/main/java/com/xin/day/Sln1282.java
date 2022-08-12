package com.xin.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sln1282 {
    //  https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
    public List<List<Integer>> groupThePeople(int[] gs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < gs.length; i++) {
            List<Integer> list = map.getOrDefault(gs[i], new ArrayList<>());
            list.add(i);
            map.put(gs[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            //  可能存在一个数字太多的情况，要分开
            List<Integer> list = map.get(k), cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                cur.add(list.get(i));
                if (cur.size() == k) {
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] groups = {3,3,3,3,3,1,3};
        List<List<Integer>> lists = new Sln1282().groupThePeople(groups);
        System.out.println();
    }
}
