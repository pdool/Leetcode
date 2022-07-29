package com.xin.day;

import java.util.*;

public class Sln1331 {
    // 超时了
//    public int[] arrayRankTransform(int[] arr) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i : arr) {
//            set.add(i);
//        }
//        ArrayList<Integer> integers = new ArrayList<>(set);
//        int[] result = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            result[i] = integers.indexOf(arr[i]);
//        }
//        return result;
//    }
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        int[] ans = new int[arr.length];
        for (int a : sortedArr) {
            if (!ranks.containsKey(a)) {
                ranks.put(a, ranks.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
