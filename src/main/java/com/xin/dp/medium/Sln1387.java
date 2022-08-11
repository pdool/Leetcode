package com.xin.dp.medium;

import java.util.*;

public class Sln1387 {

    Map<Integer, Integer> f = new HashMap<Integer, Integer>();
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer u, Integer v) {
                if (getF(u) != getF(v)) {
                    return getF(u) - getF(v);
                } else {
                    return u - v;
                }
            }
        });
        return list.get(k - 1);
    }
    //  这一步想多了，没有用递归
    public int getF(int x) {
        if (!f.containsKey(x)) {
            if (x == 1) {
                f.put(x, 0);
            } else if ((x & 1) != 0) {
                f.put(x, getF(x * 3 + 1) + 1);
            } else {
                f.put(x, getF(x / 2) + 1);
            }
        }
        return f.get(x);
    }
}
